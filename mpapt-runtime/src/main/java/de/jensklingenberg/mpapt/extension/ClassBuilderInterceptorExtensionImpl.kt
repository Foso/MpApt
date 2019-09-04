package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.Processor
import org.jetbrains.kotlin.codegen.ClassBuilderFactory
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.diagnostics.DiagnosticSink
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.jvm.diagnostics.JvmDeclarationOrigin


class ClassBuilderInterceptorExtensionImpl(val processor: Processor) : ClassBuilderInterceptorExtension {

    override fun interceptClassBuilderFactory(
            interceptedFactory: ClassBuilderFactory,
            bindingContext: BindingContext,
            diagnostics: DiagnosticSink
    ): ClassBuilderFactory = object : ClassBuilderFactory by interceptedFactory {

        override fun newClassBuilder(origin: JvmDeclarationOrigin): DelegatingClassBuilderImpl {
            if(processor.isTargetPlatformSupported()){
                processor.processingOver()
            }

            return DelegatingClassBuilderImpl(interceptedFactory.newClassBuilder(origin))
        }
    }


}

