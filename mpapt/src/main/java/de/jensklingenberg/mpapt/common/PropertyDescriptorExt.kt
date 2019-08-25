package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.name.FqName

fun PropertyDescriptor.hasAnnotation(name: String): Boolean = this.annotations.hasAnnotation(FqName(name))