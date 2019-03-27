package de.jensklingenberg.compiler.common

import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.resolve.constants.ConstantValue
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor
import org.jetbrains.kotlin.resolve.source.PsiSourceFile


fun ClassDescriptor.hasAnnotation(name: String): Boolean {
    return this.annotations.hasAnnotation(FqName(name))

}


fun PropertyDescriptor.hasAnnotation(name: String): Boolean {
    return this.annotations.hasAnnotation(FqName(name))
}

fun ClassDescriptor.findAnnotation(name: String): AnnotationDescriptor? {
    return this.annotations.findAnnotation(FqName(name))
}

fun AnnotationDescriptor.readArgument(key: String): ConstantValue<*>? {
    return this.allValueArguments.get(Name.identifier(key))
}

fun ModuleDescriptor.simpleName() = this.name.asString().replace("<", "").replace(">", "")


fun ClassDescriptor.cannonicalFilePath() = (this.source.containingFile as PsiSourceFile).psiFile.virtualFile.canonicalPath


fun ClassDescriptor.guessingProjectFolder(): String {
    //Remove <> from module name
    val cleanedModuleName = this.module.simpleName()
    val projectPath = this.cannonicalFilePath()?.replaceAfter(cleanedModuleName + "/", "")


    return projectPath ?: "Project folder not found"
}


fun ClassDescriptor.guessingBuildFolder(): String = this.guessingProjectFolder() + "build/"

fun ClassDescriptor.properties(): List<CallableMemberDescriptor> {
    return properties(CallableMemberDescriptor.Kind.DECLARATION)
}

fun ClassDescriptor.properties(kind : CallableMemberDescriptor.Kind): List<CallableMemberDescriptor> {
    return (this as LazyClassDescriptor).declaredCallableMembers.filter { it.kind.equals(kind) }.filter { it is PropertyDescriptor }
}


fun ClassDescriptor.methods(): Collection<CallableMemberDescriptor> {

    // (it as LazyClassDescriptor).declaredCallableMembers.filter { it.kind.equals(CallableMemberDescriptor.Kind.DECLARATION) }.filter { it is PropertyDescriptor }

    return methods(CallableMemberDescriptor.Kind.DECLARATION)
}


fun ClassDescriptor.methods(kind : CallableMemberDescriptor.Kind): Collection<CallableMemberDescriptor> {

    // (it as LazyClassDescriptor).declaredCallableMembers.filter { it.kind.equals(CallableMemberDescriptor.Kind.DECLARATION) }.filter { it is PropertyDescriptor }

    return (this as LazyClassDescriptor).declaredCallableMembers.filter { it.kind.equals(kind) }.filter { it is SimpleFunctionDescriptor }
}


fun AnnotationDescriptor?.simpleName(): String {
    return this?.fqName?.shortName()?.asString() ?: "No Name"

}


/*
Get ClassDescriptor from referenced class in annoations
@Extension(to = [CommonHello::class])

val targetClass = (element.annotation?.readArgument("to")?.value as ArrayList<KClassValue>).map { it.getArgumentType(element.descriptor.module)?.constructor?.declarationDescriptor as? ClassDescriptor }.filterNotNull()



Get properties
    (it as LazyClassDescriptor).declaredCallableMembers.filter { it is PropertyDescriptor }


Get only user created fields/methods
    (it as LazyClassDescriptor).declaredCallableMembers.filter { it.kind == CallableMemberDescriptor.Kind.DECLARATION }

 */