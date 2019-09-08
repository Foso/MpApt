package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.Processor
import org.jetbrains.kotlin.backend.common.BackendContext
import org.jetbrains.kotlin.backend.common.ClassLoweringPass
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid
import org.jetbrains.kotlin.ir.visitors.acceptChildrenVoid
import org.jetbrains.kotlin.ir.visitors.acceptVoid
import org.jetbrains.kotlin.resolve.BindingContext

/**
 * This is only used in Native
 */
class NativeIrGenerationExtension(val processor: Processor) : IrGenerationExtension {

    override fun generate(file: IrFile, backendContext: BackendContext, bindingContext: BindingContext) {
        if (processor.isTargetPlatformSupported()) {
            processor.onProcessingOver()
        }
        SerializerClassLowering(backendContext, bindingContext).runOnFileInOrder(file)

    }
}

fun ClassLoweringPass.runOnFileInOrder(irFile: IrFile) {
    irFile.acceptVoid(object : IrElementVisitorVoid {
        override fun visitElement(element: IrElement) {
            element.acceptChildrenVoid(this)
        }

        override fun visitClass(declaration: IrClass) {
            lower(declaration)
            declaration.acceptChildrenVoid(this)
        }
    })
}

private class SerializerClassLowering(
        val context: BackendContext,
        val bindingContext: BindingContext
) :
        IrElementTransformerVoid(), ClassLoweringPass {
    override fun lower(irClass: IrClass) {
        /**
         *   SerializableIrGenerator.generate(irClass, context, bindingContext)
        SerializerIrGenerator.generate(irClass, context, bindingContext)
        SerializableCompanionIrGenerator.generate(irClass, context, bindingContext)
         *
         * */

    }
}