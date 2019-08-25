package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.descriptors.CallableMemberDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor
import org.jetbrains.kotlin.resolve.source.PsiSourceFile


fun ClassDescriptor.hasAnnotation(name: String): Boolean = this.annotations.hasAnnotation(FqName(name))
fun ClassDescriptor.findAnnotation(name: String): AnnotationDescriptor? = this.annotations.findAnnotation(FqName(name))

fun ClassDescriptor.canonicalFilePath() =
        (this.source.containingFile as PsiSourceFile).psiFile.virtualFile.canonicalPath

fun ClassDescriptor.guessingProjectFolder(): String {
    //Remove <> from module name
    val cleanedModuleName = this.module.simpleName()
    val projectPath = this.canonicalFilePath()?.replaceAfter("$cleanedModuleName/", "")
    return projectPath ?: "Project folder not found"
}

fun ClassDescriptor.guessingSourceSetFolder(): String =
        canonicalFilePath()?.substringBefore(this.fqNameSafe.asString().replace(".", "/")) ?: ""

fun ClassDescriptor.guessingBuildFolder(): String = this.guessingProjectFolder() + "build/"

fun ClassDescriptor.properties(): List<CallableMemberDescriptor> =
        this.properties(CallableMemberDescriptor.Kind.DECLARATION)

fun ClassDescriptor.cannonicalFolderPath(): String = canonicalFilePath()?.replaceAfterLast("/", "") ?: "Unkown"


fun ClassDescriptor.properties(kind: CallableMemberDescriptor.Kind): List<CallableMemberDescriptor> {
    return (this as LazyClassDescriptor).declaredCallableMembers.filter { it.kind == kind }
            .filterIsInstance<PropertyDescriptor>()
}

fun ClassDescriptor.methods(): Collection<CallableMemberDescriptor> = methods(CallableMemberDescriptor.Kind.DECLARATION)


fun ClassDescriptor.methods(kind: CallableMemberDescriptor.Kind): Collection<CallableMemberDescriptor> {
    return (this as LazyClassDescriptor)
            .declaredCallableMembers
            .filter { it.kind.equals(kind) }
            .filterIsInstance<SimpleFunctionDescriptor>()
}
