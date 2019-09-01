package de.jensklingenberg.mpapt.extension.unused

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.analyzer.AnalysisResult
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.container.ComponentProvider
import org.jetbrains.kotlin.context.ProjectContext
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension


/**
 * I think this is only used on JVM
 */
class AnalysisHandlerExtensionImpl(val messageCollector: AbstractProcessor) : AnalysisHandlerExtension {

    override fun doAnalysis(
            project: Project,
            module: ModuleDescriptor,
            projectContext: ProjectContext,
            files: Collection<KtFile>,
            bindingTrace: BindingTrace,
            componentProvider: ComponentProvider
    ): AnalysisResult? {
        // messageCollector.warn("*** Started analysis")
        return super.doAnalysis(project, module, projectContext, files, bindingTrace, componentProvider)
    }

    override fun analysisCompleted(
            project: Project,
            module: ModuleDescriptor,
            bindingTrace: BindingTrace,
            files: Collection<KtFile>
    ): AnalysisResult? {
        // messageCollector.warn("*** SOTPPP ANALASyX ")
        return super.analysisCompleted(project, module, bindingTrace, files)
    }
}