package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.Processor
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.declarations.IrModuleFragment

/**
 * This is only used in Native
 */
class NativeIrGenerationExtension(val processor: Processor) : IrGenerationExtension {


    override fun generate(moduleFragment: IrModuleFragment, pluginContext: IrPluginContext) {
        if (processor.isTargetPlatformSupported()) {
            processor.onProcessingOver()
        }
    }
}
