package de.jensklingenberg;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\f\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0019\u0010\u000e\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\bR\u0019\u0010\u0010\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u0019\u0010\u0014\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0019\u0010\u0016\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u0019\u0010\u0018\u001a\n \n*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\b\u00a8\u0006$"}, d2 = {"Lde/jensklingenberg/MpAptTestProcessor;", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "configuration", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "(Lorg/jetbrains/kotlin/config/CompilerConfiguration;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "testClass", "kotlin.jvm.PlatformType", "getTestClass", "testConstructor", "getTestConstructor", "testFunction", "getTestFunction", "testLocalVariable", "getTestLocalVariable", "testProperty", "getTestProperty", "testPropertyGetter", "getTestPropertyGetter", "testPropertySetter", "getTestPropertySetter", "testValueParameter", "getTestValueParameter", "getSupportedAnnotationTypes", "", "process", "", "roundEnvironment", "Lde/jensklingenberg/mpapt/model/RoundEnvironment;", "processingOver", "supportedTargetPlatform", "", "Lde/jensklingenberg/mpapt/model/Platform;", "kotlin-plugin-shared"})
public final class MpAptTestProcessor extends de.jensklingenberg.mpapt.model.AbstractProcessor {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "MyAnnotationProcessor";
    private final java.lang.String testClass = null;
    private final java.lang.String testFunction = null;
    private final java.lang.String testProperty = null;
    private final java.lang.String testValueParameter = null;
    private final java.lang.String testPropertyGetter = null;
    private final java.lang.String testPropertySetter = null;
    private final java.lang.String testConstructor = null;
    private final java.lang.String testLocalVariable = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final java.lang.String getTestClass() {
        return null;
    }
    
    public final java.lang.String getTestFunction() {
        return null;
    }
    
    public final java.lang.String getTestProperty() {
        return null;
    }
    
    public final java.lang.String getTestValueParameter() {
        return null;
    }
    
    public final java.lang.String getTestPropertyGetter() {
        return null;
    }
    
    public final java.lang.String getTestPropertySetter() {
        return null;
    }
    
    public final java.lang.String getTestConstructor() {
        return null;
    }
    
    public final java.lang.String getTestLocalVariable() {
        return null;
    }
    
    @java.lang.Override()
    public void process(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<de.jensklingenberg.mpapt.model.Platform> supportedTargetPlatform() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.Set<java.lang.String> getSupportedAnnotationTypes() {
        return null;
    }
    
    @java.lang.Override()
    public void processingOver() {
    }
    
    public MpAptTestProcessor(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration configuration) {
        super(null);
    }
}