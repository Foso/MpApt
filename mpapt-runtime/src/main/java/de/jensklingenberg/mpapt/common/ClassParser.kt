package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.Processor
import de.jensklingenberg.mpapt.model.RoundEnvironment
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter
import org.jetbrains.kotlin.resolve.scopes.getDescriptorsFiltered


interface AnnotationDetector {
    fun parseClass(descriptor: ClassDescriptor, roundEnvironment: RoundEnvironment)
    fun parseMethod(descriptor: ClassDescriptor, function: FunctionDescriptor, roundEnvironment: RoundEnvironment)
    fun parseProperty(propertyDescriptor: PropertyDescriptor, roundEnvironment: RoundEnvironment)
}

class ClassParser(val processor: Processor) : AnnotationDetector {

    override fun parseClass(descriptor: ClassDescriptor, roundEnvironment: RoundEnvironment) {
        processor.getSupportedAnnotationTypes().forEach { annotation ->
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
                processor.process(roundEnvironment)
            }

            parseClassConstructor(descriptor, roundEnvironment, annotation)
        }

    }


    private fun parseClassConstructor(descriptor: ClassDescriptor, round: RoundEnvironment, annotation: String) {
        try {
            descriptor.constructors.forEach {
                if (hasAnnnotations(it, annotation)) {
                    val annotatedConstructors =
                            descriptor.constructors.filter { constructor -> constructor.hasAnnotation(annotation) }

                    annotatedConstructors.forEach { annotatedConstructor ->

                        val annotationDesc = annotatedConstructor.annotations.findAnnotation(annotation)

                        round.module = descriptor.module
                        round.elements.add(
                                Element.ClassConstructorElement(
                                        classConstructorDescriptor = annotatedConstructor,
                                        annotation = annotationDesc

                                )
                        )
                        processor.process(round)
                    }

                }
            }
        } catch (e: Exception) {
            println(e)
        }

    }

    override fun parseMethod(
            descriptor: ClassDescriptor,
            function: FunctionDescriptor,
            roundEnvironment: RoundEnvironment
    ) {

        processor.getSupportedAnnotationTypes().forEach { annotationNames ->

            checkValueParameter(descriptor,
                    function,
                    roundEnvironment,
                    annotationNames)


            if (function.annotations.hasAnnotation(FqName(annotationNames))) {
                val annotation = function.annotations.findAnnotation(FqName(annotationNames))

                roundEnvironment.apply {
                    module = descriptor.module
                    elements.add(
                            Element.FunctionElement(
                                    simpleName = function.name.asString(),
                                    annotation = annotation,
                                    descriptor = descriptor,
                                    func = function
                            )
                    )
                }

                processor.process(roundEnvironment)

            }

        }


    }


    private fun checkValueParameter(descriptor: ClassDescriptor, function: FunctionDescriptor, roundEnvironment: RoundEnvironment, annotationNames: String) {
        function.valueParameters.forEach { parameterDescriptor ->
            if (parameterDescriptor.annotations.hasAnnotation(FqName(annotationNames))) {
                val annotation = parameterDescriptor.annotations.findAnnotation(FqName(annotationNames))

                roundEnvironment.apply {
                    module = descriptor.module
                    elements.add(
                            Element.ValueParameterElement(
                                    annotation = annotation
                                    , valueParameterDescriptor = parameterDescriptor

                            )
                    )
                }
                processor.process(roundEnvironment)

            }
        }

    }


    override fun parseProperty(propertyDescriptor: PropertyDescriptor, roundEnvironment: RoundEnvironment) {

        processor.getSupportedAnnotationTypes().forEachIndexed { index, annotationNames ->

            checkPropertyGetter(propertyDescriptor, roundEnvironment, annotationNames)
            checkPropertySetter(propertyDescriptor, roundEnvironment, annotationNames)

            if (propertyDescriptor.annotations.hasAnnotation(annotationNames)) {
                val annotation = propertyDescriptor.annotations.findAnnotation(annotationNames)

                roundEnvironment.apply {
                    module = propertyDescriptor.module
                    elements.add(
                            Element.PropertyElement(
                                    propertyDescriptor, annotation
                            )
                    )
                }

                processor.process(roundEnvironment)

            }

        }


    }

    private fun checkPropertySetter(propertyDescriptor: PropertyDescriptor, roundEnvironment: RoundEnvironment, annotationNames: String) {
        propertyDescriptor.setter?.let { setterDesc ->
            if (setterDesc.annotations.hasAnnotation(annotationNames)) {
                val annotation = setterDesc.annotations.findAnnotation(annotationNames)

                roundEnvironment.apply {
                    module = propertyDescriptor.module
                    elements.add(
                            Element.PropertySetterElement(
                                    setterDesc, annotation
                            )
                    )
                }

                processor.process(roundEnvironment)
            }
        }
    }

    private fun checkPropertyGetter(propertyDescriptor: PropertyDescriptor, roundEnvironment: RoundEnvironment, annotationNames: String) {
        propertyDescriptor.getter?.let { setterDesc ->
            if (setterDesc.annotations.hasAnnotation(annotationNames)) {
                val annotation = setterDesc.annotations.findAnnotation(annotationNames)

                roundEnvironment.apply {
                    module = propertyDescriptor.module
                    elements.add(
                            Element.PropertyGetterElement(
                                    setterDesc,
                                    annotation
                            )
                    )
                }

                processor.process(roundEnvironment)
            }
        }

    }


    private fun hasAnnnotations(it: ClassConstructorDescriptor, annotation: String): Boolean {
        /**I dont like this approach*/

        try {
            val test = it.annotations.hasAnnotation(FqName(annotation))
            return test
        } catch (any: Exception) {
            return false
        }
    }

    fun checkTypeAlias(it: PackageFragmentDescriptor, annotation: String): Boolean {
        /**I dont like this approach*/

        try {
            val test = it.getMemberScope().getDescriptorsFiltered(DescriptorKindFilter.TYPE_ALIASES).isNotEmpty()
            return test
        } catch (any: Exception) {
            return false
        }
    }


}