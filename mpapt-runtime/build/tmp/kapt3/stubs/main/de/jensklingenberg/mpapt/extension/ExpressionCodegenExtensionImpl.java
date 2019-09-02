package de.jensklingenberg.mpapt.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lde/jensklingenberg/mpapt/extension/ExpressionCodegenExtensionImpl;", "Lorg/jetbrains/kotlin/codegen/extensions/ExpressionCodegenExtension;", "abstractProcessor", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "applyFunction", "Lorg/jetbrains/kotlin/codegen/StackValue;", "receiver", "resolvedCall", "Lorg/jetbrains/kotlin/resolve/calls/model/ResolvedCall;", "c", "Lorg/jetbrains/kotlin/codegen/extensions/ExpressionCodegenExtension$Context;", "applyProperty", "generateClassSyntheticParts", "", "codegen", "Lorg/jetbrains/kotlin/codegen/ImplementationBodyCodegen;", "mpapt-runtime"})
public final class ExpressionCodegenExtensionImpl implements org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension {
    private final de.jensklingenberg.mpapt.model.AbstractProcessor abstractProcessor = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.jetbrains.kotlin.codegen.StackValue applyFunction(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.codegen.StackValue receiver, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.calls.model.ResolvedCall<?> resolvedCall, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension.Context c) {
        return null;
    }
    
    @java.lang.Override()
    public void generateClassSyntheticParts(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.codegen.ImplementationBodyCodegen codegen) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.jetbrains.kotlin.codegen.StackValue applyProperty(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.codegen.StackValue receiver, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.calls.model.ResolvedCall<?> resolvedCall, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension.Context c) {
        return null;
    }
    
    public ExpressionCodegenExtensionImpl(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor abstractProcessor) {
        super();
    }
    
    public boolean getShouldGenerateClassSyntheticPartsInLightClassesMode() {
        return false;
    }
}