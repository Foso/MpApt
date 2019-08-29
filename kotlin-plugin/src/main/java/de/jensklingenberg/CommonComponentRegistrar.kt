package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.extension.*
import debuglog.plugin.DebugLogClassGenerationInterceptor
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
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
        val test = MpAptTestProcessor(configuration)
        //ProcessorProject.init(project, test)
        AnalysisHandlerExtension.registerExtension(project, AnalysisHandlerExtensionImpl(test.messageCollector))
        JsSyntheticTranslateExtension.registerExtension(project,JsSyntheticTranslateExtensionExt(test))

        ExpressionCodegenExtension.registerExtension(project, ExpressionCodegenExtensionImpl(test))
        IrGenerationExtension.registerExtension(project, MetaIrGenerationExtension(test))
        SyntheticResolveExtension.registerExtension(project, SyntheticResolveExtensionImpl(test))
        ClassBuilderInterceptorExtension.registerExtension(
                project,
                DebugLogClassGenerationInterceptor(test)
        )


    }
}

