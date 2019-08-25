package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.AbstractProcessor
import de.jensklingenberg.mpapt.RoundEnvironment
import de.jensklingenberg.mpapt.model.Element
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.module

class ClassParser() {


    companion object {

        fun parse(descriptor: ClassDescriptor, generator: AbstractProcessor, roundEnvironment: RoundEnvironment) {

          //  val buildFolder = descriptor.guessingBuildFolder()
            generator.processingEnv.projectFolder = "fffff"//descriptor.guessingProjectFolder()
            generator.processingEnv.buildFolder = "TODO"

            generator.getSupportedAnnotationTypes().forEach { annotation ->
                if (descriptor.hasAnnotation(annotation)) {
                    roundEnvironment.module = descriptor.module
                    roundEnvironment.elements.add(
                            Element.ClassElement(
                                    descriptor.name.asString(),
                                    annotation = descriptor.findAnnotation(annotation),
                                    classDescriptor = descriptor,
                                    pack = descriptor.original.containingDeclaration.fqNameSafe.asString()
                            )
                    )
                    generator.process(roundEnvironment)
                }

            }

        }


        fun parseMethod(
                descriptor: ClassDescriptor,
                function: FunctionDescriptor,
                generator: AbstractProcessor,
                roundEnvironment: RoundEnvironment
        ) {

            //function.valueParameters.get(0).annotations.hasAnnotation(FqName("de.jensklingenberg.ktorfit.TestValueParameter"))

            generator.getSupportedAnnotationTypes().forEach { annotationNames ->


                function.valueParameters.forEach {parameterDescriptor->
                        if(parameterDescriptor.annotations.hasAnnotation(FqName(annotationNames))){
                            val annotation = parameterDescriptor.annotations.findAnnotation(FqName(annotationNames))

                            roundEnvironment.also {
                                it.module = descriptor.module
                                it.elements.add(
                                        Element.ValueParameterElement(
                                                annotation = annotation
                                        ,valueParameterDescriptor = parameterDescriptor

                                        )
                                )
                            }
                            generator.process(roundEnvironment)

                        }
                }

                if (function.annotations.hasAnnotation(FqName(annotationNames))) {
                    val annotation = function.annotations.findAnnotation(FqName(annotationNames))

                    roundEnvironment.also {
                        it.module = descriptor.module
                        it.elements.add(
                                Element.FunctionElement(
                                        simpleName = function.name.asString(),
                                        annotation = annotation,
                                        descriptor = descriptor,
                                        func = function
                                )
                        )
                    }

                    generator.process(roundEnvironment)

                }

            }


        }

        fun parseProperty(propertyDescriptor: PropertyDescriptor, generator: AbstractProcessor, roundEnvironment: RoundEnvironment) {

            generator.getSupportedAnnotationTypes().forEach { annotationNames ->

                if (propertyDescriptor.annotations.hasAnnotation(annotationNames)) {
                    val annotation = propertyDescriptor.annotations.findAnnotation(annotationNames)

                    roundEnvironment.also {
                        it.module = propertyDescriptor.module
                        it.elements.add(
                                Element.PropertyElement(
                                        propertyDescriptor,annotation
                                )
                        )
                    }

                    generator.process(roundEnvironment)

                }

            }

        }

    }


}
