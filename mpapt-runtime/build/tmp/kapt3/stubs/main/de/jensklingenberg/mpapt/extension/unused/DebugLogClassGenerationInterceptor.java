package de.jensklingenberg.mpapt.extension.unused;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lde/jensklingenberg/mpapt/extension/unused/DebugLogClassGenerationInterceptor;", "Lorg/jetbrains/kotlin/codegen/extensions/ClassBuilderInterceptorExtension;", "test", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "getTest", "()Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "interceptClassBuilderFactory", "Lorg/jetbrains/kotlin/codegen/ClassBuilderFactory;", "interceptedFactory", "bindingContext", "Lorg/jetbrains/kotlin/resolve/BindingContext;", "diagnostics", "Lorg/jetbrains/kotlin/diagnostics/DiagnosticSink;", "mpapt-runtime"})
public final class DebugLogClassGenerationInterceptor implements org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension {
    @org.jetbrains.annotations.NotNull()
    private final de.jensklingenberg.mpapt.model.AbstractProcessor test = null;
    
    /**
     * Our [ClassBuilderFactory] has identical behavior to the [interceptedFactory] parameter given, but returns a
     * [DelegatingClassBuilder] that wraps any [ClassBuilder] returned by [ClassBuilderFactory.newClassBuilder]
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.jetbrains.kotlin.codegen.ClassBuilderFactory interceptClassBuilderFactory(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.codegen.ClassBuilderFactory interceptedFactory, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingContext bindingContext, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.diagnostics.DiagnosticSink diagnostics) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.jensklingenberg.mpapt.model.AbstractProcessor getTest() {
        return null;
    }
    
    public DebugLogClassGenerationInterceptor(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor test) {
        super();
    }
}