package de.jensklingenberg.common

import com.google.auto.service.AutoService
import com.intellij.core.CoreApplicationEnvironment
import com.intellij.mock.MockProject
import de.jensklingenberg.mpapt.common.MpAptProject
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.cli.metadata.MetadataSerializer
import org.jetbrains.kotlin.cli.metadata.MetadataSerializerExtension
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
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
        val generator = MpAptTestProcessor(configuration)
        val mpapt = MpAptProject(generator)

        StorageComponentContainerContributor.registerExtension(project,mpapt)
        ExpressionCodegenExtension.registerExtension(project,mpapt)

        SyntheticResolveExtension.registerExtension(project, mpapt)
        ClassBuilderInterceptorExtension.registerExtension(project,mpapt)
        IrGenerationExtension.registerExtension(project,mpapt)
    }
}


