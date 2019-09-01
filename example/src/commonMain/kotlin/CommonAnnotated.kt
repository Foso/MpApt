@file:TestFile

package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.*


@TestClass
class CommonAnnotated @TestConstructor constructor() {


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
    fun firstFunction() {

    }

    @TestFunction
    fun secondFunction() {

    }

    fun thirdFunction(@TestValueParameter param: String, @TestValueParameter param2: String) {

    }

}