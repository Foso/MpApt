package de.jensklingenberg.compiler.kaptmpp

import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.psi.KtClass

abstract class AbstractProcessor(val configuration: CompilerConfiguration) : Processor {

    val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)


    val processingEnv = ProcessingEnvironment(messageCollector)

    override fun initProcessor() {

    }


    fun log(message: String) {
        messageCollector.report(
                CompilerMessageSeverity.WARNING,
                "*** Processor: $message",
                CompilerMessageLocation.create(null))
    }


}