package sample

import annotation.Inject
import javax.annotation.processing.Completion
import javax.annotation.processing.ProcessingEnvironment
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement


class JvmSample() {


    @FunExt
    fun jvmTest() {


    }

}

fun main() {


    TestClass().druck()
}

class TestClass() {

    @Inject
    lateinit var printer: Printer


    init {
    }


    fun druck() {

        println("ee")
    }


}

class Printer() {



    class MyAnnotationProcessor : Processor {
        override fun getCompletions(p0: Element?, p1: AnnotationMirror?, p2: ExecutableElement?, p3: String?): MutableIterable<Completion> {
                return mutableListOf<Completion>()

        }

        override fun getSupportedOptions(): MutableSet<String> {
          return mutableSetOf("Halo")

        }

        override fun process(p0: MutableSet<out TypeElement>?, p1: RoundEnvironment?): Boolean {

            return true

        }



        override fun getSupportedSourceVersion(): SourceVersion {
         return SourceVersion.latest()

        }

        override fun getSupportedAnnotationTypes(): MutableSet<String> {
            return mutableSetOf("Halo")
        }

        override fun init(p0: ProcessingEnvironment?) {


        }

    }


    fun druck() {
        println("ee")
    }


}





