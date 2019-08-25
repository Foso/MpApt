package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.AbstractProcessor
import de.jensklingenberg.mpapt.model.Platform
import de.jensklingenberg.mpapt.RoundEnvironment
import de.jensklingenberg.mpapt.common.ClassParser
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.js.translate.context.TranslationContext
import org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.psi.KtPureClassOrObject

class JsSyntheticTranslateExtensionExt(val abstractProcessor: AbstractProcessor) : JsSyntheticTranslateExtension {


    override fun generateClassSyntheticParts(
            declaration: KtPureClassOrObject,
            descriptor: ClassDescriptor,
            translator: DeclarationBodyVisitor,
            context: TranslationContext
    ) {



    }


}
