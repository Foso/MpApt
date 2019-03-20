package de.jensklingenberg.compiler.extension

import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import de.jensklingenberg.compiler.kaptmpp.Platform
import de.jensklingenberg.compiler.kaptmpp.RoundEnvironment
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.lazy.LazyClassContext
import org.jetbrains.kotlin.resolve.lazy.declarations.ClassMemberDeclarationProvider

class SynthResol(val abstractProcessor: AbstractProcessor) : SyntheticResolveExtension {


    override fun generateSyntheticMethods(thisDescriptor: ClassDescriptor, name: Name, bindingContext: BindingContext, fromSupertypes: List<SimpleFunctionDescriptor>, result: MutableCollection<SimpleFunctionDescriptor>) {


        result.forEach { function ->
            //  abstractProcessor.log("SynthResol generateSyntheticMethods:    "+"Class "+ thisDescriptor.name+" with function:"+function.name)

            de.jensklingenberg.compiler.common.ClassParser.parseMethod(thisDescriptor, function, abstractProcessor, RoundEnvironment(Platform.UNKNONWN))



            abstractProcessor.getSupportedAnnotationTypes().forEach { annotation ->

                if (function.annotations.hasAnnotation(FqName(annotation))) {
                    val func = function.annotations.findAnnotation(FqName(annotation))
                    val annotation = func?.fqName?.shortName().toString()

                    //   abstractProcessor.process(RoundEnvironment(Platform.UNKNONWN).also { it.elements.add(Element.FunctionElement(simpleName = function.name.asString(), annotation = "sample.FunExt")) })

                }

            }

        }
    }

    override fun generateSyntheticClasses(thisDescriptor: ClassDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: ClassMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {

        // abstractProcessor.log("SynthResol generateSyntheticClasses  "+ thisDescriptor.name)

        super.generateSyntheticClasses(thisDescriptor, name, ctx, declarationProvider, result)
    }

}
