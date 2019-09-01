package de.jensklingenberg.mpapt.extension.unused

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.codegen.ClassBuilder
import org.jetbrains.kotlin.codegen.ClassBuilderFactory
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.diagnostics.DiagnosticSink
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.jvm.diagnostics.JvmDeclarationOrigin


class DebugLogClassGenerationInterceptor(val test: AbstractProcessor) : ClassBuilderInterceptorExtension {
    /**
     * Our [ClassBuilderFactory] has identical behavior to the [interceptedFactory] parameter given, but returns a
     * [DelegatingClassBuilder] that wraps any [ClassBuilder] returned by [ClassBuilderFactory.newClassBuilder]
     */


    override fun interceptClassBuilderFactory(
            interceptedFactory: ClassBuilderFactory,
            bindingContext: BindingContext,
            diagnostics: DiagnosticSink
    ): ClassBuilderFactory = object : ClassBuilderFactory by interceptedFactory {

        override fun newClassBuilder(origin: JvmDeclarationOrigin): DebugLogClassBuilder {
            // test.log("newClass:    "+ origin.descriptor?.name)
            test.processingOver()

            return DebugLogClassBuilder(interceptedFactory.newClassBuilder(origin), test)
        }
    }


}

