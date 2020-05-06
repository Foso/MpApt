package de.jensklingenberg


import de.jensklingenberg.nativedemo.PrintName
import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.RoundEnvironment
import org.jetbrains.kotlin.resolve.annotations.argumentValue

class MpAptTestProcessor() : AbstractProcessor() {
    val TAG = "MyAnnotationProcessor"

    val get = PrintName::class.java.name

    override fun process(roundEnvironment: RoundEnvironment) {
        roundEnvironment.getElementsAnnotatedWith(get).forEach { element ->
            when (element) {
                is Element.ClassElement -> {
                    log("I found @PrintName at class-> " + element.simpleName + " with the value: "+element.annotation?.argumentValue("value"))
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
