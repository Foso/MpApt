import org.jetbrains.annotations.TestOnly
import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.jetbrains.kotlin.com.intellij.openapi.util.Disposer
import org.jetbrains.kotlin.config.CompilerConfiguration

fun main() {
     val project by lazy {
        KotlinCoreEnvironment.createForProduction(
                Disposer.newDisposable(),
                CompilerConfiguration(),
                EnvironmentConfigFiles.JVM_CONFIG_FILES //Can be JS/NATIVE_CONFIG_FILES for non JVM projects
        ).project
    }

    println()
}

