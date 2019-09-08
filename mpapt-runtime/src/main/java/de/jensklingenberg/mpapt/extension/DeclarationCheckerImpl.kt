package de.jensklingenberg.mpapt.extension

import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.resolve.checkers.DeclarationChecker
import org.jetbrains.kotlin.resolve.checkers.DeclarationCheckerContext

/**
 * This gets called on Native/JS/JVM
 * I can get the descriptors
 *
 * TODO: Look if i can use this class instead of SyntheticResolveExtension
 */
class DeclarationCheckerImpl : DeclarationChecker{
    override fun check(declaration: KtDeclaration, descriptor: DeclarationDescriptor, context: DeclarationCheckerContext) {


        when(descriptor){
            is SimpleFunctionDescriptor->{
                println("SimpleFunctionDescriptor  "+descriptor.name)
            }
            is ClassConstructorDescriptor->{
                println("ClassConstructorDescriptor  "+descriptor.name)
            }
            is ClassDescriptor ->{
                println("ClassDescriptor  "+descriptor.name)
            }
            is PropertyGetterDescriptor->{
                println("PropertyGetterDescriptor  "+descriptor.name)
            }
            is PropertySetterDescriptor->{
                println("PropertySetterDescriptor  "+descriptor.name)
            }
        }
    }

}