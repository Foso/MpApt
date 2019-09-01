package de.jensklingenberg


import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.RoundEnvironment
import de.jensklingenberg.mpapt.common.simpleName
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.testAnnotations.*
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.resolve.descriptorUtil.module

class MpAptTestProcessor(configuration: CompilerConfiguration) : AbstractProcessor(configuration) {
    val TAG = "MyAnnotationProcessor"

    val testFunction = TestFunction::class.java.name
    val testProperty = TestProperty::class.java.name
    val testValueParameter = TestValueParameter::class.java.name
    val testPropertyGetter = TestPropertyGetter::class.java.name
    val testPropertySetter = TestPropertySetter::class.java.name
    val testConstructor = TestConstructor::class.java.name
    val testLocalVariable = TestLocalVariable::class.java.name


    override fun process(roundEnvironment: RoundEnvironment) {

        roundEnvironment.getElementsAnnotatedWith(TestClass::class.java.name).forEach {
            when (it) {
                is Element.ClassElement -> {
                    log("Found Class: " + it.classDescriptor.name + " Module: " + it.classDescriptor.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(TestFunction::class.java.name).forEach {
            when (it) {
                is Element.FunctionElement -> {
                    log("Found Function: " + it.func.name + " Module: " + it.func.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testProperty).forEach {
            when (it) {
                is Element.PropertyElement -> {
                    log("Found Property: " + it.propertyDescriptor.name + " Module: " + it.propertyDescriptor.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testValueParameter).forEach {
            when (it) {
                is Element.ValueParameterElement -> {
                    log("Found ValueParameter: " + it.valueParameterDescriptor.name + "in : "+it.valueParameterDescriptor.containingDeclaration.name+" Module: " + it.valueParameterDescriptor.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testPropertyGetter).forEach {
            when (it) {
                is Element.PropertyGetterElement -> {
                    log("Found PropertyGetter: " + it.propertyGetterDescriptor.name + " Module: " + it.propertyGetterDescriptor.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testPropertySetter).forEach {
            when (it) {
                is Element.PropertySetterElement -> {
                    log("Found PropertySetter: " + it.propertySetterDescriptor.name + " Module: " + it.propertySetterDescriptor.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(testConstructor).forEach {
            when (it) {
                is Element.ClassConstructorElement -> {
                    log("Found ClassConstructor: " + it.classConstructorDescriptor.name + " " +it.classConstructorDescriptor.isPrimary+ " Module: " + it.classConstructorDescriptor.module.simpleName() + " platform   " + activeTargetPlatform.first().platformName)
                }
            }
        }


    }


    override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestClass::class.java.name, testFunction, testProperty,testValueParameter,testPropertyGetter,testPropertySetter,testConstructor,testLocalVariable)

    override fun processingOver() {
        log("$TAG***Processor over ***")
    }

}
