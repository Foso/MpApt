package de.jensklingenberg.gradle

open class HelloWorldGradlePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {



    override fun apply(project: org.gradle.api.Project) {
        project.extensions.create(
            "MpApt",
                DebugLogGradleExtension::class.java
        )

     val task =  project.tasks.create<HelloWorldTask>("generateJagger", HelloWorldTask::class.java)


     //   task.finalizedBy(project.getTasksByName("build",true).first())

        println("HelloWorldGradlePlugin Hello World!   "+project   )


    }
}