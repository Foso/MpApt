package de.jensklingenberg.testAnnotations


@Target(AnnotationTarget.CLASS)
annotation class TestClass()

@Target(AnnotationTarget.FUNCTION)
annotation class TestFunction()

@Target(AnnotationTarget.PROPERTY)
annotation class TestProperty()

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class TestValueParameter()
