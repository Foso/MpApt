package de.jensklingenberg.mpapt.extension


import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.Annotated
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.descriptors.annotations.KotlinTarget
import org.jetbrains.kotlin.descriptors.impl.AnonymousFunctionDescriptor
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.diagnostics.Errors
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.load.java.descriptors.JavaMethodDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.resolve.AdditionalAnnotationChecker
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.calls.checkers.AdditionalTypeChecker
import org.jetbrains.kotlin.resolve.calls.context.ResolutionContext
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCall
import org.jetbrains.kotlin.resolve.calls.model.VariableAsFunctionResolvedCall
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.checkers.DeclarationCheckerContext
import org.jetbrains.kotlin.resolve.inline.InlineUtil.isInlinedArgument
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.TypeUtils
import org.jetbrains.kotlin.types.lowerIfFlexible
import org.jetbrains.kotlin.types.typeUtil.builtIns
import org.jetbrains.kotlin.types.upperIfFlexible
import org.jetbrains.kotlin.util.OperatorNameConventions


val AnnotationDescriptor.isComposableAnnotation: Boolean get() = fqName == ComposeFqNames.Composable

fun Annotated.hasComposableAnnotation(): Boolean =
        annotations.findAnnotation(ComposeFqNames.Composable) != null

open class ComposableAnnotationChecker : AdditionalAnnotationChecker,AdditionalTypeChecker {
    companion object {

    }
    enum class Composability { NOT_COMPOSABLE, INFERRED, MARKED }


    private fun analyzeFunctionContents(
            trace: BindingTrace,
            element: KtElement,
            signatureComposability: Composability
    ): Composability {
        var composability = signatureComposability
        var localFcs = false
        var isInlineLambda = false
        element.accept(object : KtTreeVisitorVoid() {
            override fun visitNamedFunction(function: KtNamedFunction) {
                if (function == element) {
                    super.visitNamedFunction(function)
                }
            }
            override fun visitPropertyAccessor(accessor: KtPropertyAccessor) {
                // this is basically a function, so unless it is the function we are analyzing, we
                // stop here
                if (accessor == element) {
                    super.visitPropertyAccessor(accessor)
                }
            }
            override fun visitClass(klass: KtClass) {
                // never traverse a class
            }
            override fun visitLambdaExpression(lambdaExpression: KtLambdaExpression) {
                val isInlineable = isInlinedArgument(
                        lambdaExpression.functionLiteral,
                        trace.bindingContext,
                        true
                )
                if (isInlineable && lambdaExpression == element) isInlineLambda = true
                if (isInlineable || lambdaExpression == element)
                    super.visitLambdaExpression(lambdaExpression)
            }
            override fun visitSimpleNameExpression(expression: KtSimpleNameExpression) {
                val resolvedCall = expression.getResolvedCall(trace.bindingContext)
                if (resolvedCall?.candidateDescriptor is PropertyDescriptor) {


                }
                super.visitSimpleNameExpression(expression)
            }
            override fun visitCallExpression(expression: KtCallExpression) {
                val resolvedCall = expression.getResolvedCall(trace.bindingContext)


                super.visitCallExpression(expression)
            }
            private fun checkResolvedCall(
                    resolvedCall: ResolvedCall<*>?,
                    isCallComposable: Boolean?,
                    reportElement: KtExpression
            ) {
                when (resolvedCall?.candidateDescriptor) {


                }
                // Can be null in cases where the call isn't resolvable (eg. due to a bug/typo in the user's code)
                if (isCallComposable == true) {
                    localFcs = true
                    if (!isInlineLambda && composability != Composability.MARKED) {
                        // Report error on composable element to make it obvious which invocation is offensive


                    }
                }
            }
        }, null)
        if (
                localFcs &&
                !isInlineLambda && composability != Composability.MARKED
        ) {
            val reportElement = when (element) {
                is KtNamedFunction -> element.nameIdentifier ?: element
                else -> element
            }
            if (localFcs) {

            }
        }
        if (localFcs && composability == Composability.NOT_COMPOSABLE)
            composability =
                    Composability.INFERRED
        return composability
    }





    override fun checkEntries(
            entries: List<KtAnnotationEntry>,
            actualTargets: List<KotlinTarget>,
            trace: BindingTrace
    ) {
        val entry = entries.map {
            trace.bindingContext.get(BindingContext.ANNOTATION, it)
        }
        val test = entry.firstOrNull()?.fqName
       // entries.first().parent
    }
    operator fun Composability.plus(rhs: Composability): Composability =
            if (this > rhs) this else rhs

    override fun checkType(expression: KtExpression, expressionType: KotlinType, expressionTypeWithSmartCast: KotlinType, c: ResolutionContext<*>) {

        val e = expression

        if(e is KtNamedFunction){
            val i = 1
        }
    }
}



object ComposeFqNames {
    val Composable = FqName("de.jensklingenberg.testAnnotations.TestExpression")

}