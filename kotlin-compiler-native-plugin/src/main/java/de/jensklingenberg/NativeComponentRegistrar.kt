package de.jensklingenberg

import com.google.auto.service.AutoService
import com.intellij.mock.MockProject
import de.jensklingenberg.compiler.ProcessorProject
import de.jensklingenberg.compiler.extension.*
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension


@AutoService(ComponentRegistrar::class)
class NativeComponentRegistrar : ComponentRegistrar {

    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {

        if (configuration[KEY_ENABLED] == false) {
            return
        }

        val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)



        messageCollector.report(
                CompilerMessageSeverity.WARNING,
                "*** NativeComponentRegistrar: ->>><  optionname " + configuration[KEY_ENABLED])

        val generator = ExtensionProcessor(configuration)


        ClassBuilderInterceptorExtension.registerExtension(project, DebugLogClassGenerationInterceptor(emptyList(), generator))
        IrGenerationExtension.registerExtension(project, MyIrGenerationExtension(generator))
        JsSyntheticTranslateExtension.registerExtension(project, Synth(generator))
        SyntheticResolveExtension.registerExtension(project, SynthResol(generator))
        ExpressionCodegenExtension.registerExtension(project, TestCodegenExtension(generator))
        DeclarationAttributeAltererExtension.registerExtension(project, MyDeclarationAttributeAltererExtension(generator))


        if (!project.isOpen) {
            generator.processingOver()
        }


    }


}

