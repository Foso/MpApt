package de.jensklingenberg.mpapt.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lde/jensklingenberg/mpapt/extension/StorageComponentContainerContributorImpl;", "Lorg/jetbrains/kotlin/extensions/StorageComponentContainerContributor;", "processor", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "getProcessor", "()Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "registerModuleComponents", "", "container", "Lorg/jetbrains/kotlin/container/StorageComponentContainer;", "platform", "Lorg/jetbrains/kotlin/platform/TargetPlatform;", "moduleDescriptor", "Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;", "mpapt-runtime"})
public final class StorageComponentContainerContributorImpl implements org.jetbrains.kotlin.extensions.StorageComponentContainerContributor {
    @org.jetbrains.annotations.NotNull()
    private final de.jensklingenberg.mpapt.model.AbstractProcessor processor = null;
    
    /**
     * Here we get the targetplatform of the module
     */
    @java.lang.Override()
    public void registerModuleComponents(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.container.StorageComponentContainer container, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.platform.TargetPlatform platform, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ModuleDescriptor moduleDescriptor) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.jensklingenberg.mpapt.model.AbstractProcessor getProcessor() {
        return null;
    }
    
    public StorageComponentContainerContributorImpl(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor processor) {
        super();
    }
}