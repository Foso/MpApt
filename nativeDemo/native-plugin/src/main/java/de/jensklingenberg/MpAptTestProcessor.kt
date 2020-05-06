package de.jensklingenberg


import de.jensklingenberg.nativedemo.PrintName
import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.RoundEnvironment

class MpAptTestProcessor() : AbstractProcessor() {
    val TAG = "MyAnnotationProcessor"

    val get = PrintName::class.java.name

    override fun process(roundEnvironment: RoundEnvironment) {
        roundEnvironment.getElementsAnnotatedWith(get).forEach { element ->
            when (element) {
                is Element.ClassElement -> {
                    log("I found @PrintName at classC-> " + element.simpleName)
                }
            }
        }
    }

    override fun isTargetPlatformSupported() = true

    override fun getSupportedAnnotationTypes(): Set<String> = setOf(get)

    override fun processingOver() {
        log("$TAG***Processor over ***")
    }

}
