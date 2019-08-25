package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.AbstractProcessor
import de.jensklingenberg.mpapt.RoundEnvironment
import de.jensklingenberg.mpapt.common.ClassParser
import de.jensklingenberg.mpapt.common.guessingPlatform
import de.jensklingenberg.mpapt.model.Platform
import org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.lazy.LazyClassContext
import org.jetbrains.kotlin.resolve.lazy.declarations.ClassMemberDeclarationProvider
import java.util.*

class SyntheticResolveExtensionImpl(val abstractProcessor: AbstractProcessor) : SyntheticResolveExtension {


    override fun generateSyntheticSecondaryConstructors(thisDescriptor: ClassDescriptor, bindingContext: BindingContext, result: MutableCollection<ClassConstructorDescriptor>) {
        super.generateSyntheticSecondaryConstructors(thisDescriptor, bindingContext, result)
    }

    override fun getSyntheticFunctionNames(thisDescriptor: ClassDescriptor): List<Name> {
        return super.getSyntheticFunctionNames(thisDescriptor)
    }


    override fun generateSyntheticClasses(thisDescriptor: ClassDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: ClassMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
        //  abstractProcessor.log("SyntheticResolveExtensionImpl    generateSyntheticClasses"+abstractProcessor.configuration.guessingPlatform())

        val platform = abstractProcessor.configuration.guessingPlatform()
        val roundEnvironment = RoundEnvironment(platform)

        if (abstractProcessor.getSupportedPlatform().contains(platform) ||
                abstractProcessor.getSupportedPlatform().contains(Platform.ALL)
        ) {
            ClassParser.parse(thisDescriptor, abstractProcessor, roundEnvironment)

        }
        super.generateSyntheticClasses(thisDescriptor, name, ctx, declarationProvider, result)
    }

    override fun generateSyntheticMethods(
            thisDescriptor: ClassDescriptor,
            name: Name,
            bindingContext: BindingContext,
            fromSupertypes: List<SimpleFunctionDescriptor>,
            result: MutableCollection<SimpleFunctionDescriptor>
    ) {
        result.forEachIndexed { index, function ->
            ClassParser.parseMethod(thisDescriptor, function, abstractProcessor, RoundEnvironment(abstractProcessor.configuration.guessingPlatform()))
        }
    }

    override fun generateSyntheticProperties(thisDescriptor: ClassDescriptor, name: Name, bindingContext: BindingContext, fromSupertypes: ArrayList<PropertyDescriptor>, result: MutableSet<PropertyDescriptor>) {

        result.forEach {
            ClassParser.parseProperty(it, abstractProcessor, RoundEnvironment(abstractProcessor.configuration.guessingPlatform()))
        }

        super.generateSyntheticProperties(thisDescriptor, name, bindingContext, fromSupertypes, result)
    }

}
