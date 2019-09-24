package de.jensklingenberg.mpapt.common

import org.jetbrains.kotlin.kapt3.AbstractKapt3Extension
import org.jetbrains.kotlin.kapt3.base.LoadedProcessors

class AbstractKapt3Extension1(val list: kotlin.collections.List<org.jetbrains.kotlin.kapt3.base.incremental.IncrementalProcessor>,
                              options: org.jetbrains.kotlin.base.kapt3.KaptOptions,
                              logger: org.jetbrains.kotlin.kapt3.util.MessageCollectorBackedKaptLogger,
                              configuration: org.jetbrains.kotlin.config.CompilerConfiguration) : AbstractKapt3Extension(options, logger, configuration) {

    override fun loadProcessors() = LoadedProcessors(
            processors = list,
            classLoader = this::class.java.classLoader
    )
}