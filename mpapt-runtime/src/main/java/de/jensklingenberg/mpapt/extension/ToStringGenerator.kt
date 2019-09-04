package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.annotations.NotNull
import org.jetbrains.kotlin.codegen.*
import org.jetbrains.kotlin.codegen.context.FieldOwnerContext
import org.jetbrains.kotlin.codegen.context.MethodContext
import org.jetbrains.kotlin.codegen.state.GenerationState
import org.jetbrains.kotlin.codegen.state.KotlinTypeMapper
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtClassOrObject
import org.jetbrains.kotlin.resolve.descriptorUtil.builtIns
import org.jetbrains.kotlin.resolve.jvm.AsmTypes
import org.jetbrains.kotlin.resolve.jvm.diagnostics.OtherOrigin
import org.jetbrains.kotlin.resolve.substitutedUnderlyingType
import org.jetbrains.org.objectweb.asm.AnnotationVisitor
import org.jetbrains.org.objectweb.asm.Opcodes
import org.jetbrains.org.objectweb.asm.Type
import org.jetbrains.org.objectweb.asm.commons.InstructionAdapter

class ToStringGenerator(
        private val declaration: KtClassOrObject,
        private val classDescriptor: ClassDescriptor,
        private val classAsmType: Type,
        private val fieldOwnerContext: FieldOwnerContext<*>,
        private val v: ClassBuilder,
        private val generationState: GenerationState,
        val abstractProcessor: AbstractProcessor
) {
    private val typeMapper: KotlinTypeMapper = generationState.typeMapper
    private val underlyingType: JvmKotlinType

    private val toStringDesc: String
        get() = "($firstParameterDesc)Ljava/lang/String;"

    private val firstParameterDesc: String
        get() {
            return if (fieldOwnerContext.contextKind == OwnerKind.ERASED_INLINE_CLASS) {
                underlyingType.type
                        .descriptor
            } else {
                ""
            }
        }

    private val access: Int
        get() {
            var access = Opcodes.ACC_PUBLIC
            if (fieldOwnerContext.contextKind == OwnerKind.ERASED_INLINE_CLASS) {
                access = access or Opcodes.ACC_STATIC
            }

            return access
        }

    init {
        this.underlyingType = JvmKotlinType(
                typeMapper.mapType(classDescriptor),
                classDescriptor.defaultType.substitutedUnderlyingType())
    }

    fun generateToStringMethod(function: FunctionDescriptor,
                               properties: List<PropertyDescriptor>) {
        val context = fieldOwnerContext.intoFunction(function)
        val methodOrigin = OtherOrigin(function)
        val toStringMethodName = mapFunctionName(function)
        val mv = v.newMethod(methodOrigin, access, toStringMethodName, toStringDesc, null, null)

        if (fieldOwnerContext.contextKind != OwnerKind.ERASED_INLINE_CLASS && classDescriptor.isInline) {
            FunctionCodegen.generateMethodInsideInlineClassWrapper(
                    methodOrigin,
                    function,
                    classDescriptor,
                    mv,
                    typeMapper)
            return
        }

        visitEndForAnnotationVisitor(
                mv.visitAnnotation(Type.getDescriptor(NotNull::class.java), false))

        if (!generationState.classBuilderMode.generateBodies) {
            FunctionCodegen.endVisit(mv, toStringMethodName, declaration)
            return
        }

        val iv = InstructionAdapter(mv)

        mv.visitCode()
        AsmUtil.genStringBuilderConstructor(iv)

        var first = true
        for (propertyDescriptor in properties) {
            val isRedacted = propertyDescriptor.isRedacted
            val possibleValue = if (isRedacted) {
                "\"${abstractProcessor.redactedValue}\""
            } else ""
            if (first) {
                iv.aconst(classDescriptor.name.toString() + "(" + propertyDescriptor.name
                        .asString() + "=$possibleValue")
                first = false
            } else {
                iv.aconst(", " + propertyDescriptor.name
                        .asString() + "=$possibleValue")
            }
            AsmUtil.genInvokeAppendMethod(iv, AsmTypes.JAVA_STRING_TYPE, null)

            if (!isRedacted) {
                val type = genOrLoadOnStack(iv, context, propertyDescriptor, 0)
                var asmType = type.type
                var kotlinType = type.kotlinType

                if (asmType.sort == Type.ARRAY) {
                    val elementType = AsmUtil.correctElementType(asmType)
                    if (elementType.sort == Type.OBJECT || elementType.sort == Type.ARRAY) {
                        iv.invokestatic("java/util/Arrays",
                                "toString",
                                "([Ljava/lang/Object;)Ljava/lang/String;",
                                false)
                        asmType = AsmTypes.JAVA_STRING_TYPE
                        kotlinType = function.builtIns
                                .stringType
                    } else if (elementType.sort != Type.CHAR) {
                        iv.invokestatic("java/util/Arrays",
                                "toString",
                                "(" + asmType.descriptor + ")Ljava/lang/String;",
                                false)
                        asmType = AsmTypes.JAVA_STRING_TYPE
                        kotlinType = function.builtIns
                                .stringType
                    }
                }
                AsmUtil.genInvokeAppendMethod(iv, asmType, kotlinType, typeMapper)
            }
        }

        iv.aconst(")")
        AsmUtil.genInvokeAppendMethod(iv, AsmTypes.JAVA_STRING_TYPE, null)

        iv.invokevirtual("java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
        iv.areturn(AsmTypes.JAVA_STRING_TYPE)

        FunctionCodegen.endVisit(mv, toStringMethodName, declaration)
    }

    private fun mapFunctionName(functionDescriptor: FunctionDescriptor): String {
        return typeMapper.mapFunctionName(functionDescriptor, fieldOwnerContext.contextKind)
    }

    private fun visitEndForAnnotationVisitor(annotation: AnnotationVisitor?) {
        annotation?.visitEnd()
    }

    private fun genOrLoadOnStack(iv: InstructionAdapter,
                                 context: MethodContext,
                                 propertyDescriptor: PropertyDescriptor,
                                 index: Int): JvmKotlinType {
        return if (fieldOwnerContext.contextKind == OwnerKind.ERASED_INLINE_CLASS) {
            iv.load(index, underlyingType.type)
            underlyingType
        } else {
            ImplementationBodyCodegen.genPropertyOnStack(iv,
                    context,
                    propertyDescriptor,
                    classAsmType,
                    index,
                    generationState)
        }
    }
}


val PropertyDescriptor.isRedacted: Boolean
    get() {
        return this.annotations.hasAnnotation(REDACTED_CLASS_FQNAME)
    }


// Can't import the annotation here because it's for some reason not visible when the plugin runs
private val REDACTED_CLASS_FQNAME = FqName("de.jensklingenberg.testAnnotations.Redacted")

