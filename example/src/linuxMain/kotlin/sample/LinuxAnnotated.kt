@file:TestFile

package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.*


@TestClass
class LinuxAnnotated @TestConstructor constructor() {

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
    fun genFunction() {

    }

    fun genFunctionWithParameters(@TestValueParameter param: String, @TestValueParameter param2: String) {

    }

    companion object {

    }
}