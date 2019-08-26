package de.jensklingenberg.mpapt.extension;


import de.jensklingenberg.mpapt.AbstractProcessor
import de.jensklingenberg.mpapt.model.Platform
import de.jensklingenberg.mpapt.RoundEnvironment
import de.jensklingenberg.mpapt.common.ClassParser
import de.jensklingenberg.mpapt.common.warn
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
        return super.applyFunction(receiver, resolvedCall, c)
    }


    override fun generateClassSyntheticParts(codegen: ImplementationBodyCodegen) {

       // abstractProcessor.messageCollector.warn("----------------------------------------hhh--------------------generateClassSyntheticParts")

        val roundEnvironment = RoundEnvironment(Platform.JVM)

        if (abstractProcessor.getSupportedPlatform().contains(Platform.JVM) ||
                abstractProcessor.getSupportedPlatform().contains(Platform.ALL)
        ) {
           // ClassParser.parse(codegen.descriptor, abstractProcessor, roundEnvironment)

        } else {
         //   abstractProcessor.messageCollector.warn("----------------------------------------hhh--------------------Hier passiert was")
        }
    }

    override fun applyProperty(receiver: StackValue, resolvedCall: ResolvedCall<*>, c: ExpressionCodegenExtension.Context): StackValue? {
        return super.applyProperty(receiver, resolvedCall, c)
    }


}
