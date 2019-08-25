package de.jensklingenberg.mpapt.extension

import org.jetbrains.kotlin.com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.kotlin.com.intellij.testFramework.LightVirtualFile
import org.jetbrains.kotlin.extensions.PreprocessedVirtualFileFactoryExtension

class MetaPreprocessedVirtualFileFactoryExtension : PreprocessedVirtualFileFactoryExtension {
    override fun createPreprocessedFile(file: VirtualFile?): VirtualFile? = file

    override fun createPreprocessedLightFile(file: LightVirtualFile?): LightVirtualFile? = file

    override fun isPassThrough(): Boolean = true

}
