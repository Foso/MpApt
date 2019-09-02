package de.jensklingenberg.mpapt.common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u00008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0012\u0010\u0010\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000f\u00a8\u0006\u0012"}, d2 = {"getVariableNames", "", "Lorg/jetbrains/kotlin/name/Name;", "Lorg/jetbrains/kotlin/resolve/constants/KClassValue;", "moduleDescriptor", "Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;", "guessingPlatform", "Lde/jensklingenberg/mpapt/model/Platform;", "Lorg/jetbrains/kotlin/config/CompilerConfiguration;", "printMessage", "", "Lorg/jetbrains/kotlin/cli/common/messages/MessageCollector;", "diagnosticKind", "Lde/jensklingenberg/mpapt/common/DiagnosticKind;", "message", "", "warn", "s", "mpapt-runtime"})
public final class ExtKt {
    
    public static final void warn(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.cli.common.messages.MessageCollector $this$warn, @org.jetbrains.annotations.NotNull()
    java.lang.String s) {
    }
    
    /**
     * /TODO: Find more reliable way
     * I know there is a platform property at Descriptors, but it was always null
     */
    @org.jetbrains.annotations.NotNull()
    public static final de.jensklingenberg.mpapt.model.Platform guessingPlatform(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.config.CompilerConfiguration $this$guessingPlatform) {
        return null;
    }
    
    public static final void printMessage(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.cli.common.messages.MessageCollector $this$printMessage, @org.jetbrains.annotations.NotNull()
    de.jensklingenberg.mpapt.common.DiagnosticKind diagnosticKind, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<org.jetbrains.kotlin.name.Name> getVariableNames(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.resolve.constants.KClassValue $this$getVariableNames, @org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.ModuleDescriptor moduleDescriptor) {
        return null;
    }
}