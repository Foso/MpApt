package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.extension.*
import de.jensklingenberg.mpapt.extension.JsSyntheticTranslateExtensionExt
import de.jensklingenberg.mpapt.extension.AnalysisHandlerExtensionImpl
import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.*
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

class MpAptProject(abstractProcessor: AbstractProcessor, configuration: CompilerConfiguration) :
        SyntheticResolveExtension by SyntheticResolveExtensionImpl(abstractProcessor, ClassParser(abstractProcessor)),
        IrGenerationExtension by NativeIrGenerationExtension(abstractProcessor),
        JsSyntheticTranslateExtension by JsSyntheticTranslateExtensionExt(abstractProcessor),
        ClassBuilderInterceptorExtension by ClassBuilderInterceptorExtensionImpl(abstractProcessor),
        StorageComponentContainerContributor by StorageComponentContainerContributorImpl(abstractProcessor),
        DeclarationAttributeAltererExtension by MyDeclarationAttributeAltererExtension(abstractProcessor),
        CollectAdditionalSourcesExtension by CollectAdditionalSourcesExt(),
        CompilerConfigurationExtension by CompilerConfigurationExtensionExt(abstractProcessor),
        ExpressionCodegenExtension by ExpressionCodegenExtensionImpl(abstractProcessor),
        PreprocessedVirtualFileFactoryExtension by MetaPreprocessedVirtualFileFactoryExtension(abstractProcessor),
        AnalysisHandlerExtension by AnalysisHandlerExtensionImpl(abstractProcessor),
        DeclarationChecker by DeclarationCheckerImpl(){
    init {
        abstractProcessor.configuration = (configuration)
        abstractProcessor.onProcessingStarted()

    }
}