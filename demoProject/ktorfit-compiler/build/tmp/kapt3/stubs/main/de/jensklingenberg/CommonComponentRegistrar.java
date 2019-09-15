package de.jensklingenberg;

import java.lang.System;

/**
 * This is the entry class for a compiler plugin
 */
@com.google.auto.service.AutoService(value = {org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar.class})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lde/jensklingenberg/CommonComponentRegistrar;", "Lorg/jetbrains/kotlin/compiler/plugin/ComponentRegistrar;", "()V", "registerProjectComponents", "", "project", "Lorg/jetbrains/kotlin/com/intellij/mock/MockProject;", "configuration", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "ktorfit-compiler"})
public class CommonComponentRegistrar implements org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar {
    
    @java.lang.Override()
    public void registerProjectComponents(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.com.intellij.mock.MockProject project, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration configuration) {
    }
    
    public CommonComponentRegistrar() {
        super();
    }
}