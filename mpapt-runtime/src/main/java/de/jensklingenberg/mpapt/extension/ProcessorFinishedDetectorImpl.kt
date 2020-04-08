package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.Processor
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.codegen.ClassBuilder
import org.jetbrains.kotlin.codegen.ClassBuilderFactory
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.diagnostics.DiagnosticSink
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment
import org.jetbrains.kotlin.js.translate.context.TranslationContext
import org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor
import org.jetbrains.kotlin.psi.KtPureClassOrObject
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.jvm.diagnostics.JvmDeclarationOrigin

/**
 * This class is used to detect that the [DeclarationCheckerImpl] is finished with processing
 *
 */
class ProcessorFinishedDetectorImpl(val processor: Processor) : ProcessorFinishedDetector {


    /**
     * This is used to detect that the [DeclarationCheckerImpl] is finished with processing on Kotlin Native
     */
    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        if (processor.isTargetPlatformSupported()) {
            processor.onProcessingOver()
        }
    }

    /**
     * This is used to detect that the [DeclarationCheckerImpl] is finished with processing on KotlinJS
     */
    override fun generateClassSyntheticParts(
            declaration: KtPureClassOrObject,
            descriptor: ClassDescriptor,
            translator: DeclarationBodyVisitor,
            context: TranslationContext
    ) {
        if (processor.isTargetPlatformSupported()) {
            processor.onProcessingOver()
        }
    }

    /**
     * This is used to detect that the [DeclarationCheckerImpl] is finished with processing on KotlinJVM
     */
    override fun interceptClassBuilderFactory(
            interceptedFactory: ClassBuilderFactory,
            bindingContext: BindingContext,
            diagnostics: DiagnosticSink
    ): ClassBuilderFactory = object : ClassBuilderFactory by interceptedFactory {

        override fun newClassBuilder(origin: JvmDeclarationOrigin): ClassBuilder {
            if (processor.isTargetPlatformSupported()) {
                processor.onProcessingOver()
            }

            return interceptedFactory.newClassBuilder(origin)
        }
    }
}

