package de.jensklingenberg.compiler.extension

import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import org.jetbrains.kotlin.backend.common.BackendContext
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.resolve.BindingContext

class MyIrGenerationExtension(generator: AbstractProcessor) : IrGenerationExtension {


    override fun generate(file: IrFile, backendContext: BackendContext, bindingContext: BindingContext) {
        val f = file

    }
}