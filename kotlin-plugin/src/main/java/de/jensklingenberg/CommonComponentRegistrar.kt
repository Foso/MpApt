package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.common.MpAptProject
import org.jetbrains.kotlin.cli.common.ExitCode
import org.jetbrains.kotlin.cli.common.arguments.CommonCompilerArguments
import org.jetbrains.kotlin.cli.common.extensions.ShellExtension
import org.jetbrains.kotlin.codegen.ClassBuilderFactory
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.core.JavaCoreProjectEnvironment
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.com.intellij.openapi.vfs.ex.VirtualFileManagerEx
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.diagnostics.DiagnosticSink
import org.jetbrains.kotlin.extensions.CollectAdditionalSourcesExtension
import org.jetbrains.kotlin.extensions.CompilerConfigurationExtension
import org.jetbrains.kotlin.extensions.PreprocessedVirtualFileFactoryExtension
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtImportInfo
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.extensions.ExtraImportsProviderExtension
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
     //   IrGenerationExtension.registerExtension(project, mpapt)

        SyntheticResolveExtension.registerExtension(project, mpapt)
      //  AnalysisHandlerExtension.registerExtension(project,mpapt)
       CompilerConfigurationExtension.registerExtension(project,mpapt)
       ExpressionCodegenExtension.registerExtension(project,mpapt)
        PreprocessedVirtualFileFactoryExtension.registerExtension(project,mpapt)
        //VirtualFileManagerEx.VFS_STRUCTURE_MODIFICATIONS
        ClassBuilderInterceptorExtension.registerExtension(project,mpapt)
        JsSyntheticTranslateExtension.registerExtension(project,mpapt)


    }
}

