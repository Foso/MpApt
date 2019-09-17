@file:TestFile("LinuxMyTestValue")

package sample

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
    fun firstFunction() {

    }

    @TestFunction
    fun secondFunction() {

        val i = 1
        @TestExpression("Hello") when (i) {
            1 -> {

            }
            else -> {

            }
        }

    }


    fun thirdFunction(@TestValueParameter param: String, @TestValueParameter param2: String) {

    }

}