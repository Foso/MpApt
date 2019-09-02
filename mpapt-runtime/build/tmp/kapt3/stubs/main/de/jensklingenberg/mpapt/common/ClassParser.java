package de.jensklingenberg.mpapt.common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lde/jensklingenberg/mpapt/common/ClassParser;", "", "()V", "Companion", "mpapt-runtime"})
public final class ClassParser {
    public static final de.jensklingenberg.mpapt.common.ClassParser.Companion Companion = null;
    
    public ClassParser() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fJ0\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fH\u0002J&\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ(\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\u000f\u00a8\u0006\""}, d2 = {"Lde/jensklingenberg/mpapt/common/ClassParser$Companion;", "", "()V", "checkPropertyGetter", "", "propertyDescriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "processor", "Lde/jensklingenberg/mpapt/model/AbstractProcessor;", "roundEnvironment", "Lde/jensklingenberg/mpapt/model/RoundEnvironment;", "annotationNames", "", "checkPropertySetter", "checkTypeAlias", "", "it", "Lorg/jetbrains/kotlin/descriptors/PackageFragmentDescriptor;", "annotation", "checkValueParameter", "descriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "function", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "checkit", "Lorg/jetbrains/kotlin/descriptors/ClassConstructorDescriptor;", "parse", "parseClassConstructor", "round", "parseMethod", "parsePackage", "thisDescriptor", "parseProperty", "isLastClass", "mpapt-runtime"})
    public static final class Companion {
        
        public final void parse(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.AbstractProcessor processor, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment) {
        }
        
        private final void parseClassConstructor(org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor, de.jensklingenberg.mpapt.model.AbstractProcessor processor, de.jensklingenberg.mpapt.model.RoundEnvironment round, java.lang.String annotation) {
        }
        
        public final void parseMethod(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.FunctionDescriptor function, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.AbstractProcessor processor, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment) {
        }
        
        private final void checkValueParameter(org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor, org.jetbrains.kotlin.descriptors.FunctionDescriptor function, de.jensklingenberg.mpapt.model.AbstractProcessor processor, de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment, java.lang.String annotationNames) {
        }
        
        public final void parseProperty(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PropertyDescriptor propertyDescriptor, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.AbstractProcessor processor, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment, boolean isLastClass) {
        }
        
        private final void checkPropertySetter(org.jetbrains.kotlin.descriptors.PropertyDescriptor propertyDescriptor, de.jensklingenberg.mpapt.model.AbstractProcessor processor, de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment, java.lang.String annotationNames) {
        }
        
        private final void checkPropertyGetter(org.jetbrains.kotlin.descriptors.PropertyDescriptor propertyDescriptor, de.jensklingenberg.mpapt.model.AbstractProcessor processor, de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment, java.lang.String annotationNames) {
        }
        
        public final void parsePackage(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor thisDescriptor, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.AbstractProcessor processor, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.RoundEnvironment roundEnvironment) {
        }
        
        private final boolean checkit(org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor it, java.lang.String annotation) {
            return false;
        }
        
        public final boolean checkTypeAlias(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor it, @org.jetbrains.annotations.NotNull()
        java.lang.String annotation) {
            return false;
        }
        
        private Companion() {
            super();
        }
    }
}