package de.jensklingenberg.mpapt.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0013\u0014\u0015\u0016\u0017\u0018\u0019B;\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u0082\u0001\u0007\u001a\u001b\u001c\u001d\u001e\u001f \u00a8\u0006!"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element;", "", "simpleName", "", "path", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "pack", "(Ljava/lang/String;Ljava/lang/String;Lde/jensklingenberg/mpapt/model/ElementKind;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Ljava/lang/String;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "getPack", "()Ljava/lang/String;", "getPath", "getSimpleName", "ClassConstructorElement", "ClassElement", "FunctionElement", "PropertyElement", "PropertyGetterElement", "PropertySetterElement", "ValueParameterElement", "Lde/jensklingenberg/mpapt/model/Element$ClassElement;", "Lde/jensklingenberg/mpapt/model/Element$FunctionElement;", "Lde/jensklingenberg/mpapt/model/Element$PropertyElement;", "Lde/jensklingenberg/mpapt/model/Element$ValueParameterElement;", "Lde/jensklingenberg/mpapt/model/Element$PropertyGetterElement;", "Lde/jensklingenberg/mpapt/model/Element$PropertySetterElement;", "Lde/jensklingenberg/mpapt/model/Element$ClassConstructorElement;", "mpapt-runtime"})
public abstract class Element {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String simpleName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String path = null;
    @org.jetbrains.annotations.NotNull()
    private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
    @org.jetbrains.annotations.Nullable()
    private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pack = null;
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getSimpleName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getPack() {
        return null;
    }
    
    private Element(java.lang.String simpleName, java.lang.String path, de.jensklingenberg.mpapt.model.ElementKind elementKind, org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, java.lang.String pack) {
        super();
    }
    
