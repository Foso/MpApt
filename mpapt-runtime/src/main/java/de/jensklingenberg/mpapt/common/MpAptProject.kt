package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.extension.ProcessorFinishedDetector
import de.jensklingenberg.mpapt.extension.ProcessorFinishedDetectorImpl
import de.jensklingenberg.mpapt.extension.StorageComponentContainerContributorImpl
import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor

class MpAptProject(abstractProcessor: AbstractProcessor, configuration: CompilerConfiguration) :
        ProcessorFinishedDetector by ProcessorFinishedDetectorImpl(abstractProcessor),
        StorageComponentContainerContributor by StorageComponentContainerContributorImpl(abstractProcessor)
{
    init {
        abstractProcessor.configuration = (configuration)
        abstractProcessor.onProcessingStarted()
    }
}