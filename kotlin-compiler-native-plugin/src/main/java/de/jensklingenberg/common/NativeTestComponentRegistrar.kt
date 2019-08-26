package de.jensklingenberg.common

import com.google.auto.service.AutoService
import com.intellij.mock.MockProject
import de.jensklingenberg.mpapt.extension.MyIrGenerationExtension
import de.jensklingenberg.mpapt.extension.SyntheticResolveExtensionImpl
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension

@AutoService(ComponentRegistrar::class)
class NativeTestComponentRegistrar : ComponentRegistrar {


    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {


        val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)

        configuration.kotlinSourceRoots.forEach {
            messageCollector.report(
                    CompilerMessageSeverity.WARNING,
                    "*** Hello from ***" + it.path
            )
        }

        val generator = MpAptTestProcessor(configuration)
        //IrGenerationExtension.registerExtension(project, MyIrGenerationExtension(generator))
        SyntheticResolveExtension.registerExtension(project, SyntheticResolveExtensionImpl(generator))






    }
}


