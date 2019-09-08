package de.jensklingenberg.mpapt.utils


import org.jetbrains.kotlin.cli.common.messages.CompilerMessageLocation
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector


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


enum class DiagnosticKind {
    ERROR,
    WARNING,
    MANDATORY_WARNING,
    NOTE,
    LOG,
    OTHER;
}