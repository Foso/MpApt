package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.Processor
import org.jetbrains.kotlin.backend.common.BackendContext
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.resolve.BindingContext

/**
 * This is only used in Native
 */
class NativeIrGenerationExtension(val processor: Processor) : IrGenerationExtension {

    override fun generate(file: IrFile, backendContext: BackendContext, bindingContext: BindingContext) {
        if(processor.isTargetPlatformSupported()){
            processor.processingOver()
        }
    }
}
