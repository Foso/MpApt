package de.jensklingenberg.compiler.common

import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.constants.ConstantValue


fun ClassDescriptor.hasAnnotation(name: String): Boolean {
    return this.annotations.hasAnnotation(FqName(name))

}


fun PropertyDescriptor.hasAnnotation(name: String): Boolean {
    return this.annotations.hasAnnotation(FqName(name))
}

fun ClassDescriptor.findAnnotation(name: String): AnnotationDescriptor? {
    return this.annotations.findAnnotation(FqName(name))
}

fun AnnotationDescriptor.readArgument(key: String): ConstantValue<*>? {
    return this.allValueArguments.get(Name.identifier(key))
}