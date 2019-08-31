package de.jensklingenberg.mpapt.model

import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.platform.SimplePlatform
import org.jetbrains.kotlin.platform.TargetPlatform

abstract class AbstractProcessor(val configuration: CompilerConfiguration) : Processor {

    val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)

    var activeTargetPlatform: TargetPlatform = UnknownTarget()
    val processingEnv = ProcessingEnvironment(messageCollector)

    override fun initProcessor() {}

    fun log(message: String) {
        messageCollector.report(
                CompilerMessageSeverity.WARNING,
                "*** AbstractProcessor: $message"
        )
    }

    override fun processingOver() {}

    override fun supportedTargetPlatform(): List<Platform> = listOf(Platform.ALL)

    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latest()


}

class UnknownTarget : TargetPlatform(setOf(object : SimplePlatform("Unknown") {
    override val oldFashionedDescription: String
        get() = "Unknown"

}))