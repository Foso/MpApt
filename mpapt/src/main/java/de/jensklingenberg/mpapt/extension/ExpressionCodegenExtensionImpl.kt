package de.jensklingenberg.mpapt.extension;


import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.codegen.ImplementationBodyCodegen
import org.jetbrains.kotlin.codegen.StackValue
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall

class ExpressionCodegenExtensionImpl(
        private val abstractProcessor: AbstractProcessor
) : ExpressionCodegenExtension {


    override fun applyFunction(
            receiver: StackValue,
            resolvedCall: ResolvedCall<*>,
            c: ExpressionCodegenExtension.Context
    ): StackValue? {
        abstractProcessor.log("Apply function")
        return super.applyFunction(receiver, resolvedCall, c)
    }


    override fun generateClassSyntheticParts(codegen: ImplementationBodyCodegen) {
        abstractProcessor.log("Apply function")


    }

    override fun applyProperty(receiver: StackValue, resolvedCall: ResolvedCall<*>, c: ExpressionCodegenExtension.Context): StackValue? {
        return super.applyProperty(receiver, resolvedCall, c)
    }


}
