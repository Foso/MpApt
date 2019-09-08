package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.common.findAnnotation
import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.RoundEnvironment
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.checkers.DeclarationCheckerContext
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.module

class DeclarationCheckerImpl(val processor: AbstractProcessor) : DeclarationChecker {
    override fun check(declaration: KtDeclaration, descriptor: DeclarationDescriptor, context: DeclarationCheckerContext) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }
        processor.getSupportedAnnotationTypes().forEach { annoationName ->


            val roundEnvironment = RoundEnvironment()

            when (descriptor) {
                is TypeAliasDescriptor->{
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->
                        roundEnvironment.module = descriptor.module
                        roundEnvironment.elements.add(
                                Element.TypeAliasElement(
                                        annotation = annotation,
                                        typeAliasDescriptor = descriptor
                                )
                        )
                        processor.process(roundEnvironment)

                    }
                }
                is SimpleFunctionDescriptor -> {
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->

                        roundEnvironment.apply {
                            module = descriptor.module
                            elements.add(
                                    Element.FunctionElement(
                                            simpleName = descriptor.name.asString(),
                                            annotation = annotation,
                                            descriptor = descriptor.containingDeclaration as ClassDescriptor,
                                            func = descriptor
                                    )
                            )
                        }

                        processor.process(roundEnvironment)

                    }

                    checkValueParameters(descriptor, annoationName, roundEnvironment)

                }
                is ClassConstructorDescriptor -> {
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->
                        roundEnvironment.module = descriptor.module
                        roundEnvironment.elements.add(
                                Element.ClassConstructorElement(
                                        annotation = annotation,
                                        classConstructorDescriptor = descriptor
                                )
                        )
                        processor.process(roundEnvironment)

                    }

                }
                is ClassDescriptor -> {
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->
                        roundEnvironment.module = descriptor.module
                        roundEnvironment.elements.add(
                                Element.ClassElement(
                                        descriptor.name.asString(),
                                        annotation = annotation,
                                        classDescriptor = descriptor,
                                        pack = descriptor.original.containingDeclaration.fqNameSafe.asString()
                                )
                        )
                        processor.process(roundEnvironment)

                    }
                }
                is PropertyDescriptor -> {
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->
                        roundEnvironment.apply {
                            module = descriptor.module
                            elements.add(
                                    Element.PropertyElement(
                                            descriptor, annotation
                                    )
                            )
                        }

                        processor.process(roundEnvironment)

                    }

                }
                is PropertyGetterDescriptor -> {
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->
                        roundEnvironment.apply {
                            module = descriptor.module
                            elements.add(
                                    Element.PropertyGetterElement(
                                            descriptor, annotation
                                    )
                            )
                        }

                        processor.process(roundEnvironment)

                    }
                }
                is PropertySetterDescriptor -> {
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->
                        roundEnvironment.apply {
                            module = descriptor.module
                            elements.add(
                                    Element.PropertySetterElement(
                                            descriptor, annotation
                                    )
                            )
                        }

                        processor.process(roundEnvironment)

                    }
                }

                is LocalVariableDescriptor -> {
                    descriptor.annotations.findAnnotation(annoationName)?.let { annotation ->
                        roundEnvironment.apply {
                            module = descriptor.module
                            elements.add(
                                    Element.LocalVariableElement(
                                            descriptor, annotation
                                    )
                            )
                        }

                        processor.process(roundEnvironment)

                    }

                }

            }


        }


    }

    private fun checkValueParameters(descriptor: SimpleFunctionDescriptor, annoationName: String, roundEnvironment: RoundEnvironment) {
        descriptor.valueParameters.forEach { parameterDescriptor ->
            if (parameterDescriptor.annotations.hasAnnotation(FqName(annoationName))) {
                val parameterAnnotation = parameterDescriptor.annotations.findAnnotation(FqName(annoationName))

                roundEnvironment.apply {
                    module = descriptor.module
                    elements.add(
                            Element.ValueParameterElement(
                                    annotation = parameterAnnotation
                                    , valueParameterDescriptor = parameterDescriptor

                            )
                    )
                }
                processor.process(roundEnvironment)

            }
        }
    }


}