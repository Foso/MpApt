package de.jensklingenberg.mpapt.extension

import org.jetbrains.kotlin.analyzer.AnalysisResult
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.container.ComponentProvider
import org.jetbrains.kotlin.context.ProjectContext
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

/* This extension simply disables both code analysis and code generation.
 * When aptOnly is true, and any of required kapt options was not passed, we just abort compilation by providing this extension.
 * */
class AbortAnalysisHandlerExtension : AnalysisHandlerExtension {
    override fun doAnalysis(
            project: Project,
            module: ModuleDescriptor,
            projectContext: ProjectContext,
            files: Collection<KtFile>,
            bindingTrace: BindingTrace,
            componentProvider: ComponentProvider
    ): AnalysisResult? {
        return AnalysisResult.success(bindingTrace.bindingContext, module, shouldGenerateCode = false)
    }

    override fun analysisCompleted(
            project: Project,
            module: ModuleDescriptor,
            bindingTrace: BindingTrace,
            files: Collection<KtFile>
    ): AnalysisResult? {
        return AnalysisResult.success(bindingTrace.bindingContext, module, shouldGenerateCode = false)
    }
}