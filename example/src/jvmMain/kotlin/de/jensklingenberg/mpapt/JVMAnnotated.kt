@file:TestFile

package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.*


@TestAnnotationClass annotation class JSAnnotationClass


@TestClass
class Annotated @TestConstructor constructor() {

    @TestConstructor
    constructor(name: String) : this()

    @TestProperty
    @TestField
    lateinit var myProperty: @TestType String

    var jens: String
        @TestPropertyGetter get() {
            return "Hello"
        }
        @TestPropertySetter set(value) {

        }

    @TestFunction
    fun firstFunction() :@TestType String {
           @TestExpression return ""
    }

    @TestFunction
    fun secondFunction() {

    }

    fun thirdFunction(@TestValueParameter param: @TestType String, @TestValueParameter param2: String) {
      @TestLocalVariable val localHallo :String
    }

}