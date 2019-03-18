package de.jensklingenberg.compiler.kaptmpp

import org.jetbrains.kotlin.cli.common.messages.MessageCollector

class ProcessingEnvironment(open val messager: MessageCollector,var buildFolder:String="",var projectFolder:String =""){

}