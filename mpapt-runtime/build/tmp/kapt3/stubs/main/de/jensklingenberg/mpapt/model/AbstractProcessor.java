package de.jensklingenberg.mpapt.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "Lde/jensklingenberg/mpapt/model/Processor;", "configuration", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "(Lorg/jetbrains/kotlin/config/CompilerConfiguration;)V", "activeTargetPlatform", "Lorg/jetbrains/kotlin/platform/TargetPlatform;", "getActiveTargetPlatform", "()Lorg/jetbrains/kotlin/platform/TargetPlatform;", "setActiveTargetPlatform", "(Lorg/jetbrains/kotlin/platform/TargetPlatform;)V", "getConfiguration", "()Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "messageCollector", "Lorg/jetbrains/kotlin/cli/common/messages/MessageCollector;", "getMessageCollector", "()Lorg/jetbrains/kotlin/cli/common/messages/MessageCollector;", "processingEnv", "Lde/jensklingenberg/mpapt/model/ProcessingEnvironment;", "getProcessingEnv", "()Lde/jensklingenberg/mpapt/model/ProcessingEnvironment;", "getSupportedSourceVersion", "Lde/jensklingenberg/mpapt/model/SourceVersion;", "initProcessor", "", "log", "message", "", "processingOver", "supportedTargetPlatform", "", "Lde/jensklingenberg/mpapt/model/Platform;", "mpapt-runtime"})
public abstract class AbstractProcessor implements de.jensklingenberg.mpapt.model.Processor {
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.cli.common.messages.MessageCollector messageCollector = null;
    @org.jetbrains.annotations.NotNull()
    private org.jetbrains.kotlin.platform.TargetPlatform activeTargetPlatform;
    @org.jetbrains.annotations.NotNull()
    private final de.jensklingenberg.mpapt.model.ProcessingEnvironment processingEnv = null;
    @org.jetbrains.annotations.NotNull()
    private final org.jetbrains.kotlin.config.CompilerConfiguration configuration = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.cli.common.messages.MessageCollector getMessageCollector() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.platform.TargetPlatform getActiveTargetPlatform() {
        return null;
    }
    
    public final void setActiveTargetPlatform(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.platform.TargetPlatform p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.jensklingenberg.mpapt.model.ProcessingEnvironment getProcessingEnv() {
        return null;
    }
    
    @java.lang.Override()
    public void initProcessor() {
    }
    
    public final void log(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void processingOver() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<de.jensklingenberg.mpapt.model.Platform> supportedTargetPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public de.jensklingenberg.mpapt.model.SourceVersion getSupportedSourceVersion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.kotlin.config.CompilerConfiguration getConfiguration() {
        return null;
    }
    
    public AbstractProcessor(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration configuration) {
        super();
    }
}