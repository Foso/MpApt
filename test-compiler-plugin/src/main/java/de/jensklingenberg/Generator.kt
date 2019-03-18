package de.jensklingenberg

import de.jensklingenberg.annotation.Extension
import de.jensklingenberg.compiler.common.findAnnotation
import de.jensklingenberg.compiler.common.readArgument
import de.jensklingenberg.compiler.kaptmpp.*
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.psi.KtClass
import java.io.File
import kotlin.reflect.KClass

class Generator( configuration: CompilerConfiguration) :
        AbstractProcessor(configuration) {
    override fun getSupportedPlatform() = listOf(Platform.ALL)

    val TAG = "Generator:"


    override fun process(roundEnvironment: RoundEnvironment): Boolean {
        roundEnvironment
                .getElementsAnnotatedWith(Extension::class.qualifiedName.toString())
                .forEach {
                    val es = it

                    configuration.kotlinSourceRoots.forEach {
                        processingEnv.messager.report(
                                CompilerMessageSeverity.WARNING,
                                TAG + "***Test SourceRott "+it.path+ " "+roundEnvironment.platform.name
                        )
                    }


                    when(es){

                        is Element.ClassElement -> {
                            processingEnv.messager.report(
                                    CompilerMessageSeverity.WARNING,
                                    TAG + "***Class "+es.descriptor.findAnnotation("de.jensklingenberg.annotation.Extension")?.readArgument("to")?.value
                            )
                        }
                    }

                    processingEnv.messager.report(
                            CompilerMessageSeverity.WARNING,
                            TAG + "*** process ***" + it.simpleName + " Pack" + it.pack + " Annotation:" + it.annotation+ " buildfolder"+processingEnv.buildFolder
                    )

                    val wallpaperDirectory = File(processingEnv.buildFolder+"/classes/kotlin/generated/")
                    wallpaperDirectory.mkdir()

                    File(processingEnv.buildFolder+"/classes/kotlin/generated/"+"hey.kt").writeText(
                            "class Genetic()"
                    )

                }
        return true
    }


    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()

    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(
                "de.jensklingenberg.annotation.Extension"
        )

    }


    override fun initProcessor() {
        processingEnv.messager.report(
                CompilerMessageSeverity.WARNING,
                //  "*** IT'S ENTER FUNCTION ***"+function.elements.hasAnnotation(FqName("me.eugeniomarletti.Hallo")))
                TAG + "***Processor started ***"
        )

    }




}

