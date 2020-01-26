package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.common.AnnotationDetector
import de.jensklingenberg.mpapt.common.findAnnotation
import de.jensklingenberg.mpapt.model.Processor
import de.jensklingenberg.mpapt.model.RoundEnvironment
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.Annotations
import org.jetbrains.kotlin.descriptors.impl.SimpleFunctionDescriptorImpl
import org.jetbrains.kotlin.descriptors.impl.TypeParameterDescriptorImpl
import org.jetbrains.kotlin.descriptors.impl.ValueParameterDescriptorImpl
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.descriptorUtil.builtIns
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.lazy.LazyClassContext
import org.jetbrains.kotlin.resolve.lazy.declarations.PackageMemberDeclarationProvider
import org.jetbrains.kotlin.resolve.source.PsiSourceElement
import org.jetbrains.kotlin.types.KotlinType
import org.jetbrains.kotlin.types.KotlinTypeFactory
import org.jetbrains.kotlin.types.TypeProjectionImpl
import org.jetbrains.kotlin.types.Variance
import java.util.*

internal class SyntheticResolveExtensionImpl(val processor: Processor, private val annotationDetector: AnnotationDetector) : SyntheticResolveExtension {

    init {
  val i =1
    }

    override fun generateSyntheticClasses(thisDescriptor: PackageFragmentDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: PackageMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }

        val roundEnvironment = RoundEnvironment()
        result.forEach {
            if (!it.isCompanionObject && name.identifier != "Companion") {
                annotationDetector.parseClass(it, roundEnvironment)
            }
        }

    }
    private fun FunctionDescriptor.makeValueParameter(name: String, type: KotlinType, index: Int): ValueParameterDescriptor {
        return ValueParameterDescriptorImpl(
                this, null, index, Annotations.EMPTY, Name.identifier(name), type, false, false, false, null, this.source)
    }

    override fun generateSyntheticMethods(
            thisDescriptor: ClassDescriptor,
            name: Name,
            bindingContext: BindingContext,
            fromSupertypes: List<SimpleFunctionDescriptor>,
            result: MutableCollection<SimpleFunctionDescriptor>
    ) {
        val sourceElement = (thisDescriptor.source as? PsiSourceElement)?.psi as? KtElement


        result.forEachIndexed { index, func ->
            func.annotations.findAnnotation("de.jensklingenberg.testAnnotations.TestFunction")?.let { annotation ->

                if(func.modality==Modality.FINAL){
                    //result.remove(func)
                    val tt =  func.copy(func,Modality.OPEN,func.visibility,func.kind,true)
                   // result.add(tt)
                }

            }
        }


        if (!processor.isTargetPlatformSupported()) {
            return
        }
        result.forEach { function ->
            annotationDetector.parseMethod(thisDescriptor, function, RoundEnvironment())
        }
    }

    override fun generateSyntheticProperties(thisDescriptor: ClassDescriptor, name: Name, bindingContext: BindingContext, fromSupertypes: ArrayList<PropertyDescriptor>, result: MutableSet<PropertyDescriptor>) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }
        result.forEach {
            annotationDetector.parseProperty(it, RoundEnvironment())
        }

    }





}
