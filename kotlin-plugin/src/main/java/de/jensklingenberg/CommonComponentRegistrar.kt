package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.ProcessorProject
import de.jensklingenberg.mpapt.extension.AnalysisHandlerExtensionImpl
import de.jensklingenberg.mpapt.extension.ExpressionCodegenExtensionImpl
import de.jensklingenberg.mpapt.extension.MetaIrGenerationExtension
import de.jensklingenberg.mpapt.extension.SyntheticResolveExtensionImpl
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.codegen.ExpressionCodegen
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisHandlerExtension

@AutoService(ComponentRegistrar::class)
open class CommonComponentRegistrar : ComponentRegistrar {



    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
       val annotationProcessor = MpAptTestProcessor(configuration)
        val test = MpAptTestProcessor(configuration)
        //ProcessorProject.init(project, test)
        AnalysisHandlerExtension.registerExtension(project, AnalysisHandlerExtensionImpl(test.messageCollector))

        ExpressionCodegenExtension.registerExtension(project, ExpressionCodegenExtensionImpl(test))
        IrGenerationExtension.registerExtension(project, MetaIrGenerationExtension(test))
        SyntheticResolveExtension.registerExtension(project, SyntheticResolveExtensionImpl(test))
    }
}

