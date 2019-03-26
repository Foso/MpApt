package de.jensklingenberg.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.file.FileTree
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.SourceTask
import org.gradle.api.tasks.TaskAction
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption
import java.io.File

open class HelloWorldTask : DefaultTask() {



    override fun getGroup(): String? {
        return "mpApt"
    }

    @TaskAction
    fun doHelloWorld() {

        val extension = project.extensions.findByType(DebugLogGradleExtension::class.java)
                ?: DebugLogGradleExtension()

        val enabledOption = SubpluginOption(key = "enabled", value = extension.enabled.toString())


        File(project.projectDir.absolutePath+"/generated/jvm").deleteRecursively()



        println("Hello ddWorld!"+project.name+ extension.enabled.toString()+"   "+project.state.executed)
    }
}


open class TestSource : SourceTask(){


    override fun source(vararg sources: Any?): SourceTask {
        println(sources)
        return super.source(*sources)
    }

    @TaskAction
    fun doHelloWorld() {

        val extension = project.extensions.findByType(DebugLogGradleExtension::class.java)
                ?: DebugLogGradleExtension()

        val enabledOption = SubpluginOption(key = "enabled", value = extension.enabled.toString())





        println("Hello ddWorld!"+project.name+ extension.enabled.toString()+"   "+project.state.executed)
    }


}