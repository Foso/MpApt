package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.descriptors.annotations.Annotated
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.descriptors.annotations.Annotations
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtAnnotatedExpression
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.BindingTraceContext
import org.jetbrains.kotlin.resolve.constants.ConstantValue
import org.jetbrains.kotlin.resolve.constants.KClassValue

fun AnnotationDescriptor.readArgument(key: String): ArrayList<KClassValue> {
    val keyvalue: ConstantValue<*> = this.allValueArguments[Name.identifier(key)]
            ?: throw Exception("The key $key does not exist")
    return keyvalue.value as? ArrayList<KClassValue> ?: arrayListOf()
}

fun AnnotationDescriptor?.simpleName(): String = this?.fqName?.shortName()?.asString() ?: "No Name"
fun Annotations.hasAnnotation(fqName: String): Boolean = this.hasAnnotation(FqName(fqName))
fun Annotations.findAnnotation(fqName: String): AnnotationDescriptor? = this.findAnnotation(FqName(fqName))


fun KtAnnotatedExpression.findAnnotation(bindingTraceContext: BindingTraceContext, annotationName: String): AnnotationDescriptor? {
    return this.annotationEntries.mapNotNull { bindingTraceContext.get(BindingContext.ANNOTATION, it) }.firstOrNull {
        it.fqName?.toString().equals(annotationName)
    }

}

fun KtAnnotationEntry.toAnnotationDescriptor(bindingTraceContext: BindingTraceContext): AnnotationDescriptor? {
    return bindingTraceContext.get(BindingContext.ANNOTATION, this)
}


fun Annotated.hasAnnotation(name: String): Boolean = this.annotations.hasAnnotation(FqName(name))
fun Annotated.findAnnotation(name: String): AnnotationDescriptor? = this.annotations.findAnnotation(FqName(name))
