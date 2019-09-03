package de.jensklingenberg.mpapt.model

import org.jetbrains.kotlin.platform.TargetPlatform


interface Processor {

    /**
     * The list of Annotations that should be detected by the processor.
     *
     */
    fun getSupportedAnnotationTypes(): Set<String>

    fun getSupportedSourceVersion(): SourceVersion
    fun initProcessor()

    /**
     * This gets triggered when a new annotation was found
     * */
    fun process(roundEnvironment: RoundEnvironment)

    fun processingOver()


    fun isTargetPlatformSupported() : Boolean

}

