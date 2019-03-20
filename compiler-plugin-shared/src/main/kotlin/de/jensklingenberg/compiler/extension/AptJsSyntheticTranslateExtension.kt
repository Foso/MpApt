package de.jensklingenberg.compiler.extension

import de.jensklingenberg.compiler.common.ClassParser
import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import de.jensklingenberg.compiler.kaptmpp.Platform
import de.jensklingenberg.compiler.kaptmpp.RoundEnvironment
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.js.translate.context.TranslationContext
import org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.psi.KtPureClassOrObject

class Synth(val abstractProcessor: AbstractProcessor) : JsSyntheticTranslateExtension {

    val TAG = "Synth"

    val platform = Platform.JS

    override fun generateClassSyntheticParts(
            declaration: KtPureClassOrObject,
            descriptor: ClassDescriptor,
            translator: DeclarationBodyVisitor,
            context: TranslationContext
    ) {

        if (abstractProcessor.getSupportedPlatform().contains(platform) ||
                abstractProcessor.getSupportedPlatform().contains(Platform.ALL)) {
            val roundEnvironment = RoundEnvironment(platform)

            val targetClass = descriptor
            ClassParser.parse(targetClass, abstractProcessor, roundEnvironment)
        }


    }


}
