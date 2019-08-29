package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.CompilerConfigurationExtension

class CompilerConfigurationExtensionExt(val generator: AbstractProcessor) : CompilerConfigurationExtension {



    override fun updateConfiguration(configuration: CompilerConfiguration) {


    }
}
