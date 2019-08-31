package de.jensklingenberg.mpapt.model

import org.jetbrains.kotlin.descriptors.ModuleDescriptor

class RoundEnvironment() {

    var elements: MutableList<Element> = mutableListOf()

    var module: ModuleDescriptor? = null

    fun getElementsAnnotatedWith(annotationName: String): List<Element> =
            elements.filter { it.annotation?.fqName?.asString() == annotationName }

    fun getElementsAnnotatedWith(annotationName: List<String>): List<Element> =
            elements.filter { annotationName.contains(it.annotation?.fqName?.asString()) }

}

