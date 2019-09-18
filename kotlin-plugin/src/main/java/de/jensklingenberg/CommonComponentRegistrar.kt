package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.common.MpAptProject
import org.jetbrains.kotlin.base.kapt3.KaptFlag
import org.jetbrains.kotlin.base.kapt3.KaptOptions
import org.jetbrains.kotlin.base.kapt3.logString
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.MessageRenderer
import org.jetbrains.kotlin.cli.common.messages.PrintingMessageCollector
import org.jetbrains.kotlin.cli.jvm.config.JavaSourceRoot
import org.jetbrains.kotlin.cli.jvm.config.JvmClasspathRoot
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.JVMConfigurationKeys
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.kapt3.AbstractKapt3Extension
import org.jetbrains.kotlin.kapt3.Kapt3ComponentRegistrar
import org.jetbrains.kotlin.kapt3.base.LoadedProcessors
import org.jetbrains.kotlin.kapt3.base.incremental.IncrementalProcessor
import org.jetbrains.kotlin.kapt3.util.MessageCollectorBackedKaptLogger
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

/**
 * This is the entry class for a compiler plugin
 */
@AutoService(ComponentRegistrar::class)
open class CommonComponentRegistrar : ComponentRegistrar {

    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
        val processor = MpAptTestProcessor()
        val mpapt = MpAptProject(processor,configuration)
        StorageComponentContainerContributor.registerExtension(project,mpapt)
        ClassBuilderInterceptorExtension.registerExtension(project,mpapt)
        JsSyntheticTranslateExtension.registerExtension(project,mpapt)


        KaptComponentRegistrar().registerProjectComponents(project,configuration)

    }

    companion object {
        /** This kapt compiler plugin is instantiated by K2JVMCompiler using
         *  a service locator. So we can't just pass parameters to it easily.
         *  Instead we need to use a thread-local global variable to pass
         *  any parameters that change between compilations
         */
        val threadLocalParameters: ThreadLocal<Parameters> = ThreadLocal()
    }

    data class Parameters(
            val processors: List<IncrementalProcessor>,
            val kaptOptions: KaptOptions.Builder
    )
}
