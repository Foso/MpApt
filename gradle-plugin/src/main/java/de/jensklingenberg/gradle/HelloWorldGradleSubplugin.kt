package de.jensklingenberg.gradle

import com.google.auto.service.AutoService
import org.gradle.api.Project
import org.gradle.api.tasks.compile.AbstractCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinGradleSubplugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

@AutoService(KotlinGradleSubplugin::class) // don't forget!
class HelloWorldGradleSubplugin : KotlinGradleSubplugin<AbstractCompile> {
    override fun apply(
        project: Project,
        kotlinCompile: AbstractCompile,
        javaCompile: AbstractCompile?,
        variantData: Any?,
        androidProjectHandler: Any?,
        kotlinCompilation: KotlinCompilation<KotlinCommonOptions>?
    ): List<SubpluginOption> {
        val extension = project.extensions.findByType(DebugLogGradleExtension::class.java)
            ?: DebugLogGradleExtension()

        println("apply Hello World!   "+project.name   )


        val enabledOption = SubpluginOption(key = "enabled", value = extension.enabled.toString())
        val annotationOptions = extension.annotations.map { SubpluginOption(key = "debugLogAnnotation", value = it) }

        return listOf(enabledOption)

    }



    override fun isApplicable(project: Project, task: AbstractCompile): Boolean {

        println("isApplicable Hello World!   "+task.name   )


        return project.plugins.hasPlugin(HelloWorldGradlePlugin::class.java)
    }


    /**
     * Just needs to be consistent with the key for CommandLineProcessor#pluginId
     */
    override fun getCompilerPluginId(): String = "helloWorldPlugin"

    override fun getPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        groupId = "de.jensklingenberg",
        artifactId = "kotlin-compiler-plugin",
        version = "0.0.1" // remember to bump this version before any release!
    )

    override fun getNativeCompilerPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        groupId = "de.jensklingenberg",
        artifactId = "kotlin-compiler-native-plugin",
        version = "0.0.1" // remember to bump this version before any release!
    )
}
