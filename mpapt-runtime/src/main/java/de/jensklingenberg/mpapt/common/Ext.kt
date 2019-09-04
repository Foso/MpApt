package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.model.Platform
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.constants.KClassValue


fun MessageCollector.warn(s: String) {
    report(
            CompilerMessageSeverity.WARNING, s
    )
}


/**
 * In the Kotlin Native Compiler the configuration map has an entry with the name "target we compile for"
 * the value is one of [de.jensklingenberg.mpapt.utils.KonanTargetValues]. I don't know how to get the value
 * out of the configuration map other than parse the "toString()". This function will return an empty value
 * when it's used on Kotlin JVM/JS Compiler because the CompilerConfiguration doesn't have that value.
 */
fun CompilerConfiguration.nativeTargetPlatformName(): String {
    val targetKeyword = "target we compile for="
    val mapString = this.toString()
    return if(!mapString.contains(targetKeyword)){
        ""
    }else{
        this.toString().substringAfter(targetKeyword).substringBefore(",")
    }
}

fun MessageCollector.printMessage(diagnosticKind: DiagnosticKind, message: String) {
    when (diagnosticKind) {
        DiagnosticKind.WARNING -> {
            this.report(CompilerMessageSeverity.WARNING,
                    message,
                    CompilerMessageLocation.create(null))
        }
        DiagnosticKind.ERROR -> {
            this.report(CompilerMessageSeverity.ERROR,
                    message,
                    CompilerMessageLocation.create(null))
        }
        DiagnosticKind.MANDATORY_WARNING -> {
            this.report(CompilerMessageSeverity.STRONG_WARNING,
                    message,
                    CompilerMessageLocation.create(null))
        }
        DiagnosticKind.NOTE -> {
            this.report(CompilerMessageSeverity.INFO,
                    message,
                    CompilerMessageLocation.create(null))
        }
        DiagnosticKind.LOG -> {
            this.report(CompilerMessageSeverity.LOGGING,
                    message,
                    CompilerMessageLocation.create(null))
        }
        else -> {
            this.report(CompilerMessageSeverity.WARNING,
                    message,
                    CompilerMessageLocation.create(null))
        }
    }

}


fun KClassValue.getVariableNames(moduleDescriptor: ModuleDescriptor): List<Name> =
        this.getArgumentType(moduleDescriptor).memberScope.getVariableNames().toList()


enum class DiagnosticKind {
    ERROR,
    WARNING,
    MANDATORY_WARNING,
    NOTE,
    LOG,
    OTHER;
}