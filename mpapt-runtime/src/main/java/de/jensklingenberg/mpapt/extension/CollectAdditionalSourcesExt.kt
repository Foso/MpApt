package de.jensklingenberg.mpapt.extension

import org.jetbrains.kotlin.com.intellij.openapi.project.Project
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.CollectAdditionalSourcesExtension
import org.jetbrains.kotlin.psi.KtFile

class CollectAdditionalSourcesExt : CollectAdditionalSourcesExtension{
    override fun collectAdditionalSourcesAndUpdateConfiguration(knownSources: Collection<KtFile>, configuration: CompilerConfiguration, project: Project): Collection<KtFile> {

        return knownSources
    }

}