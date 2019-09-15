package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.Modality
import org.jetbrains.kotlin.extensions.AnnotationBasedExtension
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtModifierListOwner
import org.jetbrains.kotlin.resolve.BindingContext


/**
 * Looks like this class is called on JS/JVM, copied this from AllOpenPlugin
 */
class MyDeclarationAttributeAltererExtension(generator: AbstractProcessor) : DeclarationAttributeAltererExtension,AnnotationBasedExtension {
    override fun getAnnotationFqNames(modifierListOwner: KtModifierListOwner?): List<String> {
        return listOf("de.jensklingenberg.testAnnotations.TestFunction")
    }

    override fun refineDeclarationModality(modifierListOwner: KtModifierListOwner, declaration: DeclarationDescriptor?, containingDeclaration: DeclarationDescriptor?, currentModality: Modality, bindingContext: BindingContext, isImplicitModality: Boolean): Modality? {
        if (currentModality != Modality.FINAL) {
            return null
        }

        val descriptor = declaration as? ClassDescriptor ?: containingDeclaration ?: return null
        if (descriptor.hasSpecialAnnotation(modifierListOwner)) {
            return if (!isImplicitModality && modifierListOwner.hasModifier(KtTokens.FINAL_KEYWORD))
                Modality.FINAL // Explicit final
            else
                Modality.OPEN
        }

        return null
    }


}

