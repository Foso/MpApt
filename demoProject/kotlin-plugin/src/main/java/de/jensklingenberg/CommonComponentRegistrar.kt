package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.common.MpAptProject
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension

/**
 * This is the entry class for a compiler plugin
 */
@AutoService(ComponentRegistrar::class)
open class CommonComponentRegistrar : ComponentRegistrar {

    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
        val processor = MpAptTestProcessor(configuration)
        val mpapt = MpAptProject(processor)
        StorageComponentContainerContributor.registerExtension(project,mpapt)
        SyntheticResolveExtension.registerExtension(project, mpapt)
        ClassBuilderInterceptorExtension.registerExtension(project,mpapt)
        JsSyntheticTranslateExtension.registerExtension(project,mpapt)
    }
}

