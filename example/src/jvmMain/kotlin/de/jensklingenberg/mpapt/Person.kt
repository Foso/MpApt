package de.jensklingenberg.mpapt

import de.jensklingenberg.testAnnotations.Redacted
import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.jetbrains.kotlin.com.intellij.openapi.util.Disposer
import org.jetbrains.kotlin.config.CompilerConfiguration


class Person(val name: String, @Redacted val ssn: String,@Redacted val ssn2: String)
private val project by lazy {
    KotlinCoreEnvironment.createForProduction(
            Disposer.newDisposable(),
            CompilerConfiguration(),
            EnvironmentConfigFiles.JVM_CONFIG_FILES //Can be JS/NATIVE_CONFIG_FILES for non JVM projects
    ).project
}
fun main() {
    val person = Person("John Doe", "123-456-7890","3333")

    println(person) // --> Person(name=John Doe, ssn="HELLO", ssn2="HELLO")

}