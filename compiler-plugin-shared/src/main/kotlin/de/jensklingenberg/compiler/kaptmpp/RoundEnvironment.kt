package de.jensklingenberg.compiler.kaptmpp

import org.jetbrains.kotlin.descriptors.ModuleDescriptor

class RoundEnvironment(val platform: Platform = Platform.ALL) {

    var elements: MutableList<Element> = mutableListOf()

    var module: ModuleDescriptor? = null

    fun getElementsAnnotatedWith(annotationName: String): List<Element> {
        return elements.filter { it.annotation?.fqName?.asString() == annotationName }

    }


}

