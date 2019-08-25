package de.jensklingenberg.mpapt

import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.Platform
import org.jetbrains.kotlin.descriptors.ModuleDescriptor

class RoundEnvironment(val platform: Platform = Platform.ALL) {

    var elements: MutableList<Element> = mutableListOf()

    var module: ModuleDescriptor? = null

    fun getElementsAnnotatedWith(annotationName: String): List<Element> =
            elements.filter { it.annotation?.fqName?.asString() == annotationName }

    fun getElementsAnnotatedWith(annotationName: List<String>): List<Element> =
            elements.filter { annotationName.contains(it.annotation?.fqName?.asString()) }

}

