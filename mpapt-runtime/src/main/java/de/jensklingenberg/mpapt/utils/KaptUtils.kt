package de.jensklingenberg.mpapt.utils

import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration

/**
 * This file contains extension methods to provide a similar API to the Kapt API.
 * The goal is not to implement the whole Api, because sometimes you can't directly
 * map functions to the compiler API
 */

/**
 * @param diagnosticKind Kinds of diagnostics, for example, error or warning.
 * @param message The message you want to print
 * @param compilerMessageLocation You can use this to print information where an error was raised (path,line,column)
 */
fun MessageCollector.printMessage(diagnosticKind: DiagnosticKind, message: String, compilerMessageLocation: CompilerMessageLocation? = CompilerMessageLocation.create(null)) {
    when (diagnosticKind) {
        DiagnosticKind.WARNING -> {
            this.report(CompilerMessageSeverity.WARNING,
                    message,
                    compilerMessageLocation)
        }
        DiagnosticKind.ERROR -> {
            this.report(CompilerMessageSeverity.ERROR,
                    message,
                    compilerMessageLocation)
        }
        DiagnosticKind.MANDATORY_WARNING -> {
            this.report(CompilerMessageSeverity.STRONG_WARNING,
                    message,
                    compilerMessageLocation)
        }
        DiagnosticKind.NOTE -> {
            this.report(CompilerMessageSeverity.INFO,
                    message,
                    compilerMessageLocation)
        }
        DiagnosticKind.LOG, DiagnosticKind.OTHER -> {
            this.report(CompilerMessageSeverity.LOGGING,
                    message,
                    compilerMessageLocation)
        }
        else -> {
            this.report(CompilerMessageSeverity.WARNING,
                    message,
                    compilerMessageLocation)
        }
    }

}

/**
 * Kinds of diagnostics, for example, error or warning.
 */
enum class DiagnosticKind {
    /**
     * Problem which prevents the tool's normal completion.
     */
    ERROR,
    /**
     * Problem which does not usually prevent the tool from completing normally.
     */
    WARNING,

    /**
     * Problem similar to a warning, but is mandated by the tool's specification.
     */
    MANDATORY_WARNING,

    /**
     * Informative message from the tool.
     */
    NOTE,

    LOG,
    /**
     * Diagnostic which does not fit within the other kinds.
     */
    OTHER;
}

fun CompilerConfiguration.messager(): MessageCollector {
    return this.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY,MessageCollector.NONE)
}