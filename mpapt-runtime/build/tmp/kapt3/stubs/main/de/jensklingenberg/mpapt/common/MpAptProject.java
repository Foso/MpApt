package de.jensklingenberg.mpapt.common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096\u0001J!\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J)\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J7\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\'H\u0096\u0001J7\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020)2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\'H\u0096\u0001J=\u0010*\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020-0.H\u0096\u0001J=\u0010/\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u000201002\f\u0010&\u001a\b\u0012\u0004\u0012\u0002010\'H\u0096\u0001J\'\u00102\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010&\u001a\b\u0012\u0004\u0012\u0002030.H\u0096\u0001J\u0013\u00104\u001a\u0004\u0018\u00010!2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020!0,2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020!0,2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J!\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010:\u001a\u00020;H\u0096\u0001J!\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0096\u0001\u00a8\u0006C"}, d2 = {"Lde/jensklingenberg/mpapt/common/MpAptProject;", "Lorg/jetbrains/kotlin/resolve/extensions/SyntheticResolveExtension;", "Lorg/jetbrains/kotlin/backend/common/extensions/IrGenerationExtension;", "Lorg/jetbrains/kotlin/js/translate/extensions/JsSyntheticTranslateExtension;", "Lorg/jetbrains/kotlin/codegen/extensions/ClassBuilderInterceptorExtension;", "Lorg/jetbrains/kotlin/extensions/StorageComponentContainerContributor;", "abstractProcessor", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "addSyntheticSupertypes", "", "thisDescriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "supertypes", "", "Lorg/jetbrains/kotlin/types/KotlinType;", "generate", "file", "Lorg/jetbrains/kotlin/ir/declarations/IrFile;", "backendContext", "Lorg/jetbrains/kotlin/backend/common/BackendContext;", "bindingContext", "Lorg/jetbrains/kotlin/resolve/BindingContext;", "generateClassSyntheticParts", "declaration", "Lorg/jetbrains/kotlin/psi/KtPureClassOrObject;", "descriptor", "translator", "Lorg/jetbrains/kotlin/js/translate/declaration/DeclarationBodyVisitor;", "context", "Lorg/jetbrains/kotlin/js/translate/context/TranslationContext;", "generateSyntheticClasses", "name", "Lorg/jetbrains/kotlin/name/Name;", "ctx", "Lorg/jetbrains/kotlin/resolve/lazy/LazyClassContext;", "declarationProvider", "Lorg/jetbrains/kotlin/resolve/lazy/declarations/ClassMemberDeclarationProvider;", "result", "", "Lorg/jetbrains/kotlin/descriptors/PackageFragmentDescriptor;", "Lorg/jetbrains/kotlin/resolve/lazy/declarations/PackageMemberDeclarationProvider;", "generateSyntheticMethods", "fromSupertypes", "", "Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;", "", "generateSyntheticProperties", "Ljava/util/ArrayList;", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "generateSyntheticSecondaryConstructors", "Lorg/jetbrains/kotlin/descriptors/ClassConstructorDescriptor;", "getSyntheticCompanionObjectNameIfNeeded", "getSyntheticFunctionNames", "getSyntheticNestedClassNames", "interceptClassBuilderFactory", "Lorg/jetbrains/kotlin/codegen/ClassBuilderFactory;", "interceptedFactory", "diagnostics", "Lorg/jetbrains/kotlin/diagnostics/DiagnosticSink;", "registerModuleComponents", "container", "Lorg/jetbrains/kotlin/container/StorageComponentContainer;", "platform", "Lorg/jetbrains/kotlin/platform/TargetPlatform;", "moduleDescriptor", "Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;", "mpapt-runtime"})
public final class MpAptProject implements org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension, org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension, org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension, org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension, org.jetbrains.kotlin.extensions.StorageComponentContainerContributor {
    
    public MpAptProject(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor abstractProcessor) {
        super();
    }
    
    @java.lang.Override()
    public void addSyntheticSupertypes(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    java.util.List<org.jetbrains.kotlin.types.KotlinType> supertypes) {
    }
    
    @java.lang.Override()
    public void generateSyntheticClasses(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.Name name, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.LazyClassContext ctx, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.declarations.ClassMemberDeclarationProvider declarationProvider, @org.jetbrains.annotations.NotNull()
    java.util.Set<org.jetbrains.kotlin.descriptors.ClassDescriptor> result) {
    }
    
    @java.lang.Override()
    public void generateSyntheticClasses(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.name.Name name, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.LazyClassContext ctx, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.lazy.declarations.PackageMemberDeclarationProvider declarationProvider, @org.jetbrains.annotations.NotNull()
    java.util.Set<org.jetbrains.kotlin.descriptors.ClassDescriptor> result) {
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
    
    @java.lang.Override()
    public void generateSyntheticSecondaryConstructors(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingContext bindingContext, @org.jetbrains.annotations.NotNull()
    java.util.Collection<org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor> result) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.jetbrains.kotlin.name.Name getSyntheticCompanionObjectNameIfNeeded(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<org.jetbrains.kotlin.name.Name> getSyntheticFunctionNames(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<org.jetbrains.kotlin.name.Name> getSyntheticNestedClassNames(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor thisDescriptor) {
        return null;
    }
    
    @java.lang.Override()
    public void generate(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.ir.declarations.IrFile file, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.backend.common.BackendContext backendContext, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingContext bindingContext) {
    }
    
    @java.lang.Override()
    public void generateClassSyntheticParts(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.psi.KtPureClassOrObject declaration, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor translator, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.js.translate.context.TranslationContext context) {
    }
    
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
    
    /**
     * Here we get the targetplatform of the module
     */
    @java.lang.Override()
    public void registerModuleComponents(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.container.StorageComponentContainer container, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.platform.TargetPlatform platform, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ModuleDescriptor moduleDescriptor) {
    }
}