package de.jensklingenberg.mpapt.extension;


import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.codegen.*
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.descriptors.impl.referencedProperty
import org.jetbrains.kotlin.incremental.components.NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtClassOrObject
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.descriptorUtil.annotationClass
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe


class ExpressionCodegenExtensionImpl(
        private val abstractProcessor: AbstractProcessor
) : ExpressionCodegenExtension {

    init {
        val i = 1
    }

    override fun applyFunction(
            receiver: StackValue,
            resolvedCall: ResolvedCall<*>,
            c: ExpressionCodegenExtension.Context
    ): StackValue? {
        abstractProcessor.log("Apply function")
        return super.applyFunction(receiver, resolvedCall, c)
    }


    override fun generateClassSyntheticParts(codegen: ImplementationBodyCodegen) {
        val targetClass = codegen.descriptor
        abstractProcessor.log("Reading ${targetClass.name}")
        if (targetClass.isData) {

            return
        }
        val constructor = targetClass.constructors.first { it.isPrimary }
        val properties: List<PropertyDescriptor> = constructor.valueParameters
//        .filter { it.hasValOrVar() }
                .mapNotNull { codegen.bindingContext.get(BindingContext.VALUE_PARAMETER_AS_PROPERTY, it) }

        val redactedParams = properties
                .filter {
                    abstractProcessor.log("Reading param ${it.name}")
                    abstractProcessor.log("Property is ${it.referencedProperty}")
//          abstractProcessor.log("Annotations are ${it.annotations.getAllAnnotations().joinToString { it.annotation.fqName.toString() }}")
                    abstractProcessor.log("Property annotations ${it.referencedProperty?.annotations?.joinToString { it.annotationClass?.fqNameSafe.toString() }}")
                    it.isRedacted
                }
        if (redactedParams.isEmpty()) {
            abstractProcessor.log("No redacted params")
            return
        }

        abstractProcessor.log("Reading params")
        val finalProperties = properties
                .map { it to it.isRedacted }
        abstractProcessor.log("Found params: ${finalProperties.joinToString { it.first.name.asString() }}")

        ToStringGenerator(
                declaration = codegen.myClass as KtClassOrObject,
                classDescriptor = targetClass,
                classAsmType = codegen.typeMapper.mapType(targetClass),
                fieldOwnerContext = codegen.context,
                v = codegen.v,
                generationState = codegen.state,
                abstractProcessor = abstractProcessor
        ).generateToStringMethod(
                targetClass.findToStringFunction()!!,
                properties
        )
    }
}

private fun ClassDescriptor.findToStringFunction(): SimpleFunctionDescriptor? {
    return unsubstitutedMemberScope
            .getContributedFunctions(Name.identifier("toString"), WHEN_GET_ALL_DESCRIPTORS)
            .first()
}

