package de.jensklingenberg.compiler.extension

import de.jensklingenberg.compiler.common.ClassParser
import de.jensklingenberg.compiler.common.hasAnnotation
import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import de.jensklingenberg.compiler.kaptmpp.Element
import de.jensklingenberg.compiler.kaptmpp.Platform
import de.jensklingenberg.compiler.kaptmpp.RoundEnvironment
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.js.backend.ast.JsExpression
import org.jetbrains.kotlin.js.translate.context.TranslationContext
import org.jetbrains.kotlin.js.translate.declaration.AbstractDeclarationVisitor
import org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtPureClassOrObject
import java.io.File

class Synth(val abstractProcessor: AbstractProcessor) : JsSyntheticTranslateExtension {

    val TAG = "Synth"

 val platform = Platform.JS

    override fun generateClassSyntheticParts(
        declaration: KtPureClassOrObject,
        descriptor: ClassDescriptor,
        translator: DeclarationBodyVisitor,
        context: TranslationContext
    ) {

        if(abstractProcessor.getSupportedPlatform().contains(platform) ||
                abstractProcessor.getSupportedPlatform().contains(Platform.ALL)){
            val roundEnvironment=RoundEnvironment(Platform.JS)

            val targetClass = descriptor
            ClassParser.parse(targetClass,abstractProcessor,roundEnvironment)
        }





    }
}
