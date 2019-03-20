package de.jensklingenberg.compiler.kaptmpp


interface Processor {

    fun getSupportedAnnotationTypes(): Set<String>

    fun getSupportedSourceVersion(): SourceVersion

    fun initProcessor()

    fun process(roundEnvironment: RoundEnvironment): Boolean

    fun getSupportedPlatform(): List<Platform>


}

enum class Platform {
    ALL, JVM, JS, COMMON, UNKNONWN
}