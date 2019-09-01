package de.jensklingenberg.mpapt.extension.js

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.js.translate.context.TranslationContext
import org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.psi.KtPureClassOrObject

/**
 * This class is executed after the [SyntheticResolveExtensionImpl]
 */
internal class JsSyntheticTranslateExtensionExt(val abstractProcessor: AbstractProcessor) : JsSyntheticTranslateExtension {

    override fun generateClassSyntheticParts(
            declaration: KtPureClassOrObject,
            descriptor: ClassDescriptor,
            translator: DeclarationBodyVisitor,
            context: TranslationContext
    ) {
        abstractProcessor.processingOver()
    }
}


