package de.jensklingenberg

import de.jensklingenberg.testAnnotations.TestClass
import de.jensklingenberg.testAnnotations.TestFunction
import de.jensklingenberg.testAnnotations.TestProperty
import de.jensklingenberg.testAnnotations.TestValueParameter


@TestClass
class JVMSecondAnnotated {



    @TestFunction
    fun what() {

    }

    fun elses(@TestValueParameter param: String) {

    }

}

fun main() {

}

class KodeinApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {

    }
}