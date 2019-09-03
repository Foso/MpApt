package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.common.ClassParser
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

internal class SyntheticResolveExtensionImpl(val abstractProcessor: Processor) : SyntheticResolveExtension {

    override fun generateSyntheticClasses(thisDescriptor: PackageFragmentDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: PackageMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
        if (!abstractProcessor.isTargetPlatformSupported()) {
            return
        }

        val roundEnvironment = RoundEnvironment()
        result.forEach {
            if (!it.isCompanionObject && name.identifier != "Companion") {
                ClassParser.parse(it, abstractProcessor, roundEnvironment)
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
        if (!abstractProcessor.isTargetPlatformSupported()) {
            return
        }
        result.forEach { function ->
            ClassParser.parseMethod(thisDescriptor, function, abstractProcessor, RoundEnvironment())
        }
    }

    override fun generateSyntheticProperties(thisDescriptor: ClassDescriptor, name: Name, bindingContext: BindingContext, fromSupertypes: ArrayList<PropertyDescriptor>, result: MutableSet<PropertyDescriptor>) {
        if (!abstractProcessor.isTargetPlatformSupported()) {
            return
        }
        result.forEach {
            ClassParser.parseProperty(it, abstractProcessor, RoundEnvironment())
        }

    }


}
