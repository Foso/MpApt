package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.AbstractProcessor
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.CompilerConfigurationExtension

class CompilerConfigurationExtensionExt(val generator: AbstractProcessor) : CompilerConfigurationExtension {



    override fun updateConfiguration(configuration: CompilerConfiguration) {


    }
}
