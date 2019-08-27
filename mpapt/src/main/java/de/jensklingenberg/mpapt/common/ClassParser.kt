package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.AbstractProcessor
import de.jensklingenberg.mpapt.RoundEnvironment
import de.jensklingenberg.mpapt.model.Element
import org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.js.resolve.diagnostics.findPsi
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.module

class ClassParser() {


    companion object {

        fun parse(descriptor: ClassDescriptor, processor: AbstractProcessor, roundEnvironment: RoundEnvironment) {

            //  val buildFolder = descriptor.guessingBuildFolder()
            processor.processingEnv.projectFolder = "fffff"//descriptor.guessingProjectFolder()
            processor.processingEnv.buildFolder = "TODO"

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
                processor.messageCollector.warn(descriptor.name.identifier)


                descriptor.constructors.forEach {
                    if (checkit(it,annotation)) {
                        val annotatedConstructor = descriptor.constructors.first { it.hasAnnotation(annotation) }
                        val annotationDesc = annotatedConstructor.annotations.findAnnotation(annotation)
                        roundEnvironment.module = descriptor.module
                        roundEnvironment.elements.add(
                                Element.ClassConstrucorElement(
                                        classConstructorDescriptor = annotatedConstructor,
                                        annotation = annotationDesc

                                )
                        )
                        processor.process(roundEnvironment)
                    }
                }


            }

        }

        private fun checkit(it: ClassConstructorDescriptor, annotation: String): Boolean {
            /**I dont like this approach*/

            try {
               val test = it.annotations.hasAnnotation(FqName(annotation))?:true
                return test
            }catch (any:Exception){
              return  false
            }
            return false
        }



        fun parseMethod(
                descriptor: ClassDescriptor,
                function: FunctionDescriptor,
                processor: AbstractProcessor,
                roundEnvironment: RoundEnvironment
        ) {

            processor.getSupportedAnnotationTypes().forEach { annotationNames ->

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

        fun parseProperty(propertyDescriptor: PropertyDescriptor, processor: AbstractProcessor, roundEnvironment: RoundEnvironment) {

            processor.getSupportedAnnotationTypes().forEach { annotationNames ->

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

    }


}

private fun KtProperty.hasAnnotation(name: String): Boolean {
    return this.annotationEntries.any { name.contains(it.shortName?.identifier ?: "") }

}

private fun FunctionDescriptor.ktproperties(): List<KtProperty> {
    return this.findPsi()?.children?.filterIsInstance<KtBlockExpression>()?.flatMap { it.statements.filterIsInstance<KtProperty>() }
            ?: emptyList()
}
