import de.jensklingenberg.testAnnotations.*

@TestTypeAlias
typealias WORD = String

@TestAnnotationClass
annotation class JSAnnotationClass


@TestClass
class JSAnnotated @TestConstructor constructor() {

    @TestConstructor
    constructor(name: String) : this()

    @TestProperty
    @TestField
    lateinit var myProperty: @TestType String

    var jens: String
        /**
         * HERE IS A TEXT
         */
        @TestPropertyGetter get() {
            @TestExpression return "Hello"
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

    fun thirdFunction(@TestValueParameter param: String, @TestValueParameter param2: String) = Unit

}