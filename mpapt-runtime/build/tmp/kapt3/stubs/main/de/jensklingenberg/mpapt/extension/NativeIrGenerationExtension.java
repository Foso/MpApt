package de.jensklingenberg.mpapt.extension;

import java.lang.System;

/**
 * This is only used in Native
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lde/jensklingenberg/mpapt/extension/NativeIrGenerationExtension;", "Lorg/jetbrains/kotlin/backend/common/extensions/IrGenerationExtension;", "processor", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "getProcessor", "()Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "generate", "", "file", "Lorg/jetbrains/kotlin/ir/declarations/IrFile;", "backendContext", "Lorg/jetbrains/kotlin/backend/common/BackendContext;", "bindingContext", "Lorg/jetbrains/kotlin/resolve/BindingContext;", "mpapt-runtime"})
public final class NativeIrGenerationExtension implements org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension {
    @org.jetbrains.annotations.NotNull()
    private final de.jensklingenberg.mpapt.model.AbstractProcessor processor = null;
    
    @java.lang.Override()
    public void generate(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.ir.declarations.IrFile file, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.backend.common.BackendContext backendContext, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingContext bindingContext) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.jensklingenberg.mpapt.model.AbstractProcessor getProcessor() {
        return null;
    }
    
    public NativeIrGenerationExtension(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor processor) {
        super();
    }
}