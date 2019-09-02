package de.jensklingenberg.mpapt.common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\u0005*\u00020\u0003\u00a8\u0006\n"}, d2 = {"getFunctionParameters", "", "Lde/jensklingenberg/mpapt/model/FunctionParameter;", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "getReturnTypeImport", "", "safeAsPsi", "Lorg/jetbrains/kotlin/com/intellij/psi/PsiElement;", "Lorg/jetbrains/kotlin/descriptors/SourceElement;", "simpleName", "mpapt-runtime"})
public final class FunctionDescriptorExtKt {
    
    /**
     * TODO: i dont know how to get the packageName of a function parameter
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<de.jensklingenberg.mpapt.model.FunctionParameter> getFunctionParameters(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.FunctionDescriptor $this$getFunctionParameters) {
        return null;
    }
    
    /**
     * I dont know how to get full package of the return type
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getReturnTypeImport(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.FunctionDescriptor $this$getReturnTypeImport) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String simpleName(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.FunctionDescriptor $this$simpleName) {
        return null;
    }
    
    /**
     * getPsi() on Kotlin Native was always crashing
     */
    @org.jetbrains.annotations.Nullable()
    public static final org.jetbrains.kotlin.com.intellij.psi.PsiElement safeAsPsi(@org.jetbrains.annotations.NotNull()
    org.jetbrains.kotlin.descriptors.SourceElement $this$safeAsPsi) {
        return null;
    }
}