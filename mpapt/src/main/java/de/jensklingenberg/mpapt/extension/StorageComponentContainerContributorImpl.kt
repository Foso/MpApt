package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.AbstractProcessor
import org.jetbrains.kotlin.container.StorageComponentContainer
import org.jetbrains.kotlin.container.useInstance
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.platform.TargetPlatform

class StorageComponentContainerContributorImpl(val processor: AbstractProcessor) : StorageComponentContainerContributor {

    override fun registerModuleComponents(container: StorageComponentContainer, platform: TargetPlatform, moduleDescriptor: ModuleDescriptor) {
       // container.useInstance(SerializationPluginDeclarationChecker())

    }



}