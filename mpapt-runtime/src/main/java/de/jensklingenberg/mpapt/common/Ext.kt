package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.resolve.constants.KClassValue
import kotlin.reflect.KClass
import kotlin.reflect.KProperty


fun MessageCollector.warn(s: String) {
    report(
            CompilerMessageSeverity.WARNING, s
    )
}


/**
 * In the Kotlin Native Compiler the configuration map has an entry with the name "target we compile for"
 * the value is one of [de.jensklingenberg.mpapt.utils.KonanTargetValues]. I don't know how to get the value
 * out of the configuration map other than parse the "toString()". This function will return an empty value
 * when it's used on Kotlin JVM/JS Compiler because the CompilerConfiguration doesn't have that value.
 */
fun CompilerConfiguration.nativeTargetPlatformName(): String {
    val targetKeyword = "target we compile for="
    val mapString = this.toString()
    return if (!mapString.contains(targetKeyword)) {
        ""
    } else {
        this.toString().substringAfter(targetKeyword).substringBefore(",")
    }
}

fun KClass<*>.propertyNames(): List<String> = this.members.filterIsInstance<KProperty<*>>().map { it.name }

fun KClassValue.getVariableNames(moduleDescriptor: ModuleDescriptor): List<Name> =
        this.getArgumentType(moduleDescriptor).memberScope.getVariableNames().toList()


private fun KtProperty.hasAnnotation(name: String): Boolean {
    return this.annotationEntries.any { name.contains(it.shortName?.identifier ?: "") }

}
