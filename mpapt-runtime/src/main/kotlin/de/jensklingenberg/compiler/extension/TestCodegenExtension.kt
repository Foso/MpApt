package de.jensklingenberg.compiler.extension;


import de.jensklingenberg.compiler.common.ClassParser
import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import de.jensklingenberg.compiler.kaptmpp.Platform
import de.jensklingenberg.compiler.kaptmpp.RoundEnvironment
import org.jetbrains.kotlin.codegen.ImplementationBodyCodegen
import org.jetbrains.kotlin.codegen.StackValue
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall

class TestCodegenExtension(
        private val abstractProcessor: AbstractProcessor) : ExpressionCodegenExtension {


    override fun applyFunction(receiver: StackValue, resolvedCall: ResolvedCall<*>, c: ExpressionCodegenExtension.Context): StackValue? {
        return super.applyFunction(receiver, resolvedCall, c)
    }


    override fun generateClassSyntheticParts(codegen: ImplementationBodyCodegen) {


        val roundEnvironment = RoundEnvironment(Platform.JVM)

        if (abstractProcessor.getSupportedPlatform().contains(Platform.JVM) ||
                abstractProcessor.getSupportedPlatform().contains(Platform.ALL)) {
            val targetClass = codegen.descriptor
              ClassParser.parse(targetClass, abstractProcessor, roundEnvironment)

        } else {
            abstractProcessor.log("----------------------------------------hhh--------------------Hier passiert was")
        }
    }




}
