package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.common.AnnotationDetector
import de.jensklingenberg.mpapt.model.Processor
import de.jensklingenberg.mpapt.model.RoundEnvironment
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.lazy.LazyClassContext
import org.jetbrains.kotlin.resolve.lazy.declarations.PackageMemberDeclarationProvider
import java.util.*

internal class SyntheticResolveExtensionImpl(val processor: Processor, private val annotationDetector: AnnotationDetector) : SyntheticResolveExtension {

    init {

    }

    override fun generateSyntheticClasses(thisDescriptor: PackageFragmentDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: PackageMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }

        val roundEnvironment = RoundEnvironment()
        result.forEach {
            if (!it.isCompanionObject && name.identifier != "Companion") {
                //  annotationDetector.parseClass(it, roundEnvironment)
            }
        }

    }

    override fun generateSyntheticMethods(
            thisDescriptor: ClassDescriptor,
            name: Name,
            bindingContext: BindingContext,
            fromSupertypes: List<SimpleFunctionDescriptor>,
            result: MutableCollection<SimpleFunctionDescriptor>
    ) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }
        result.forEach { function ->
            //  annotationDetector.parseMethod(thisDescriptor, function, RoundEnvironment())
        }
    }

    override fun generateSyntheticProperties(thisDescriptor: ClassDescriptor, name: Name, bindingContext: BindingContext, fromSupertypes: ArrayList<PropertyDescriptor>, result: MutableSet<PropertyDescriptor>) {
        if (!processor.isTargetPlatformSupported()) {
            return
        }
        result.forEach {
            // annotationDetector.parseProperty(it, RoundEnvironment())
        }

    }


}
