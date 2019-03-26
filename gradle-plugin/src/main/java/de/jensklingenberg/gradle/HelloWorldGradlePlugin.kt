package de.jensklingenberg.gradle

import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.logging.LogLevel
import org.gradle.api.logging.Logging

import org.gradle.util.GradleVersion
import java.io.File

open class HelloWorldGradlePlugin : org.gradle.api.Plugin<Project> {


    companion object {
        private val LOGGER = Logging.getLogger(HelloWorldGradlePlugin::class.java)
        const val CONFIGURATION_NAME = "errorprone"
        const val PLUGIN_ID = "MpApt"

        const val CONFIGURATION_DETEKT = "detekt"

        const val CONFIGURATION_DETEKT_PLUGINS = "detektPlugins"
        internal const val DEFAULT_DETEKT_VERSION = "1.0.0-RC12"

    }




    override fun apply(project: Project) {

        if (GradleVersion.current() < GradleVersion.version("4.6")) {
            throw UnsupportedOperationException("$PLUGIN_ID requires at least Gradle 4.6")
        }

       val extension= project.extensions.create(
                PLUGIN_ID,
                DebugLogGradleExtension::class.java
        )

        project.configurations.create(CONFIGURATION_DETEKT_PLUGINS) { configuration ->
            configuration.isTransitive = true

            configuration.description = "The $CONFIGURATION_DETEKT_PLUGINS libraries to be used for this project."
        }
 LOGGER.log(LogLevel.WARN,"Hehhsdf")
        LOGGER.log(LogLevel.WARN,project.projectDir.absolutePath)

        configurePluginDependencies(project, extension)



     val task =  project.tasks.create<HelloWorldTask>("clearGenerated", HelloWorldTask::class.java)
        val task2 =  project.tasks.create<TestSource>("dodo", TestSource::class.java)


     //   task.finalizedBy(project.getTasksByName("build",true).first())

        println("HelloWorldGradlePlugin Hello World!   "+project   )


    }

    private fun configurePluginDependencies(project: Project, extension: DebugLogGradleExtension) {




    }
}
