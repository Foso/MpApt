package de.jensklingenberg.mpapt.extension.js

import de.jensklingenberg.mpapt.model.Processor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.js.translate.context.TranslationContext
import org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.psi.KtPureClassOrObject

/**
 * This class is used to detect that the [DeclarationCheckerImpl] is finished with processing on KotlinJS
 */
internal class JsSyntheticTranslateExtensionExt(private val processor: Processor) : JsSyntheticTranslateExtension {

    override fun generateClassSyntheticParts(
            declaration: KtPureClassOrObject,
            descriptor: ClassDescriptor,
            translator: DeclarationBodyVisitor,
            context: TranslationContext
    ) {
        if (processor.isTargetPlatformSupported()) {
            processor.onProcessingOver()
        }
    }
}


