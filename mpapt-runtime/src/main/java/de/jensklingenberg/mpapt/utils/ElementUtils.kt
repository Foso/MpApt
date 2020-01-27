package de.jensklingenberg.mpapt.utils

import de.jensklingenberg.mpapt.model.Element
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe

class ElementUtils {
    fun getPackageOf(sourceClassElement: Element): String {
        when (sourceClassElement) {
            is Element.ClassElement -> {
                return sourceClassElement.classDescriptor.original.containingDeclaration.fqNameSafe.asString()
            }
        }
        return ""

    }

}