package de.jensklingenberg.mpapt.model

import de.jensklingenberg.mpapt.RoundEnvironment


interface Processor {
    fun getSupportedAnnotationTypes(): Set<String>
    fun getSupportedSourceVersion(): SourceVersion
    fun initProcessor()
    fun process(roundEnvironment: RoundEnvironment): Boolean
    fun getSupportedPlatform(): List<Platform>
    fun processingOver()
}

enum class Platform {
    ALL, JVM, JS, COMMON, UNKNONWN,NATIVE
}