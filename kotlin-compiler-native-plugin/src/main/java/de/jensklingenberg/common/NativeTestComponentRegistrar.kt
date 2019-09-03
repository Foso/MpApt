package de.jensklingenberg.common

import com.google.auto.service.AutoService
import com.intellij.mock.MockProject
import de.jensklingenberg.MpAptTestProcessor
import de.jensklingenberg.mpapt.common.MpAptProject
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension


/**
 * This is the entry class for a compiler plugin
 */
@AutoService(ComponentRegistrar::class)
class NativeTestComponentRegistrar : ComponentRegistrar {

    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        val generator = MpAptTestProcessor()
        val mpapt = MpAptProject(generator,configuration)

        StorageComponentContainerContributor.registerExtension(project,mpapt)
        SyntheticResolveExtension.registerExtension(project, mpapt)
        IrGenerationExtension.registerExtension(project,mpapt)
    }
}


