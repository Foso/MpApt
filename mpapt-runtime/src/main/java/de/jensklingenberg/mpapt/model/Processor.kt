package de.jensklingenberg.mpapt.model

interface Processor {

    var isRunning: Boolean


    /**
     * This gets triggered when a new module(jvmMain,jsMain,..) is getting parsed by the processor
     */
    fun onProcessingStarted()


    /**
     * This get triggered when the last class of a module was parsed.
     */
    fun onProcessingOver()

    /**
     * The list of Annotations that should be detected by the processor.
     *
     */
    fun getSupportedAnnotationTypes(): Set<String>

    /**
     * TODO: Implement check for source version
     */
    fun getSupportedSourceVersion(): SourceVersion

    /**
     * This gets triggered when a new annotation was found
     * */
    fun process(roundEnvironment: RoundEnvironment)

    fun isTargetPlatformSupported(): Boolean

}