    /**
     * Elements annotated with [AnnotationTarget.CLASS]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00c6\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014\u00a8\u0006%"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element$ClassElement;", "Lde/jensklingenberg/mpapt/model/Element;", "simpleName", "", "path", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "pack", "classDescriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "(Ljava/lang/String;Ljava/lang/String;Lde/jensklingenberg/mpapt/model/ElementKind;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getClassDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "getPack", "()Ljava/lang/String;", "getPath", "getSimpleName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mpapt-runtime"})
    public static final class ClassElement extends de.jensklingenberg.mpapt.model.Element {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String simpleName = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String path = null;
        @org.jetbrains.annotations.NotNull()
        private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
        @org.jetbrains.annotations.Nullable()
        private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String pack = null;
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.ClassDescriptor classDescriptor = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getSimpleName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getPath() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getPack() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ClassDescriptor getClassDescriptor() {
            return null;
        }
        
        public ClassElement(@org.jetbrains.annotations.NotNull()
        java.lang.String simpleName, @org.jetbrains.annotations.NotNull()
        java.lang.String path, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        java.lang.String pack, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassDescriptor classDescriptor) {
            super(null, null, null, null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.ElementKind component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ClassDescriptor component6() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CLASS]
         */
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.Element.ClassElement copy(@org.jetbrains.annotations.NotNull()
        java.lang.String simpleName, @org.jetbrains.annotations.NotNull()
        java.lang.String path, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        java.lang.String pack, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassDescriptor classDescriptor) {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CLASS]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CLASS]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CLASS]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * Elements annotated with [AnnotationTarget.FUNCTION]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u000bH\u00c6\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element$FunctionElement;", "Lde/jensklingenberg/mpapt/model/Element;", "simpleName", "", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "descriptor", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "func", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "(Ljava/lang/String;Lde/jensklingenberg/mpapt/model/ElementKind;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "getFunc", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "getSimpleName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mpapt-runtime"})
    public static final class FunctionElement extends de.jensklingenberg.mpapt.model.Element {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String simpleName = null;
        @org.jetbrains.annotations.NotNull()
        private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
        @org.jetbrains.annotations.Nullable()
        private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor = null;
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.FunctionDescriptor func = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getSimpleName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ClassDescriptor getDescriptor() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.FunctionDescriptor getFunc() {
            return null;
        }
        
        public FunctionElement(@org.jetbrains.annotations.NotNull()
        java.lang.String simpleName, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.FunctionDescriptor func) {
            super(null, null, null, null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.ElementKind component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ClassDescriptor component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.FunctionDescriptor component5() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.FUNCTION]
         */
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.Element.FunctionElement copy(@org.jetbrains.annotations.NotNull()
        java.lang.String simpleName, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassDescriptor descriptor, @org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.FunctionDescriptor func) {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.FUNCTION]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.FUNCTION]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.FUNCTION]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * Elements annotated with [AnnotationTarget.PROPERTY]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element$PropertyElement;", "Lde/jensklingenberg/mpapt/model/Element;", "propertyDescriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Lde/jensklingenberg/mpapt/model/ElementKind;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "getPropertyDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mpapt-runtime"})
    public static final class PropertyElement extends de.jensklingenberg.mpapt.model.Element {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.PropertyDescriptor propertyDescriptor = null;
        @org.jetbrains.annotations.Nullable()
        private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
        @org.jetbrains.annotations.NotNull()
        private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.PropertyDescriptor getPropertyDescriptor() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
            return null;
        }
        
        public PropertyElement(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PropertyDescriptor propertyDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            super(null, null, null, null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.PropertyDescriptor component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.ElementKind component3() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY]
         */
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.Element.PropertyElement copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PropertyDescriptor propertyDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * Elements annotated with [AnnotationTarget.VALUE_PARAMETER]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element$ValueParameterElement;", "Lde/jensklingenberg/mpapt/model/Element;", "valueParameterDescriptor", "Lorg/jetbrains/kotlin/descriptors/ValueParameterDescriptor;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "(Lorg/jetbrains/kotlin/descriptors/ValueParameterDescriptor;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Lde/jensklingenberg/mpapt/model/ElementKind;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "getValueParameterDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ValueParameterDescriptor;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mpapt-runtime"})
    public static final class ValueParameterElement extends de.jensklingenberg.mpapt.model.Element {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.ValueParameterDescriptor valueParameterDescriptor = null;
        @org.jetbrains.annotations.Nullable()
        private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
        @org.jetbrains.annotations.NotNull()
        private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ValueParameterDescriptor getValueParameterDescriptor() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
            return null;
        }
        
        public ValueParameterElement(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ValueParameterDescriptor valueParameterDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            super(null, null, null, null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ValueParameterDescriptor component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.ElementKind component3() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.VALUE_PARAMETER]
         */
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.Element.ValueParameterElement copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ValueParameterDescriptor valueParameterDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.VALUE_PARAMETER]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.VALUE_PARAMETER]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.VALUE_PARAMETER]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * Elements annotated with [AnnotationTarget.PROPERTY_GETTER]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element$PropertyGetterElement;", "Lde/jensklingenberg/mpapt/model/Element;", "propertyGetterDescriptor", "Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "(Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Lde/jensklingenberg/mpapt/model/ElementKind;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "getPropertyGetterDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mpapt-runtime"})
    public static final class PropertyGetterElement extends de.jensklingenberg.mpapt.model.Element {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.PropertyGetterDescriptor propertyGetterDescriptor = null;
        @org.jetbrains.annotations.Nullable()
        private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
        @org.jetbrains.annotations.NotNull()
        private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.PropertyGetterDescriptor getPropertyGetterDescriptor() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
            return null;
        }
        
        public PropertyGetterElement(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PropertyGetterDescriptor propertyGetterDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            super(null, null, null, null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.PropertyGetterDescriptor component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.ElementKind component3() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_GETTER]
         */
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.Element.PropertyGetterElement copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PropertyGetterDescriptor propertyGetterDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_GETTER]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_GETTER]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_GETTER]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * Elements annotated with [AnnotationTarget.PROPERTY_SETTER]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element$PropertySetterElement;", "Lde/jensklingenberg/mpapt/model/Element;", "propertySetterDescriptor", "Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "(Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Lde/jensklingenberg/mpapt/model/ElementKind;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "getPropertySetterDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mpapt-runtime"})
    public static final class PropertySetterElement extends de.jensklingenberg.mpapt.model.Element {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.PropertySetterDescriptor propertySetterDescriptor = null;
        @org.jetbrains.annotations.Nullable()
        private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
        @org.jetbrains.annotations.NotNull()
        private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.PropertySetterDescriptor getPropertySetterDescriptor() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
            return null;
        }
        
        public PropertySetterElement(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PropertySetterDescriptor propertySetterDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            super(null, null, null, null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.PropertySetterDescriptor component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.ElementKind component3() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_SETTER]
         */
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.Element.PropertySetterElement copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.PropertySetterDescriptor propertySetterDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_SETTER]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_SETTER]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.PROPERTY_SETTER]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * Elements annotated with [AnnotationTarget.CONSTRUCTOR]
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lde/jensklingenberg/mpapt/model/Element$ClassConstructorElement;", "Lde/jensklingenberg/mpapt/model/Element;", "classConstructorDescriptor", "Lorg/jetbrains/kotlin/descriptors/ClassConstructorDescriptor;", "annotation", "Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "elementKind", "Lde/jensklingenberg/mpapt/model/ElementKind;", "(Lorg/jetbrains/kotlin/descriptors/ClassConstructorDescriptor;Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;Lde/jensklingenberg/mpapt/model/ElementKind;)V", "getAnnotation", "()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationDescriptor;", "getClassConstructorDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassConstructorDescriptor;", "getElementKind", "()Lde/jensklingenberg/mpapt/model/ElementKind;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mpapt-runtime"})
    public static final class ClassConstructorElement extends de.jensklingenberg.mpapt.model.Element {
        @org.jetbrains.annotations.NotNull()
        private final org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor classConstructorDescriptor = null;
        @org.jetbrains.annotations.Nullable()
        private final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation = null;
        @org.jetbrains.annotations.NotNull()
        private final de.jensklingenberg.mpapt.model.ElementKind elementKind = null;
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor getClassConstructorDescriptor() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor getAnnotation() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public de.jensklingenberg.mpapt.model.ElementKind getElementKind() {
            return null;
        }
        
        public ClassConstructorElement(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor classConstructorDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            super(null, null, null, null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.ElementKind component3() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CONSTRUCTOR]
         */
        @org.jetbrains.annotations.NotNull()
        public final de.jensklingenberg.mpapt.model.Element.ClassConstructorElement copy(@org.jetbrains.annotations.NotNull()
        org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor classConstructorDescriptor, @org.jetbrains.annotations.Nullable()
        org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor annotation, @org.jetbrains.annotations.NotNull()
        de.jensklingenberg.mpapt.model.ElementKind elementKind) {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CONSTRUCTOR]
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CONSTRUCTOR]
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * Elements annotated with [AnnotationTarget.CONSTRUCTOR]
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
}