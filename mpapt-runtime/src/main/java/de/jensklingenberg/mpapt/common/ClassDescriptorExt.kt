package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.descriptors.CallableMemberDescriptor
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor
import org.jetbrains.kotlin.resolve.source.PsiSourceFile
import java.io.File

//TODO:this doesnt work with Native
fun ClassDescriptor.canonicalFilePath() =
        (this.source.containingFile as PsiSourceFile).psiFile.virtualFile.canonicalPath

/**
 * This will guess the build folder from filepath
 * A better way is to get the build folder from gradle plugin and pass it to the compiler plugin
 */
fun ClassDescriptor.guessingBuildFolder(): String {

    tailrec fun findBuildFolder(path: String): String {
        val preSrcDir = path.substringBeforeLast("/src")
        return if (path == preSrcDir || File(preSrcDir, "build").isDirectory) {
            "$preSrcDir/build"
        } else {
            findBuildFolder(preSrcDir)
        }
    }

    val buildFolder = this.canonicalFilePath()?.let { path -> findBuildFolder(path) }

    return buildFolder ?: "Build folder not found"

}

fun ClassDescriptor.guessingSourceSetFolder(): String =
        canonicalFilePath()?.substringBefore(this.fqNameSafe.asString().replace(".", "/")) ?: ""

fun ClassDescriptor.properties(): List<CallableMemberDescriptor> =
        this.properties(CallableMemberDescriptor.Kind.DECLARATION)

fun ClassDescriptor.cannonicalFolderPath(): String = canonicalFilePath()?.replaceAfterLast("/", "") ?: "Unknown"

fun ClassDescriptor.properties(kind: CallableMemberDescriptor.Kind): List<CallableMemberDescriptor> {
    return (this as LazyClassDescriptor).declaredCallableMembers.filter { it.kind == kind }
            .filterIsInstance<PropertyDescriptor>()
}

fun ClassDescriptor.methods(): Collection<CallableMemberDescriptor> = methods(CallableMemberDescriptor.Kind.DECLARATION)

fun ClassDescriptor.methods(kind: CallableMemberDescriptor.Kind): Collection<CallableMemberDescriptor> {
    return (this as LazyClassDescriptor)
            .declaredCallableMembers
            .filter { it.kind == kind }
            .filterIsInstance<SimpleFunctionDescriptor>()
}
