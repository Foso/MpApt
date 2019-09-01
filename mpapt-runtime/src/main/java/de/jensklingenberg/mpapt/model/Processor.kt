package de.jensklingenberg.mpapt.model


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

    /**
     * The [Platform]s for which the processor should be enabled.
     * The default is [Platform.ALL]
     */
    fun supportedTargetPlatform(): List<Platform>

    fun processingOver()


}

