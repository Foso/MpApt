package de.jensklingenberg.mpapt.model

import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.platform.SimplePlatform
import org.jetbrains.kotlin.platform.TargetPlatform

abstract class AbstractProcessor() : Processor {
    var configuration: CompilerConfiguration = CompilerConfiguration()

    private fun messageCollector() = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)

    var activeTargetPlatform: TargetPlatform = UnknownTarget()
    val processingEnv = ProcessingEnvironment(messageCollector())

    override fun initProcessor() {}

    fun log(message: String) {
        messageCollector().report(
                CompilerMessageSeverity.WARNING,
                "*** AbstractProcessor: $message"
        )
    }

    override fun processingOver() {}

    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latest()

    override fun isTargetPlatformSupported(): Boolean = isTargetPlatformSupported(activeTargetPlatform)

    /**
     * This method will check if your processor is enabled for the active target platform.
     * By default it's enabled for every platform. You can override it and return true or false for the targets you want to support
     */
    open fun isTargetPlatformSupported(platform: TargetPlatform) = true


}

class UnknownTarget : TargetPlatform(setOf(object : SimplePlatform("Unknown") {
    override val oldFashionedDescription: String
        get() = "Unknown"

}))