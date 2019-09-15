package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.common.MpAptProject
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.AnnotationBasedExtension
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension
import org.jetbrains.kotlin.extensions.PreprocessedVirtualFileFactoryExtension
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

/**
 * This is the entry class for a compiler plugin
 */
@AutoService(ComponentRegistrar::class)
open class CommonComponentRegistrar : ComponentRegistrar {

    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
        val processor = MpAptTestProcessor()
        val mpapt = MpAptProject(processor,configuration)
        AnalysisHandlerExtension.registerExtension(project,mpapt)
        StorageComponentContainerContributor.registerExtension(project,mpapt)
        ExpressionCodegenExtension.registerExtension(project,mpapt)
        SyntheticResolveExtension.registerExtension(project, mpapt)
        ClassBuilderInterceptorExtension.registerExtension(project,mpapt)
        JsSyntheticTranslateExtension.registerExtension(project,mpapt)
        DeclarationAttributeAltererExtension.registerExtension(project,mpapt)
        PreprocessedVirtualFileFactoryExtension.registerExtension(project,mpapt)

    }
}
