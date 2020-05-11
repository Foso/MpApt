package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.RoundEnvironment
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.js.translate.utils.AnnotationsUtils
import org.jetbrains.kotlin.psi.KtAnnotatedExpression
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.blockExpressionsOrSingle
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.BindingTraceContext
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.checkers.DeclarationCheckerContext
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor

/**
 * This class is used to detect the annotations
 */
class DeclarationCheckerImpl(private val processor: AbstractProcessor) : DeclarationChecker {
    private val filesProcessed = mutableSetOf<String>()

    override fun check(declaration: KtDeclaration, descriptor: DeclarationDescriptor, context: DeclarationCheckerContext) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }

        val roundEnvironment = RoundEnvironment()
        roundEnvironment.module = descriptor.module

        val supportedAnnotations = processor.getSupportedAnnotationTypes()

        if(!filesProcessed.contains(declaration.containingKtFile.virtualFilePath)) {
            AnnotationsUtils.getContainingFileAnnotations(context.trace.bindingContext, descriptor)
                .forEach {
                    if (it.fqName?.asString() in supportedAnnotations) {
                        roundEnvironment.elements.add(Element.FileElement(annotation = it))
                    }
                }
            filesProcessed.add(declaration.containingKtFile.virtualFilePath)
        }

        descriptor.annotations
            .filter { it.fqName.toString() in supportedAnnotations }
            .mapNotNull { baseElementsProducer(descriptor, it) }
            .forEach { roundEnvironment.elements.add(it) }

        when (descriptor) {
            is PropertyDescriptor       -> (descriptor.backingField?.annotations?.toList() ?: listOf())
                .filter { it.fqName.toString() in supportedAnnotations }
                .map { Element.FieldElement(descriptor.backingField!!, it) }
                .forEach { roundEnvironment.elements.add(it) }
            is SimpleFunctionDescriptor -> {
                descriptor.typeParameters.forEach { parameterDescriptor ->
                    parameterDescriptor.annotations
                        .filter { it.fqName.toString() in supportedAnnotations }
                        .map { Element.TypeParameterElement(parameterDescriptor, it) }
                        .forEach { roundEnvironment.elements.add(it) }
                }
                descriptor.valueParameters.forEach { valueDescription ->
                    valueDescription.annotations
                        .filter { it.fqName.toString() in supportedAnnotations }
                        .map { Element.ValueParameterElement(valueDescription, it) }
                        .forEach { roundEnvironment.elements.add(it) }
                }
                getAnnotatedExpressions(declaration).forEach { annotatedExpression ->
                    annotatedExpression.annotationEntries
                        .mapNotNull { (context.trace as BindingTraceContext).get(BindingContext.ANNOTATION, it) }
                        .filter { it.fqName.toString() in supportedAnnotations }
                        .map { Element.ExpressionElement(annotatedExpression, it, descriptor) }
                        .forEach { roundEnvironment.elements.add(it) }
                }
            }
        }
        if(roundEnvironment.elements.isNotEmpty()) {
            processor.process(roundEnvironment)
        }
    }

    private fun getAnnotatedExpressions(declaration: KtDeclaration): List<KtAnnotatedExpression> {
        return (declaration as KtNamedFunction).bodyExpression
                   ?.blockExpressionsOrSingle()
                   ?.filterIsInstance<KtAnnotatedExpression>()
                   ?.toList() ?: listOf()
    }

    private fun baseElementsProducer(
        descriptor: DeclarationDescriptor,
        annotation: AnnotationDescriptor
    ): Element? = when (descriptor) {
        is TypeAliasDescriptor        -> Element.TypeAliasElement(descriptor, annotation)
        is SimpleFunctionDescriptor   -> Element.FunctionElement(
            simpleName = descriptor.name.asString(),
            annotation = annotation,
            descriptor = descriptor.containingDeclaration as ClassOrPackageFragmentDescriptor,
            func = descriptor
        )
        is ClassConstructorDescriptor -> Element.ClassConstructorElement(descriptor, annotation)
        is LazyClassDescriptor        -> makeFromLazyClassDescriptor(descriptor, annotation)
        is ClassDescriptor            -> Element.ClassElement(
            descriptor.name.asString(),
            annotation = annotation,
            classDescriptor = descriptor,
            pack = descriptor.original.containingDeclaration.fqNameSafe.asString()
        )
        is PropertyDescriptor         -> Element.PropertyElement(descriptor, annotation)
        is PropertyGetterDescriptor   -> Element.PropertyGetterElement(descriptor, annotation)
        is PropertySetterDescriptor   -> Element.PropertySetterElement(descriptor, annotation)
        is LocalVariableDescriptor    -> Element.LocalVariableElement(descriptor, annotation)
        else                          -> null
    }

    private fun makeFromLazyClassDescriptor(
        descriptor: LazyClassDescriptor,
        annotation: AnnotationDescriptor
    ): Element = when (descriptor.kind) {
        ClassKind.ANNOTATION_CLASS -> Element.AnnotationClassElement(
            descriptor.name.asString(),
            annotation = annotation,
            classDescriptor = descriptor,
            pack = descriptor.original.containingDeclaration.fqNameSafe.asString()
        )
        else                       -> Element.ClassElement(
            descriptor.name.asString(),
            annotation = annotation,
            classDescriptor = descriptor,
            pack = descriptor.original.containingDeclaration.fqNameSafe.asString()
        )
    }
}