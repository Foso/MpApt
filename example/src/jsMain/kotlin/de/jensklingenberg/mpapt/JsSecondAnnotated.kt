package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.*


@TestClass
class JsSecondAnnotated {

    @TestProperty
    val name:  String? = null

    @TestFunction
    fun what() {

    }

    fun elses(@TestValueParameter param: String) {

    }



}