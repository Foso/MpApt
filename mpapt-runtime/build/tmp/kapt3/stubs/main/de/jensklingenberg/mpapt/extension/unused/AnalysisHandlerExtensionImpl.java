package de.jensklingenberg.mpapt.extension.unused;

import java.lang.System;

/**
 * I think this is only used on JVM
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J@\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"Lde/jensklingenberg/mpapt/extension/unused/AnalysisHandlerExtensionImpl;", "Lorg/jetbrains/kotlin/resolve/jvm/extensions/AnalysisHandlerExtension;", "messageCollector", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "(Lde/jensklingenberg/mpapt/model/AbstractProcessor;)V", "getMessageCollector", "()Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "analysisCompleted", "Lorg/jetbrains/kotlin/analyzer/AnalysisResult;", "project", "Lorg/jetbrains/kotlin/com/intellij/openapi/project/Project;", "module", "Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;", "bindingTrace", "Lorg/jetbrains/kotlin/resolve/BindingTrace;", "files", "", "Lorg/jetbrains/kotlin/psi/KtFile;", "doAnalysis", "projectContext", "Lorg/jetbrains/kotlin/context/ProjectContext;", "componentProvider", "Lorg/jetbrains/kotlin/container/ComponentProvider;", "mpapt-runtime"})
public final class AnalysisHandlerExtensionImpl implements org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension {
    @org.jetbrains.annotations.NotNull()
    private final de.jensklingenberg.mpapt.model.AbstractProcessor messageCollector = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.jetbrains.kotlin.analyzer.AnalysisResult doAnalysis(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ModuleDescriptor module, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.context.ProjectContext projectContext, @org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends org.jetbrains.kotlin.psi.KtFile> files, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingTrace bindingTrace, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.container.ComponentProvider componentProvider) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public org.jetbrains.kotlin.analyzer.AnalysisResult analysisCompleted(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.openapi.project.Project project, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ModuleDescriptor module, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.BindingTrace bindingTrace, @org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends org.jetbrains.kotlin.psi.KtFile> files) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final de.jensklingenberg.mpapt.model.AbstractProcessor getMessageCollector() {
        return null;
    }
    
    public AnalysisHandlerExtensionImpl(@org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.model.AbstractProcessor messageCollector) {
        super();
    }
}