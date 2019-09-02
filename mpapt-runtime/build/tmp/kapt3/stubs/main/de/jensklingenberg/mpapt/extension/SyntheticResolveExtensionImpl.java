package de.jensklingenberg.mpapt.extension;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0016J<\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001eH\u0016J<\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020!0\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\""}, d2 = {"Lde/jensklingenberg/mpapt/extension/SyntheticResolveExtensionImpl;", "Lorg/jetbrains/kotlin/resolve/extensions/SyntheticResolveExtension;", "abstractProcessor", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "getAbstractProcessor", "()Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "checkiflast", "", "thisDescriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "state", "", "generateSyntheticClasses", "", "Lorg/jetbrains/kotlin/descriptors/PackageFragmentDescriptor;", "name", "Lorg/jetbrains/kotlin/name/Name;", "ctx", "Lorg/jetbrains/kotlin/resolve/lazy/LazyClassContext;", "declarationProvider", "Lorg/jetbrains/kotlin/resolve/lazy/declarations/PackageMemberDeclarationProvider;", "result", "", "generateSyntheticMethods", "bindingContext", "Lorg/jetbrains/kotlin/resolve/BindingContext;", "fromSupertypes", "", "Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;", "", "generateSyntheticProperties", "Ljava/util/ArrayList;", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "mpapt-runtime"})
public final class SyntheticResolveExtensionImpl implements org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension {
    @org.jetbrains.annotations.NotNull()
    private final de.jensklingenberg.mpapt.model.AbstractProcessor abstractProcessor = null;
    
    @java.lang.Override()
    public void generateSyntheticClasses(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.Name name, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.LazyClassContext ctx, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.declarations.PackageMemberDeclarationProvider declarationProvider, @org.jetbrains.annotations.NotNull()
    java.util.Set<org.jetbrains.kotlin.descriptors.ClassDescriptor> result) {
    }
    
    private final boolean checkiflast(org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, java.lang.String state) {
        return false;
    }
    
    @java.lang.Override()
    public void generateSyntheticMethods(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.Name name, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingContext bindingContext, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor> fromSupertypes, @org.jetbrains.annotations.NotNull()
    java.util.Collection<org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor> result) {
    }
    
    @java.lang.Override()
    public void generateSyntheticProperties(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.Name name, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingContext bindingContext, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<org.jetbrains.kotlin.descriptors.PropertyDescriptor> fromSupertypes, @org.jetbrains.annotations.NotNull()
    java.util.Set<org.jetbrains.kotlin.descriptors.PropertyDescriptor> result) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.jensklingenberg.mpapt.model.AbstractProcessor getAbstractProcessor() {
        return null;
    }
    
    public SyntheticResolveExtensionImpl(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor abstractProcessor) {
        super();
    }
    
    public void generateSyntheticClasses(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.Name name, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.LazyClassContext ctx, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.declarations.ClassMemberDeclarationProvider declarationProvider, @org.jetbrains.annotations.NotNull()
    java.util.Set<org.jetbrains.kotlin.descriptors.ClassDescriptor> result) {
    }
    
    public void addSyntheticSupertypes(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.types.KotlinType> supertypes) {
    }
    
    public void generateSyntheticSecondaryConstructors(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingContext bindingContext, @org.jetbrains.annotations.NotNull()
    java.util.Collection<org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor> result) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public org.jetbrains.kotlin.name.Name getSyntheticCompanionObjectNameIfNeeded(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.jetbrains.kotlin.name.Name> getSyntheticFunctionNames(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.jetbrains.kotlin.name.Name> getSyntheticNestedClassNames(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor) {
        return null;
    }
}