package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.ProcessorProject
import de.jensklingenberg.mpapt.extension.ExpressionCodegenExtensionImpl
import de.jensklingenberg.mpapt.extension.SyntheticResolveExtensionImpl
import org.jetbrains.kotlin.codegen.ExpressionCodegen
import org.jetbrains.kotlin.codegen.extensions.ExpressionCodegenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.resolve.extensions.SyntheticResolveExtension

@AutoService(ComponentRegistrar::class)
open class CommonComponentRegistrar : ComponentRegistrar {



    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
       val annotationProcessor = MpAptTestProcessor(configuration)
        val test = MpAptTestProcessor(configuration)
        //ProcessorProject.init(project, test)
        ExpressionCodegenExtension.registerExtension(project, ExpressionCodegenExtensionImpl(test))

        SyntheticResolveExtension.registerExtension(project, SyntheticResolveExtensionImpl(test))

    }
}

