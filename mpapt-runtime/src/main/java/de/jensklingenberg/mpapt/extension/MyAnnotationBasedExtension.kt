package de.jensklingenberg.mpapt.extension

import org.jetbrains.kotlin.extensions.AnnotationBasedExtension
import org.jetbrains.kotlin.psi.KtModifierListOwner

class MyAnnotationBasedExtension: AnnotationBasedExtension {
    override fun getAnnotationFqNames(modifierListOwner: KtModifierListOwner?): List<String> {
        return listOf()

    }

}