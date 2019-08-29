package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.RoundEnvironment
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.Platform
import org.jetbrains.kotlin.backend.common.descriptors.WrappedSimpleFunctionDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.annotations.Annotations
import org.jetbrains.kotlin.js.translate.context.TranslationContext
import org.jetbrains.kotlin.js.translate.declaration.DeclarationBodyVisitor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPureClassOrObject
import org.jetbrains.kotlin.resolve.source.toSourceElement

class JsSyntheticTranslateExtensionExt(val abstractProcessor: AbstractProcessor) : JsSyntheticTranslateExtension {


    override fun generateClassSyntheticParts(
            declaration: KtPureClassOrObject,
            descriptor: ClassDescriptor,
            translator: DeclarationBodyVisitor,
            context: TranslationContext
    ) {

        //declaration.body.functions.get(1).bodyBlockExpression.statements.filterIsInstance<KtProperty>().get(0).annotationEntries.map { it.shortName }
        checkLocalVariable(declaration)


        //abstractProcessor.log("JsSyntheticTranslateExtensionExt"+descriptor.name)

    }

    private fun checkLocalVariable(declaration: KtPureClassOrObject) {
        abstractProcessor.getSupportedAnnotationTypes().forEach { annoation ->
            val annotationWithoutPackage = annoation.substringAfterLast(".")
            declaration.body?.functions?.forEach { ktfunction ->


                val findanno: KtProperty? = ktfunction.bodyBlockExpression?.statements?.filterIsInstance<KtProperty>()?.firstOrNull { property ->
                    val che = property.annotationEntries.any() { it.shortName?.identifier.equals(annotationWithoutPackage) ?: false }


                    che
                }

               // val getAnno= findanno?.type

             if(findanno!=null){
                val roundEnvironment= RoundEnvironment(Platform.JS)


                 roundEnvironment.apply {
                     elements.add(
                             Element.LocalVariableElement(
                                    classConstructorDescriptor = findanno,
                                     func = WrappedSimpleFunctionDescriptor(Annotations.EMPTY,ktfunction.toSourceElement())
                                    // annotation =AnnotationDescriptor

                             )
                     )
                 }



                 abstractProcessor.process(roundEnvironment)

                 abstractProcessor.log("I FOUND A LOCAL "+findanno?.name)
             }

            }


        }

    }


}

fun KtAnnotationEntry.toAnnotationDescriptor(){
    val entry = this




}

