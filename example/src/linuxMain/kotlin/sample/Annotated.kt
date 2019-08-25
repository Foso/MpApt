package sample

import de.jensklingenberg.testAnnotations.TestClass
import de.jensklingenberg.testAnnotations.TestFunction
import de.jensklingenberg.testAnnotations.TestProperty
import de.jensklingenberg.testAnnotations.TestValueParameter


@TestClass
class Annotated{

    @TestProperty
    val name : String?=null

    @TestFunction
    fun genFunction(){

    }

    fun genFunctionWithParameters(@TestValueParameter param:String){

    }


}