package de.jensklingenberg.mpapt

import de.jensklingenberg.mpapt.extension.*
import org.jetbrains.kotlin.analyzer.ModuleInfo
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.com.intellij.openapi.extensions.Extensions
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.descriptors.PackageFragmentProvider
import org.jetbrains.kotlin.extensions.CompilerConfigurationExtension
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.incremental.components.LookupTracker

import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension
import org.jetbrains.kotlin.resolve.jvm.extensions.PackageFragmentProviderExtension
import org.jetbrains.kotlin.storage.StorageManager

class ProcessorProject {

    companion object {


        fun init(project: Project, generator: AbstractProcessor) {
           // PackageFragmentProviderExtension.registerExtension(project,)
            AnalysisHandlerExtension.registerExtension(project, AnalysisHandlerExtensionImpl(generator.messageCollector))
            IrGenerationExtension.registerExtension(project, MyIrGenerationExtension(generator))
            SyntheticResolveExtension.registerExtension(project, SyntheticResolveExtensionImpl(generator))
            DeclarationAttributeAltererExtension.registerExtension(
                    project,
                    MyDeclarationAttributeAltererExtension(generator)
            )
            //  PreprocessedVirtualFileFactoryExtension.registerExtension(project, MetaPreprocessedVirtualFileFactoryExtension())
            DeclarationAttributeAltererExtension.registerExtension(project, object : DeclarationAttributeAltererExtension {})


            CompilerConfigurationExtension.registerExtension(project, CompilerConfigurationExtensionExt(generator))

            IrGenerationExtension.registerExtension(project, MetaIrGenerationExtension(generator))
            ExpressionCodegenExtension.registerExtension(project, ExpressionCodegenExtensionImpl(generator))

        }




    }

}
