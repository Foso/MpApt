package de.jensklingenberg.compiler.extension


import de.jensklingenberg.compiler.common.ClassParser
import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import de.jensklingenberg.compiler.kaptmpp.Element
import de.jensklingenberg.compiler.kaptmpp.Platform
import de.jensklingenberg.compiler.kaptmpp.RoundEnvironment
import org.jetbrains.kotlin.codegen.ClassBuilder
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.js.descriptorUtils.nameIfStandardType
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.resolve.jvm.diagnostics.JvmDeclarationOrigin
import org.jetbrains.org.objectweb.asm.FieldVisitor
import org.jetbrains.org.objectweb.asm.MethodVisitor
import org.jetbrains.org.objectweb.asm.Opcodes
import org.jetbrains.org.objectweb.asm.Type
import org.jetbrains.org.objectweb.asm.Type.LONG_TYPE
import org.jetbrains.org.objectweb.asm.commons.InstructionAdapter

internal class DebugLogClassBuilder(
        private val debugLogAnnotations: List<String>,
        delegateBuilder: ClassBuilder,
       val generator: AbstractProcessor
) : DelegatingClassBuilder(delegateBuilder) {

    override fun defineClass(origin: PsiElement?, version: Int, access: Int, name: String, signature: String?, superName: String, interfaces: Array<out String>) {
        super.defineClass(origin, version, access, name, signature, superName, interfaces)
    }

    override fun newField(origin: JvmDeclarationOrigin, access: Int, name: String, desc: String, signature: String?, value: Any?): FieldVisitor {
        return super.newField(origin, access, name, desc, signature, value)
    }

    override fun newMethod(
            origin: JvmDeclarationOrigin,
            /* not used: */ access: Int, name: String, desc: String, signature: String?, exceptions: Array<out String>?
    ): MethodVisitor {
        val original = super.newMethod(origin, access, name, desc, signature, exceptions)

        val function = origin.descriptor as? FunctionDescriptor ?: return original

        ClassParser.parseMethod(function,generator, RoundEnvironment(Platform.JVM))



        if (debugLogAnnotations.none { function.annotations.hasAnnotation(FqName(it)) }) {
            // none of the debugLogAnnotations were on this function; return the original behavior
            if(function.annotations.hasAnnotation(FqName("sample.FunExt"))){
                val func= function.annotations.findAnnotation(FqName("sample.FunExt"))
               val annotation = func?.fqName?.shortName().toString()

              //  generator.process(RoundEnvironment(Platform.JVM).also { it.elements.add(Element.FunctionElement(simpleName = func?.fqName?.shortName()?.asString()?:"",annotation = "de.jensklingenberg.annotation.Extension")) })
            }

            return original
        }

        val ii =1

        return object : MethodVisitor(Opcodes.ASM5, original) {
            override fun visitCode() {
                super.visitCode()
                InstructionAdapter(this).onEnterFunction(function)
            }

            override fun visitInsn(opcode: Int) {
                when (opcode) {
                    // all of the opcodes that result in a return
                    Opcodes.RETURN, // void return
                    Opcodes.ARETURN, // object return
                    Opcodes.IRETURN, Opcodes.FRETURN, Opcodes.LRETURN, Opcodes.DRETURN // int, float, long, double return
                    -> {
                        InstructionAdapter(this).onExitFunction(function)
                    }
                }
                super.visitInsn(opcode)
            }
        }
    }
}

private fun InstructionAdapter.onEnterFunction(function: FunctionDescriptor) {
    getstatic("java/lang/System", "out", "Ljava/io/PrintStream;")

    anew(Type.getType("java/lang/StringBuilder"))
    dup()
    invokespecial("java/lang/StringBuilder", "<init>", "()V", false)

    visitLdcInsn("⇢ ${function.name}(")

    invokevirtual(
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/Object;)Ljava/lang/StringBuilder;",
            false
    )

    function.valueParameters.forEachIndexed { i, parameter ->
        visitLdcInsn("${parameter.name}=")
        invokevirtual("java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)

        val varIndex = i + 1
        when (parameter.type.unwrap().nameIfStandardType.toString()) {
            "Int" -> {
                visitVarInsn(Opcodes.ILOAD, varIndex)
                invokevirtual("java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;", false)
            }
            "Long" -> {
                visitVarInsn(Opcodes.ILOAD, varIndex)
                invokevirtual("java/lang/StringBuilder", "append", "(J)Ljava/lang/StringBuilder;", false)
            }
            else -> {
                visitVarInsn(Opcodes.ALOAD, varIndex)
                invokevirtual(
                        "java/lang/StringBuilder",
                        "append",
                        "(Ljava/lang/Object;)Ljava/lang/StringBuilder;",
                        false
                )
            }
        }

        if (i < function.valueParameters.lastIndex) {
            visitLdcInsn(", ")
        } else {
            // if this is the last one, we should append a close-paren instead of a comma
            visitLdcInsn(")")
        }
        invokevirtual(
                "java/lang/StringBuilder",
                "append",
                "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
                false
        )
    }

    invokevirtual("java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)

    invokevirtual("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)

    invokestatic("java/lang/System", "currentTimeMillis", "()J", false)
    store(6001, LONG_TYPE)
}

private fun InstructionAdapter.onExitFunction(function: FunctionDescriptor) {
    dup()
    getstatic("java/lang/System", "out", "Ljava/io/PrintStream;")
    swap()

    anew(Type.getType("java/lang/StringBuilder"))
    dup()
    invokespecial("java/lang/StringBuilder", "<init>", "()V", false)


    visitLdcInsn("⇠ ${function.name} [ran in ")
    invokevirtual(
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
    )


    // Loads up a new System.currentTimeMillis() and subtracts the local variable #242 from it; which is the
    // System.currentTimeMillis() we stored at the start of this method. So we now have the elapsed time
    // this method took on the top of the stack
    invokestatic("java/lang/System", "currentTimeMillis", "()J", false)
    load(6001, LONG_TYPE)
    sub(LONG_TYPE)
    invokevirtual(
            "java/lang/StringBuilder",
            "append",
            "(J)Ljava/lang/StringBuilder;",
            false
    )


    visitLdcInsn(" ms] = ")
    invokevirtual(
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/String;)Ljava/lang/StringBuilder;",
            false
    )

    swap()
    invokevirtual(
            "java/lang/StringBuilder",
            "append",
            "(Ljava/lang/Object;)Ljava/lang/StringBuilder;",
            false
    )

    // Pop the StringBuilder and call toString() on it which ends up on the stack. Stack: String, System.out
    invokevirtual("java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)

    // Pop the last 2 values (System.out, String) and call println with the value we constructed
    invokevirtual("java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
}
