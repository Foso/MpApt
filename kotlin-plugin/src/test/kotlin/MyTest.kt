import org.jetbrains.kotlin.cli.jvm.compiler.EnvironmentConfigFiles
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment
import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.com.intellij.openapi.util.Disposer
import org.jetbrains.kotlin.com.intellij.psi.PsiManager
import org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.idea.KotlinFileType
import org.jetbrains.kotlin.psi.KtFile
import java.io.File

fun main() {
     val project by lazy {
        KotlinCoreEnvironment.createForTests(
                Disposer.newDisposable(),
                CompilerConfiguration(),
                EnvironmentConfigFiles.JVM_CONFIG_FILES //Can be JS/NATIVE_CONFIG_FILES for non JVM projects
        ).project
    }


    val file = File("/home/jens/Code/2019/MpApt/kotlin-plugin/src/main/java/de/jensklingenberg/CommonComponentRegistrar.kt").readText()

    val ktFile = createKtFile(file,"Hallo",project)
    println()
}


fun createKtFile(codeString: String, fileName: String, project: Project) =
        PsiManager.getInstance(project)
                .findFile(
                        LightVirtualFile(fileName, KotlinFileType.INSTANCE, codeString)
                ) as KtFile
