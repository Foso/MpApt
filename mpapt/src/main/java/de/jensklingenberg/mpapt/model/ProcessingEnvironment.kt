package de.jensklingenberg.mpapt.model

import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe

data class ProcessingEnvironment(
        open val messager: MessageCollector,
        val elementUtils: ElementUtils = ElementUtils()

) {
    fun elementUtils(): ElementUtils {
        return ElementUtils()
    }
}

class ElementUtils() {
    fun getPackageOf(sourceClassElement: de.jensklingenberg.mpapt.model.Element): String {
        when (sourceClassElement) {
            is Element.ClassElement -> {
                return sourceClassElement.classDescriptor.original.containingDeclaration.fqNameSafe.asString()
            }
        }
        return ""

    }

}