package de.jensklingenberg.compiler.extension

import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.lazy.LazyClassContext
import org.jetbrains.kotlin.resolve.lazy.declarations.ClassMemberDeclarationProvider

class SynthResol(val messageCollector: AbstractProcessor) : SyntheticResolveExtension {


    override fun generateSyntheticClasses(thisDescriptor: ClassDescriptor, name: Name, ctx: LazyClassContext, declarationProvider: ClassMemberDeclarationProvider, result: MutableSet<ClassDescriptor>) {
       val th = thisDescriptor
      //  parse(thisDescriptor,messageCollector)

    }


}
