package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.CompilerConfigurationExtension

class CompilerConfigurationExtensionExt(val generator: AbstractProcessor) : CompilerConfigurationExtension {


    override fun updateConfiguration(configuration: CompilerConfiguration) {
        generator.log("updateConfiguration")
        //configuration.addKotlinSourceRoot("end",false)
        //configuration.addKotlinSourceRoot("/home/jens/Code/2019/MpApt/mpapt/src/main/java/de/jensklingenberg/mpapt/model/End.kt",false)
        val it = 1
    }
}
