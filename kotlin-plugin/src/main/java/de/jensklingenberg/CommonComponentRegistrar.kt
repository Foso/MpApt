package de.jensklingenberg

import com.google.auto.service.AutoService
import de.jensklingenberg.mpapt.ProcessorProject
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(ComponentRegistrar::class)
open class CommonComponentRegistrar : ComponentRegistrar {



    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
       val annotationProcessor = MpAptTestProcessor(configuration)
        val test = MpAptTestProcessor(configuration)
        ProcessorProject.init(project, test)
       // ProcessorProject.init(project, annotationProcessor)

    }
}

