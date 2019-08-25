package de.jensklingenberg.common

import com.google.auto.service.AutoService
import com.intellij.mock.MockProject

import de.jensklingenberg.mpapt.AbstractProcessor
import de.jensklingenberg.mpapt.ProcessorProject
import de.jensklingenberg.mpapt.RoundEnvironment
import de.jensklingenberg.mpapt.extension.*
import de.jensklingenberg.mpapt.model.Platform
import de.jensklingenberg.mpapt.model.SourceVersion
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.CompilerConfigurationExtension
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

@AutoService(ComponentRegistrar::class)
class NativeTestComponentRegistrar : ComponentRegistrar {


    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {


        val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)

        configuration.kotlinSourceRoots.forEach {
            messageCollector.report(
                    CompilerMessageSeverity.WARNING,
                    "*** Hell from ***" + it.path
            )
        }

        val generator = MpAptTestProcessor(configuration)


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



       // AnalysisHandlerExtension.registerExtension(project, AnalysisHandlerExtensionImpl(messageCollector))

        //  JsSyntheticTranslateExtension.registerExtension(project, JsSyntheticTranslateExtensionExt(generator))
        //  Extensions.getArea(project).







    }
}

