package de.jensklingenberg.mpapt

import org.gradle.api.Project

open class MpAptGradlePlugin : org.gradle.api.Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create(
                "ktorfit",
                TestCompilerExtension::class.java
        )
    }
}

open class TestCompilerExtension {
    var enabled: Boolean = true
}
