package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.common.ClassParser
import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Platform
import de.jensklingenberg.mpapt.model.RoundEnvironment
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.lazy.LazyClassContext
import org.jetbrains.kotlin.resolve.lazy.declarations.PackageMemberDeclarationProvider
import org.jetbrains.kotlin.resolve.source.KotlinSourceElement
import java.util.*

internal class SyntheticResolveExtensionImpl(val abstractProcessor: AbstractProcessor) : SyntheticResolveExtension {

    override fun generateSyntheticClasses(thisDescriptor: PackageFragmentDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: PackageMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
        ClassParser.parsePackage(thisDescriptor, abstractProcessor, RoundEnvironment())

        val roundEnvironment = RoundEnvironment()
        if (
                abstractProcessor.supportedTargetPlatform().contains(Platform.ALL)
        ) {

            result.forEach {
                if (!it.isCompanionObject && name.identifier != "Companion") {
                    ClassParser.parse(it, abstractProcessor, roundEnvironment)
                }
                //checkiflast(it)
            }
        }
    }

    private fun checkiflast(thisDescriptor: ClassDescriptor, state: String): Boolean {
        ((thisDescriptor.source as KotlinSourceElement).psi as KtClass).getProperties()
        return false
    }


    override fun generateSyntheticMethods(
            thisDescriptor: ClassDescriptor,
            name: Name,
            bindingContext: BindingContext,
            fromSupertypes: List<SimpleFunctionDescriptor>,
            result: MutableCollection<SimpleFunctionDescriptor>
    ) {
        result.forEach { function ->
            ClassParser.parseMethod(thisDescriptor, function, abstractProcessor, RoundEnvironment())
        }
    }

    override fun generateSyntheticProperties(thisDescriptor: ClassDescriptor, name: Name, bindingContext: BindingContext, fromSupertypes: ArrayList<PropertyDescriptor>, result: MutableSet<PropertyDescriptor>) {

        result.forEach {
            ClassParser.parseProperty(it, abstractProcessor, RoundEnvironment())
        }

    }


}
