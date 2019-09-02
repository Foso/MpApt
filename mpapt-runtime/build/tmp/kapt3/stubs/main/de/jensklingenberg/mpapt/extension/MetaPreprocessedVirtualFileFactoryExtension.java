package de.jensklingenberg.mpapt.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lde/jensklingenberg/mpapt/extension/MetaPreprocessedVirtualFileFactoryExtension;", "Lorg/jetbrains/kotlin/extensions/PreprocessedVirtualFileFactoryExtension;", "abstractProcessor", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "createPreprocessedFile", "Lorg/jetbrains/kotlin/com/intellij/openapi/vfs/VirtualFile;", "file", "createPreprocessedLightFile", "Lorg/jetbrains/kotlin/com/intellij/testFramework/LightVirtualFile;", "isPassThrough", "", "mpapt-runtime"})
public final class MetaPreprocessedVirtualFileFactoryExtension implements org.jetbrains.kotlin.extensions.PreprocessedVirtualFileFactoryExtension {
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile createPreprocessedFile(@org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile file) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile createPreprocessedLightFile(@org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile file) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isPassThrough() {
        return false;
    }
    
    public MetaPreprocessedVirtualFileFactoryExtension(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor abstractProcessor) {
        super();
    }
}