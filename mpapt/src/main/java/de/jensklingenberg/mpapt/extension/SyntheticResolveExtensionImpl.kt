package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.RoundEnvironment
import de.jensklingenberg.mpapt.common.ClassParser
import de.jensklingenberg.mpapt.common.guessingPlatform
import de.jensklingenberg.mpapt.model.Platform
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.lazy.LazyClassContext
import org.jetbrains.kotlin.resolve.lazy.declarations.ClassMemberDeclarationProvider
import org.jetbrains.kotlin.resolve.lazy.declarations.PackageMemberDeclarationProvider
import org.jetbrains.kotlin.types.KotlinType
import java.util.*

class SyntheticResolveExtensionImpl(val abstractProcessor: AbstractProcessor) : SyntheticResolveExtension {


    override fun generateSyntheticSecondaryConstructors(thisDescriptor: ClassDescriptor, bindingContext: BindingContext, result: MutableCollection<ClassConstructorDescriptor>) {
        super.generateSyntheticSecondaryConstructors(thisDescriptor, bindingContext, result)
    }

    override fun getSyntheticFunctionNames(thisDescriptor: ClassDescriptor): List<Name> {
        return super.getSyntheticFunctionNames(thisDescriptor)
    }

    override fun getSyntheticNestedClassNames(thisDescriptor: ClassDescriptor): List<Name> {
        return super.getSyntheticNestedClassNames(thisDescriptor)
    }

    override fun generateSyntheticClasses(thisDescriptor: ClassDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: ClassMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
        //  abstractProcessor.log("SyntheticResolveExtensionImpl    generateSyntheticClasses"+abstractProcessor.configuration.guessingPlatform())


        super.generateSyntheticClasses(thisDescriptor, name, ctx, declarationProvider, result)
    }

    override fun generateSyntheticClasses(thisDescriptor: PackageFragmentDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: PackageMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
//declarationProvider.getTypeAliasDeclarations(Name("MyString",false))
        //declarationProvider.getTypeAliasDeclarations(Name("MyString",false)).toList().get(0).getAnnotationEntries().map { it.shortName }

        //thisDescriptor.getMemberScope().getDescriptorsFiltered(DescriptorKindFilter.TYPE_ALIASES).first().annotations.hasAnnotation()


        ClassParser.parsePackage(thisDescriptor,abstractProcessor, RoundEnvironment(abstractProcessor.configuration.guessingPlatform()))

        val platform = abstractProcessor.configuration.guessingPlatform()
        val roundEnvironment = RoundEnvironment(platform)
        if (abstractProcessor.getSupportedPlatform().contains(platform) ||
                abstractProcessor.getSupportedPlatform().contains(Platform.ALL)
        ) {

            result.forEach {
                if (!it.isCompanionObject && !name.identifier.equals("Companion")) {
                    // abstractProcessor.log("HEREHREHRHERHERHR")
                    ClassParser.parse(it, abstractProcessor, roundEnvironment)

                }
            }


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
        result.forEach { function ->

            ClassParser.parseMethod(thisDescriptor, function, abstractProcessor, RoundEnvironment(abstractProcessor.configuration.guessingPlatform()))
        }
    }

    //((function.findPsi().children.filterIsInstance<KtBlockExpression>().map { it as KtBlockExpression }.get(0).children.get(0) as KtProperty).annotationEntries.get(0) as KtAnnotationEntry).shortName
    override fun generateSyntheticProperties(thisDescriptor: ClassDescriptor, name: Name, bindingContext: BindingContext, fromSupertypes: ArrayList<PropertyDescriptor>, result: MutableSet<PropertyDescriptor>) {
//function.findPsi().children.filterIsInstance<KtBlockExpression>().get(0).statements.filterIsInstance<KtProperty>().get(0).getAnnotationEntries().get(0).shortName
        result.forEach {
            ClassParser.parseProperty(it, abstractProcessor, RoundEnvironment(abstractProcessor.configuration.guessingPlatform()))
        }

        super.generateSyntheticProperties(thisDescriptor, name, bindingContext, fromSupertypes, result)
    }

    override fun getSyntheticCompanionObjectNameIfNeeded(thisDescriptor: ClassDescriptor): Name? {
        return super.getSyntheticCompanionObjectNameIfNeeded(thisDescriptor)
    }

    override fun addSyntheticSupertypes(thisDescriptor: ClassDescriptor, supertypes: MutableList<KotlinType>) {
        super.addSyntheticSupertypes(thisDescriptor, supertypes)
    }
}
