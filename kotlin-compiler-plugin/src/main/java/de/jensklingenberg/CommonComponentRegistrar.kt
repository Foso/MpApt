package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.compiler.extension.*
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension


@AutoService(ComponentRegistrar::class)
class CommonComponentRegistrar : ComponentRegistrar {
    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {

        val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)
        val generator = ExtensionProcessor(configuration)

        ClassBuilderInterceptorExtension.registerExtension(project, DebugLogClassGenerationInterceptor(emptyList(), generator))
        IrGenerationExtension.registerExtension(project, MyIrGenerationExtension(generator))
        JsSyntheticTranslateExtension.registerExtension(project, Synth(generator))
        SyntheticResolveExtension.registerExtension(project, SynthResol(generator))
        ExpressionCodegenExtension.registerExtension(project, TestCodegenExtension(generator))
        DeclarationAttributeAltererExtension.registerExtension(project, MyDeclarationAttributeAltererExtension(generator))

    }


}
