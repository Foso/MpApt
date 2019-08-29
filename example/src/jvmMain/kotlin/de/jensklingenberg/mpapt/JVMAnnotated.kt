@file:TestFile package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.*


@TestTypeAlias typealias MyString = String
@TestAnnotationClass annotation class Ttest

@TestClass
class Annotated @TestConstructor constructor() {

    @TestProperty @TestField
    lateinit var myProperty : @TestType String

    var jens : String @TestPropertyGetter get() {
        return "Hello"
    } @TestPropertySetter set(value) {

    }

    @TestFunction
    fun genFunction(){

    }

    fun genFunctionWithParameters(@TestValueParameter param:String,@TestValueParameter param2:String){

        @TestLocalVariable  val HERERRERERERERER = 1

        @TestExpression when{
            true->{

            }
            false->{

            }
        }
    }

    companion object{

    }
}