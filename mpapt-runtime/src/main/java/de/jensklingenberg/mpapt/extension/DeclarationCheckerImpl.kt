package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.common.findAnnotation
import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.RoundEnvironment
import de.jensklingenberg.mpapt.utils.KotlinPlatformValues
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.js.translate.utils.AnnotationsUtils
import org.jetbrains.kotlin.psi.KtAnnotatedExpression
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.blockExpressionsOrSingle
import org.jetbrains.kotlin.resolve.BindingTraceContext
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.checkers.DeclarationCheckerContext
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor

class DeclarationCheckerImpl(val processor: AbstractProcessor) : DeclarationChecker {
    override fun check(declaration: KtDeclaration, descriptor: DeclarationDescriptor, context: DeclarationCheckerContext) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }

        processor.getSupportedAnnotationTypes().forEach { annotationName ->

            val roundEnvironment = RoundEnvironment()

            AnnotationsUtils.getContainingFileAnnotations(context.trace.bindingContext, descriptor).forEach { descriptor ->
                if (descriptor.fqName?.asString().equals(annotationName)) {
                    roundEnvironment.elements.add(
                            Element.FileElement(
                                    annotation = descriptor
                            )
                    )
                    processor.process(roundEnvironment)

                }
            }



            when (descriptor) {

                is TypeAliasDescriptor -> {
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->
                        roundEnvironment.module = descriptor.module
                        roundEnvironment.elements.add(
                                Element.TypeAliasElement(
                                        annotation = annotation,
                                        descriptor = descriptor
                                )
                        )
                        processor.process(roundEnvironment)

                    }
                }
                is SimpleFunctionDescriptor -> {
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->

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


                    checkAnnotatedExpression(declaration, context, annotationName, roundEnvironment, descriptor)
                    checkValueParameters(descriptor, annotationName, roundEnvironment)
                    checkTypeParameters(descriptor, annotationName, roundEnvironment)


                }
                is ClassConstructorDescriptor -> {
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->
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
                is LazyClassDescriptor -> {
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->

                        if (descriptor.kind == ClassKind.ANNOTATION_CLASS) {
                            roundEnvironment.module = descriptor.module
                            roundEnvironment.elements.add(
                                    Element.AnnotationClassElement(
                                            descriptor.name.asString(),
                                            annotation = annotation,
                                            classDescriptor = descriptor,
                                            pack = descriptor.original.containingDeclaration.fqNameSafe.asString()
                                    )
                            )
                            processor.process(roundEnvironment)
                        } else {
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
                }
                is ClassDescriptor -> {
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->
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
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->
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
                    checkField(descriptor, annotationName, roundEnvironment)
                }
                is PropertyGetterDescriptor -> {
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->
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
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->
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
                    descriptor.annotations.findAnnotation(annotationName)?.let { annotation ->
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

    private fun checkAnnotatedExpression(declaration: KtDeclaration, context: DeclarationCheckerContext, annotationName: String, roundEnvironment: RoundEnvironment, descriptor: SimpleFunctionDescriptor) {

        val annotatedExpressions =
                (declaration as KtNamedFunction)
                        .bodyExpression
                        ?.blockExpressionsOrSingle()
                        ?.filterIsInstance<KtAnnotatedExpression>()
                        ?.toList()

        annotatedExpressions?.forEach { ktannotedexp ->
            ktannotedexp.findAnnotation(context.trace as BindingTraceContext, annotationName)?.let {
                roundEnvironment.apply {
                    //  module = descriptor.module
                    elements.add(
                            Element.ExpressionElement(
                                    ktannotedexp, it, descriptor
                            )
                    )
                }

                processor.process(roundEnvironment)
            }

        }


    }

    private fun checkField(descriptor: PropertyDescriptor, annotationName: String, roundEnvironment: RoundEnvironment) {
        descriptor.backingField?.let { fieldDescriptor ->
            fieldDescriptor.findAnnotation(annotationName)?.let { fieldAnnotation ->
                roundEnvironment.apply {
                    module = descriptor.module
                    elements.add(
                            Element.FieldElement(
                                    annotation = fieldAnnotation,
                                    descriptor = fieldDescriptor
                            )
                    )
                }
                processor.process(roundEnvironment)
            }

        }


    }

    private fun checkTypeParameters(descriptor: SimpleFunctionDescriptor, annoationName: String, roundEnvironment: RoundEnvironment) {
        descriptor.typeParameters.forEach { parameterDescriptor ->
            parameterDescriptor.annotations.findAnnotation(annoationName)?.let { parameterAnnotation ->

                roundEnvironment.apply {
                    module = descriptor.module
                    elements.add(
                            Element.TypeParameterElement(
                                    annotation = parameterAnnotation
                                    , typeParameterDescriptor = parameterDescriptor

                            )
                    )
                }
                processor.process(roundEnvironment)

            }
        }

    }

    private fun checkValueParameters(descriptor: SimpleFunctionDescriptor, annoationName: String, roundEnvironment: RoundEnvironment) {
        descriptor.valueParameters.forEach { parameterDescriptor ->
            parameterDescriptor.annotations.findAnnotation(annoationName)?.let { parameterAnnotation ->
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