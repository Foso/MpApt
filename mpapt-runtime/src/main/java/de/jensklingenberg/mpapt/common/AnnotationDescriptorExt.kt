package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.descriptors.annotations.Annotations
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.constants.ConstantValue
import org.jetbrains.kotlin.resolve.constants.KClassValue
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

fun AnnotationDescriptor.readArgument(key: String): ArrayList<KClassValue> {
    val keyvalue: ConstantValue<*> = this.allValueArguments[Name.identifier(key)]
            ?: throw Exception("The key $key does not exist")
    return keyvalue.value as? ArrayList<KClassValue> ?: arrayListOf()
}

fun AnnotationDescriptor?.simpleName(): String = this?.fqName?.shortName()?.asString() ?: "No Name"
fun Annotations.hasAnnotation(fqName: String): Boolean = this.hasAnnotation(FqName(fqName))
fun Annotations.findAnnotation(fqName: String): AnnotationDescriptor? = this.findAnnotation(FqName(fqName))

fun KClass<*>.propertyNames(): List<String> = this.members.filterIsInstance<KProperty<*>>().map { it.name }