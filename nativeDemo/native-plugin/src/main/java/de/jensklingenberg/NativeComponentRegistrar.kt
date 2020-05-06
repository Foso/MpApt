package de.jensklingenberg

import com.google.auto.service.AutoService
import com.intellij.mock.MockProject
import de.jensklingenberg.mpapt.common.MpAptProject

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor

/**
 * This is the entry class for a compiler plugin
 */
@AutoService(ComponentRegistrar::class)
open class NativeComponentRegistrar : ComponentRegistrar {

    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        val generator = MpAptTestProcessor()
        val mpapt = MpAptProject(generator,configuration)

        StorageComponentContainerContributor.registerExtension(project,mpapt)
        IrGenerationExtension.registerExtension(project,mpapt)
    }
}


