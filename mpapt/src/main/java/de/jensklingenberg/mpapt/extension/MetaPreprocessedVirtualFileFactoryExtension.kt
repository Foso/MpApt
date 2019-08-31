package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile
import org.jetbrains.kotlin.extensions.PreprocessedVirtualFileFactoryExtension

class MetaPreprocessedVirtualFileFactoryExtension(abstractProcessor: AbstractProcessor) : PreprocessedVirtualFileFactoryExtension {
    init {
        abstractProcessor.log("MetaPreprocessedVirtualFileFactoryExtension")
    }

    override fun createPreprocessedFile(file: VirtualFile?): VirtualFile? = file

    override fun createPreprocessedLightFile(file: LightVirtualFile?): LightVirtualFile? = file

    override fun isPassThrough(): Boolean = true

}
