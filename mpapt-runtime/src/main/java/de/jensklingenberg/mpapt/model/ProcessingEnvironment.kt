package de.jensklingenberg.mpapt.model

import de.jensklingenberg.mpapt.utils.ElementUtils
import org.jetbrains.kotlin.cli.common.messages.MessageCollector

data class ProcessingEnvironment(
        open val messager: MessageCollector,
        val elementUtils: ElementUtils = ElementUtils()

) {
    fun elementUtils(): ElementUtils {
        return ElementUtils()
    }
}

