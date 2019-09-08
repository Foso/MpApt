package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.resolve.calls.checkers.CallChecker
import org.jetbrains.kotlin.resolve.calls.checkers.CallCheckerContext
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall

class JVMCallChecker(val processor: AbstractProcessor) :CallChecker{
    override fun check(resolvedCall: ResolvedCall<*>, reportOn: PsiElement, context: CallCheckerContext) {

        val constructorDescriptor = resolvedCall.resultingDescriptor as? ClassConstructorDescriptor ?: return
        val annotationClass = constructorDescriptor.constructedClass.takeIf { it.kind == ClassKind.ANNOTATION_CLASS } ?: return

    }

}