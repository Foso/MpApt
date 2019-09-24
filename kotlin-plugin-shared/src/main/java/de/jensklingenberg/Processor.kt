package de.jensklingenberg

import de.jensklingenberg.mpapt.common.KaptProcessor
import de.jensklingenberg.testAnnotations.TestClass
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

class Processor : KaptProcessor() {

    companion object {
        private const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
        private const val GENERATE_KOTLIN_CODE_OPTION = "generate.kotlin.value"
        private const val GENERATE_ERRORS_OPTION = "generate.error"
        private const val FILE_SUFFIX_OPTION = "suffix"
        const val ON_INIT_MSG = "kotlin processor init"
        const val GENERATED_PACKAGE = "com.tschuchort.compiletesting"
        const val GENERATED_JAVA_CLASS_NAME = "KotlinGeneratedJavaClass"
        const val GENERATED_KOTLIN_CLASS_NAME = "KotlinGeneratedKotlinClass"
    }


    override fun process(p0: MutableSet<out TypeElement>?, p1: RoundEnvironment?): Boolean {
        p1?.getElementsAnnotatedWith(TestClass::class.java)?.forEach {
            println("init")

        }
        return false
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(TestClass::class.java.canonicalName)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun getSupportedOptions() = setOf(
            KAPT_KOTLIN_GENERATED_OPTION_NAME,
            GENERATE_KOTLIN_CODE_OPTION,
            GENERATE_ERRORS_OPTION
    )



}