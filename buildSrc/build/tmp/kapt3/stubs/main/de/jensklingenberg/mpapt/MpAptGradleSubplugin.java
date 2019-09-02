package de.jensklingenberg.mpapt;

import java.lang.System;

@com.google.auto.service.AutoService(value = {org.jetbrains.kotlin.gradle.plugin.KotlinGradleSubplugin.class})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003JL\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016\u00a8\u0006\u0019"}, d2 = {"Lde/jensklingenberg/mpapt/MpAptGradleSubplugin;", "Lorg/jetbrains/kotlin/gradle/plugin/KotlinGradleSubplugin;", "Lorg/gradle/api/tasks/compile/AbstractCompile;", "()V", "apply", "", "Lorg/jetbrains/kotlin/gradle/plugin/SubpluginOption;", "project", "Lorg/gradle/api/Project;", "kotlinCompile", "javaCompile", "variantData", "", "androidProjectHandler", "kotlinCompilation", "Lorg/jetbrains/kotlin/gradle/plugin/KotlinCompilation;", "Lorg/jetbrains/kotlin/gradle/dsl/KotlinCommonOptions;", "getCompilerPluginId", "", "getNativeCompilerPluginArtifact", "Lorg/jetbrains/kotlin/gradle/plugin/SubpluginArtifact;", "getPluginArtifact", "isApplicable", "", "task", "mpapt-gradle"})
public final class MpAptGradleSubplugin implements org.jetbrains.kotlin.gradle.plugin.KotlinGradleSubplugin<org.gradle.api.tasks.compile.AbstractCompile> {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<org.jetbrains.kotlin.gradle.plugin.SubpluginOption> apply(@org.jetbrains.annotations.NotNull()
    org.gradle.api.Project project, @org.jetbrains.annotations.NotNull()
    org.gradle.api.tasks.compile.AbstractCompile kotlinCompile, @org.jetbrains.annotations.Nullable()
    org.gradle.api.tasks.compile.AbstractCompile javaCompile, @org.jetbrains.annotations.Nullable()
    java.lang.Object variantData, @org.jetbrains.annotations.Nullable()
    java.lang.Object androidProjectHandler, @org.jetbrains.annotations.Nullable()
    org.jetbrains.kotlin.gradle.plugin.KotlinCompilation<? extends org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions> kotlinCompilation) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isApplicable(@org.jetbrains.annotations.NotNull()
    org.gradle.api.Project project, @org.jetbrains.annotations.NotNull()
    org.gradle.api.tasks.compile.AbstractCompile task) {
        return false;
    }
    
    /**
     * Just needs to be consistent with the key for CommandLineProcessor#pluginId
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getCompilerPluginId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact getPluginArtifact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact getNativeCompilerPluginArtifact() {
        return null;
    }
    
    public MpAptGradleSubplugin() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<org.gradle.api.tasks.compile.AbstractCompile> getSubpluginKotlinTasks(@org.jetbrains.annotations.NotNull()
    org.gradle.api.Project project, @org.jetbrains.annotations.NotNull()
    org.gradle.api.tasks.compile.AbstractCompile kotlinCompile) {
        return null;
    }
}