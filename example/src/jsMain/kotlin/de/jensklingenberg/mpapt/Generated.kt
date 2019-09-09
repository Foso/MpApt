package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.TestClass
import de.jensklingenberg.testAnnotations.TestTypeParameter

@TestClass
enum class TestEnum{
    HEY,CIAO
}


@TestClass
class Generated<T> {

    var p :  T?=null

    fun   <@TestTypeParameter T> generic(){

    }

    fun   < T> generic2(tt :  T){

    }


}