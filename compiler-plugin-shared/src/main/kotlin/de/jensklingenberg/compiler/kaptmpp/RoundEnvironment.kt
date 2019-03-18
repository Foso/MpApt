package de.jensklingenberg.compiler.kaptmpp

class RoundEnvironment(val platform: Platform = Platform.ALL) {

    var elements: MutableList<Element> = mutableListOf()


    fun getElementsAnnotatedWith(annotationName: String): List<Element> {
        return elements.filter { it.annotation == annotationName }

    }


}

