package de.jensklingenberg.compiler.kaptmpp

import org.jetbrains.kotlin.descriptors.ClassDescriptor

sealed class Element  constructor(
        open val simpleName: String = "",
        open val path: String = "",
        open val elementKind: ElementKind = ElementKind.OTHER,
        open val annotation:String="",
        open val pack : String = ""
) {

    class ClassElement(
            override val simpleName: String = "",
            override val path: String = "",
            override val elementKind: ElementKind = ElementKind.CLASS,
            override val annotation: String = "",
            override val pack: String = "",
            val descriptor: ClassDescriptor
    ) : Element()

    class FunctionElement(override val simpleName: String,override val annotation: String = ""): Element()
}




enum class ElementKind{
    OTHER,CLASS
}