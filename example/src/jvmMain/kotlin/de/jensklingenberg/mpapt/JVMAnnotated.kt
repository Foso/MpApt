@file:TestFile("JVMMyTestValue")

package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.*




@TestClass
class Annotated @TestConstructor constructor() {

    @TestConstructor
    constructor(name: String) : this()

    @TestProperty
    @TestField
    lateinit var myProperty: @TestType String

    var jens: String
        @TestPropertyGetter get() {
           @TestExpression return "Hello"
        }
        @TestPropertySetter set(value) {

        }

    @TestFunction fun functionWithExpressionBody() = 1 + 1


    @TestFunction
    fun firstFunction() :@TestType String {
           @TestExpression return ""
    }

    @TestFunction
    fun <@TestTypeParameter T> secondFunction() {

    }

    fun thirdFunction(@TestValueParameter param: @TestType String, @TestValueParameter param2: String) {
      @TestLocalVariable val localHallo :String
    }

}