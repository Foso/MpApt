package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.extension.*
import de.jensklingenberg.mpapt.extension.js.JsSyntheticTranslateExtensionExt
import de.jensklingenberg.mpapt.extension.ClassBuilderInterceptorExtensionImpl
import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension

class MpAptProject(abstractProcessor: AbstractProcessor,configuration: CompilerConfiguration) : SyntheticResolveExtension by SyntheticResolveExtensionImpl(abstractProcessor),
        IrGenerationExtension by NativeIrGenerationExtension(abstractProcessor),
        JsSyntheticTranslateExtension by JsSyntheticTranslateExtensionExt(abstractProcessor),
        ClassBuilderInterceptorExtension by ClassBuilderInterceptorExtensionImpl(abstractProcessor),
        StorageComponentContainerContributor by StorageComponentContainerContributorImpl(abstractProcessor),
       // CompilerConfigurationExtension by CompilerConfigurationExtensionExt(abstractProcessor),
        ExpressionCodegenExtension by ExpressionCodegenExtensionImpl(abstractProcessor)
      //  PreprocessedVirtualFileFactoryExtension by MetaPreprocessedVirtualFileFactoryExtension(abstractProcessor)
//   AnalysisHandlerExtension by AnalysisHandlerExtensionImpl(abstractProcessor),
{
    init {
        abstractProcessor.configuration=(configuration)
    }
}