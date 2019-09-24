package de.jensklingenberg.mpapt;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0003R$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038G@GX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R)\u0010\u000b\u001a\u00070\u0003\u00a2\u0006\u0002\b\f8\u0006@\u0006X\u0087.\u00a2\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0015"}, d2 = {"Lde/jensklingenberg/mpapt/CommonAnnotated;", "", "name", "", "(Ljava/lang/String;)V", "()V", "value", "jens", "getJens", "()Ljava/lang/String;", "setJens", "myProperty", "Lde/jensklingenberg/testAnnotations/TestType;", "myProperty$annotations", "getMyProperty", "setMyProperty", "firstFunction", "", "thirdFunction", "param", "param2", "example"})
@de.jensklingenberg.testAnnotations.TestClass()
public final class CommonAnnotated {
    @org.jetbrains.annotations.NotNull()
    @de.jensklingenberg.testAnnotations.TestField()
    public java.lang.String myProperty;
    
    @de.jensklingenberg.testAnnotations.TestProperty()
    public static void myProperty$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMyProperty() {
        return null;
    }
    
    public final void setMyProperty(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @de.jensklingenberg.testAnnotations.TestPropertyGetter()
    public final java.lang.String getJens() {
        return null;
    }
    
    @de.jensklingenberg.testAnnotations.TestPropertySetter()
    public final void setJens(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @de.jensklingenberg.testAnnotations.TestFunction()
    public final void firstFunction() {
    }
    
    public final void thirdFunction(@org.jetbrains.annotations.NotNull()
    @de.jensklingenberg.testAnnotations.TestValueParameter()
    java.lang.String param, @org.jetbrains.annotations.NotNull()
    @de.jensklingenberg.testAnnotations.TestValueParameter()
    java.lang.String param2) {
    }
    
    @de.jensklingenberg.testAnnotations.TestConstructor()
    public CommonAnnotated() {
        super();
    }
    
    @de.jensklingenberg.testAnnotations.TestConstructor()
    public CommonAnnotated(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        super();
    }
}