package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.Annotated
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.js.resolve.diagnostics.findPsi
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor
import org.jetbrains.kotlin.resolve.source.PsiSourceFile
import java.io.File


fun Annotated.hasAnnotation(name: String): Boolean = this.annotations.hasAnnotation(FqName(name))
fun Annotated.findAnnotation(name: String): AnnotationDescriptor? = this.annotations.findAnnotation(FqName(name))

//TODO:this doesnt work with Native
fun ClassDescriptor.canonicalFilePath() =
        (this.source.containingFile as PsiSourceFile).psiFile.virtualFile.canonicalPath

/**
 * This will guess the build folder from filepath
 * A better way is to get the build folder from gradle plugin and pass it to the compiler plugin
 */
fun ClassDescriptor.guessingProjectFolder(): String {

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

private fun KtProperty.hasAnnotation(name: String): Boolean {
    return this.annotationEntries.any { name.contains(it.shortName?.identifier ?: "") }

}

private fun FunctionDescriptor.ktproperties(): List<KtProperty> {
    return this.findPsi()?.children?.filterIsInstance<KtBlockExpression>()?.flatMap { it.statements.filterIsInstance<KtProperty>() }
            ?: emptyList()
}