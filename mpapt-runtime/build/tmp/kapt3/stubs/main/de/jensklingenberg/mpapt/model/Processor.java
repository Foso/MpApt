package de.jensklingenberg.mpapt.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&\u00a8\u0006\u0010"}, d2 = {"Lde/jensklingenberg/mpapt/model/Processor;", "", "getSupportedAnnotationTypes", "", "", "getSupportedSourceVersion", "Lde/jensklingenberg/mpapt/model/SourceVersion;", "initProcessor", "", "process", "roundEnvironment", "Lde/jensklingenberg/mpapt/model/RoundEnvironment;", "processingOver", "supportedTargetPlatform", "", "Lde/jensklingenberg/mpapt/model/Platform;", "mpapt-runtime"})
public abstract interface Processor {
    
    /**
     * The list of Annotations that should be detected by the processor.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Set<java.lang.String> getSupportedAnnotationTypes();
    
    @org.jetbrains.annotations.NotNull()
    public abstract de.jensklingenberg.mpapt.model.SourceVersion getSupportedSourceVersion();
    
    public abstract void initProcessor();
    
    /**
     * This gets triggered when a new annotation was found
     */
    public abstract void process(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment);
    
    /**
     * The [Platform]s for which the processor should be enabled.
     * The default is [Platform.ALL]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<de.jensklingenberg.mpapt.model.Platform> supportedTargetPlatform();
    
    public abstract void processingOver();
}