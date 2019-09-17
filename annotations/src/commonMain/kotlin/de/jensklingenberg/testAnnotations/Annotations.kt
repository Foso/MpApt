package de.jensklingenberg.testAnnotations


@Target(AnnotationTarget.CLASS)
annotation class TestClass()

@Target(AnnotationTarget.FUNCTION)
annotation class TestFunction()

@Target(AnnotationTarget.PROPERTY)
annotation class TestProperty()

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class TestValueParameter()

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation class TestTypeParameter()

@Target(AnnotationTarget.TYPEALIAS)
annotation class TestTypeAlias()


@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class TestPropertyGetter

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class TestPropertySetter()

@Target(AnnotationTarget.TYPE)
annotation class TestType()

@Target(AnnotationTarget.FILE)
annotation class TestFile(val file: String = "HELLO")

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.EXPRESSION)
annotation class TestExpression(val value: String = "")

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class TestAnnotationClass

@Target(AnnotationTarget.CONSTRUCTOR)
annotation class TestConstructor

@Target(AnnotationTarget.FIELD)
annotation class TestField

@Target(AnnotationTarget.LOCAL_VARIABLE)
annotation class TestLocalVariable





