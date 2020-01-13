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

open class ComposableAnnotationChecker :
        AdditionalTypeChecker, AdditionalAnnotationChecker {
    companion object {

    }
    enum class Composability { NOT_COMPOSABLE, INFERRED, MARKED }


    fun analyze(trace: BindingTrace, descriptor: FunctionDescriptor): Composability {
        val unwrappedDescriptor = when (descriptor) {
          //  is ComposableFunctionDescriptor -> descriptor.underlyingDescriptor
            else -> descriptor
        }
       // val psi = unwrappedDescriptor.findPsi() as? KtElement
      //  psi?.let { trace.bindingContext.get(COMPOSABLE_ANALYSIS, it)?.let { return it } }
       /* if (unwrappedDescriptor.name == Name.identifier("compose") &&
                unwrappedDescriptor.containingDeclaration is ClassDescriptor &&
                ComposeUtils.isComposeComponent(unwrappedDescriptor.containingDeclaration)
        ) return Composability.MARKED

               */

                var composability = Composability.NOT_COMPOSABLE

        if (false) {
            composability = Composability.MARKED
        } else {
            when (unwrappedDescriptor) {
                is VariableDescriptor ->
                    if (unwrappedDescriptor.hasComposableAnnotation() ||
                            unwrappedDescriptor.type.hasComposableAnnotation()
                    )
                        composability =
                                Composability.MARKED
                is ConstructorDescriptor ->
                    if (unwrappedDescriptor.hasComposableAnnotation()) composability =
                            Composability.MARKED
                is JavaMethodDescriptor ->
                    if (unwrappedDescriptor.hasComposableAnnotation()) composability =
                            Composability.MARKED
                is AnonymousFunctionDescriptor -> {
                    if (unwrappedDescriptor.hasComposableAnnotation()) composability =
                            Composability.MARKED


                }
                is PropertyGetterDescriptor ->
                    if (unwrappedDescriptor.correspondingProperty.hasComposableAnnotation())
                        composability = Composability.MARKED
                else -> if (unwrappedDescriptor.hasComposableAnnotation()) composability =
                        Composability.MARKED
            }
        }


       // psi?.let { trace.record(COMPOSABLE_ANALYSIS, it, composability) }
        return composability
    }
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
    /**
     * Analyze a KtElement
     *  - Determine if it is @Composable (eg. the element or inferred type has an @Composable annotation)
     *  - Update the binding context to cache analysis results
     *  - Report errors (eg. invocations of an @Composable, etc)
     *  - Return true if element is @Composable, else false
     */
    fun analyze(trace: BindingTrace, element: KtElement, type: KotlinType?): Composability {
       // trace.bindingContext.get(BasicWritableSlice(RewritePolicy.DO_NOTHING), element)?.let { return it }
        var composability =
                Composability.NOT_COMPOSABLE
        if (element is KtClass) {
            val descriptor = trace.bindingContext.get(BindingContext.CLASS, element)
                    ?: error("Element class context not found")
            val annotationEntry = element.annotationEntries.singleOrNull {
                trace.bindingContext.get(BindingContext.ANNOTATION, it)?.isComposableAnnotation
                        ?: false
            }
            if (annotationEntry != null) {
                trace.report(
                        Errors.WRONG_ANNOTATION_TARGET.on(
                                annotationEntry,
                                "class which does not extend androidx.compose.Component"
                        )
                )
            }


        }
        if (element is KtParameter) {
            val composableAnnotation = element
                    .typeReference
                    ?.annotationEntries
                    ?.mapNotNull { trace.bindingContext.get(BindingContext.ANNOTATION, it) }
                    ?.singleOrNull { it.isComposableAnnotation }
            if (composableAnnotation != null) {
                composability += Composability.MARKED
            }
        }
        if (element is KtParameter) {
            val composableAnnotation = element
                    .typeReference
                    ?.annotationEntries
                    ?.mapNotNull { trace.bindingContext.get(BindingContext.ANNOTATION, it) }
                    ?.singleOrNull { it.isComposableAnnotation }
            if (composableAnnotation != null) {
                composability += Composability.MARKED
            }
        }
        // if (candidateDescriptor.type.arguments.size != 1 || !candidateDescriptor.type.arguments[0].type.isUnit()) return false
        if (
                type != null &&
                type !== TypeUtils.NO_EXPECTED_TYPE &&
                type.hasComposableAnnotation()
        ) {
            composability += Composability.MARKED
        }
        val parent = element.parent
        val annotations = when {
            element is KtNamedFunction -> element.annotationEntries
            parent is KtAnnotatedExpression -> parent.annotationEntries
            element is KtProperty -> element.annotationEntries
            element is KtParameter -> element.typeReference?.annotationEntries ?: emptyList()
            else -> emptyList()
        }
        for (entry in annotations) {
            val descriptor = trace.bindingContext.get(BindingContext.ANNOTATION, entry) ?: continue
            if (descriptor.isComposableAnnotation) {
                composability += Composability.MARKED
            }
        }
        if (element is KtLambdaExpression || element is KtFunction) {


        }
        //trace.record(COMPOSABLE_ANALYSIS, element, composability)
        return composability
    }




    override fun checkType(
            expression: KtExpression,
            expressionType: KotlinType,
            expressionTypeWithSmartCast: KotlinType,
            c: ResolutionContext<*>
    ) {
        if (expression is KtLambdaExpression) {
            val expectedType = c.expectedType
            if (expectedType === TypeUtils.NO_EXPECTED_TYPE) return
            val expectedComposable = expectedType.hasComposableAnnotation()
            val composability = analyze(c.trace, expression, c.expectedType)

            return
        } else {
            val expectedType = c.expectedType
            if (expectedType === TypeUtils.NO_EXPECTED_TYPE) return
            if (expectedType === TypeUtils.UNIT_EXPECTED_TYPE) return
            val nullableAnyType = expectedType.builtIns.nullableAnyType
            val anyType = expectedType.builtIns.anyType
            if (anyType == expectedType.lowerIfFlexible() &&
                    nullableAnyType == expectedType.upperIfFlexible()) return
            val nullableNothingType = expectedType.builtIns.nullableNothingType
            // Handle assigning null to a nullable composable type
            if (expectedType.isMarkedNullable &&
                    expressionTypeWithSmartCast == nullableNothingType) return
            val expectedComposable = expectedType.hasComposableAnnotation()
            val isComposable = expressionType.hasComposableAnnotation()
            if (expectedComposable != isComposable) {
                val reportOn =
                        if (expression.parent is KtAnnotatedExpression)
                            expression.parent as KtExpression
                        else expression
                c.trace.report(
                        Errors.TYPE_MISMATCH.on(
                                reportOn,
                                expectedType,
                                expressionTypeWithSmartCast
                        )
                )
            }
            return
        }
    }
    override fun checkEntries(
            entries: List<KtAnnotationEntry>,
            actualTargets: List<KotlinTarget>,
            trace: BindingTrace
    ) {
        val entry = entries.map {
            trace.bindingContext.get(BindingContext.ANNOTATION, it)
        }
        entries.first().parent
    }
    operator fun Composability.plus(rhs: Composability): Composability =
            if (this > rhs) this else rhs
}



object ComposeFqNames {
    val Composable = FqName("de.jensklingenberg.testAnnotations.TestExpression")

}