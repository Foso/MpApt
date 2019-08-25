package de.jensklingenberg.mpapt

import de.jensklingenberg.mpapt.model.ProcessingEnvironment
import de.jensklingenberg.mpapt.model.Processor
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration

abstract class AbstractProcessor(val configuration: CompilerConfiguration) : Processor {

    val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)


    val processingEnv = ProcessingEnvironment(messageCollector)

    override fun initProcessor() {}


    fun log(message: String) {
        messageCollector.report(
                CompilerMessageSeverity.WARNING,
                "*** AbstractProcessor: $message",
                CompilerMessageLocation.create(null)
        )
    }

    override fun processingOver() {}


}