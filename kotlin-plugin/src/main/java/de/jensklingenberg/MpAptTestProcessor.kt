package de.jensklingenberg


import de.jensklingenberg.mpapt.AbstractProcessor
import de.jensklingenberg.mpapt.RoundEnvironment
import de.jensklingenberg.mpapt.common.simpleName
import de.jensklingenberg.mpapt.common.warn
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.Platform
import de.jensklingenberg.mpapt.model.SourceVersion
import de.jensklingenberg.testAnnotations.*
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.resolve.descriptorUtil.module

class MpAptTestProcessor(configuration: CompilerConfiguration) : AbstractProcessor(configuration) {
    val TAG = "MyAnnotationProcessor"

    val testClass = TestClass::class.java.name
    val testFunction = TestFunction::class.java.name
    val testProperty = TestProperty::class.java.name
    val testValueParameter = TestValueParameter::class.java.name
    val testPropertyGetter = TestPropertyGetter::class.java.name
    val testPropertySetter = TestPropertySetter::class.java.name
    val testConstructor = TestConstructor::class.java.name


    override fun process(roundEnvironment: RoundEnvironment): Boolean {

        roundEnvironment.getElementsAnnotatedWith(testClass).forEach {
            when (it) {
                is Element.ClassElement -> {
                    log("Found Class: " + it.classDescriptor.name + " Module: " + it.classDescriptor.module.simpleName() + " platform   " + roundEnvironment.platform)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testFunction).forEach {
            when (it) {
                is Element.FunctionElement -> {
                    log("Found Function: " + it.func.name + " Module: " + it.func.module.simpleName() + " platform   " + roundEnvironment.platform)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testProperty).forEach {
            when (it) {
                is Element.PropertyElement -> {
                    log("Found Property: " + it.propertyDescriptor.name + " Module: " + it.propertyDescriptor.module.simpleName() + " platform   " + roundEnvironment.platform)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testValueParameter).forEach {
            when (it) {
                is Element.ValueParameterElement -> {
                    log("Found ValueParameter: " + it.valueParameterDescriptor.name + " Module: " + it.valueParameterDescriptor.module.simpleName() + " platform   " + roundEnvironment.platform)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testPropertyGetter).forEach {
            when (it) {
                is Element.PropertyGetterElement -> {
                    log("Found PropertyGetter: " + it.propertyGetterDescriptor.name + " Module: " + it.propertyGetterDescriptor.module.simpleName() + " platform   " + roundEnvironment.platform)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testPropertySetter).forEach {
            when (it) {
                is Element.PropertySetterElement -> {
                    log("Found PropertySetter: " + it.propertySetterDescriptor.name + " Module: " + it.propertySetterDescriptor.module.simpleName() + " platform   " + roundEnvironment.platform)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testConstructor).forEach {
            when (it) {
                is Element.ClassConstrucorElement -> {
                    log("Found ClassConstrucor: " + it.classConstructorDescriptor.name + " Module: " + it.classConstructorDescriptor.module.simpleName() + " platform   " + roundEnvironment.platform)
                }
            }
        }

        return true
    }


    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latest()

    override fun getSupportedPlatform(): List<Platform> = listOf(Platform.ALL)

    override fun getSupportedAnnotationTypes(): Set<String> = setOf(testClass, testFunction, testProperty,testValueParameter,testPropertyGetter,testPropertySetter,testConstructor)

    override fun processingOver() {
        processingEnv.messager.warn("$TAG***Processor over ***")
    }

}
