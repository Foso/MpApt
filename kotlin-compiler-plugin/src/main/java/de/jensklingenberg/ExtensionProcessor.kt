package de.jensklingenberg

import com.squareup.kotlinpoet.*
import de.jensklingenberg.annotation.Extension
import de.jensklingenberg.compiler.common.findAnnotation
import de.jensklingenberg.compiler.common.methods
import de.jensklingenberg.compiler.common.readArgument
import de.jensklingenberg.compiler.common.simpleName
import de.jensklingenberg.compiler.kaptmpp.*
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.resolve.constants.KClassValue
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import java.io.File

class ExtensionProcessor(configuration: CompilerConfiguration) :
        AbstractProcessor(configuration) {


    override fun getSupportedPlatform() = listOf(Platform.ALL)

    val TAG = "ExtensionProcessor:"


    override fun process(roundEnvironment: RoundEnvironment): Boolean {


        roundEnvironment
                .getElementsAnnotatedWith(listOf("annotation.Module","sample.FunExt"))
                .forEach { element ->


                    configuration.kotlinSourceRoots.forEach {
                        processingEnv.messager.report(
                                CompilerMessageSeverity.WARNING, ""
                                //      TAG + "***SourceRott " + it.path + " " + roundEnvironment.platform.name
                        )
                    }


                    when (element) {

                        is Element.ClassElement -> {

                            val targetClass = listOf(element.descriptor)
                          //  val targetClass = (element.annotation?.readArgument("to")?.value as ArrayList<KClassValue>).map { it.getArgumentType(element.descriptor.module)?.constructor?.declarationDescriptor as? ClassDescriptor }.filterNotNull()

                            targetClass.forEach {
                                processingEnv.messager.report(
                                        CompilerMessageSeverity.WARNING,
                                        TAG + "***Class " + element.descriptor.name + " annoated with: "+element.annotation.simpleName()+ " " + roundEnvironment.module?.name + " with target class :"+it.name
                                )

                                it.methods().forEach {method->
                                    processingEnv.messager.report(
                                            CompilerMessageSeverity.WARNING,
                                            TAG + "***Method " + method.name
                                    )
                                }

                            }




                        }
                    }

                    processingEnv.messager.report(
                            CompilerMessageSeverity.WARNING, ""
                            //TAG + "*** process ***" + it.simpleName + "\n Pack" + it.pack + "\n Annotation:" + it.annotation + "\n buildfolder" + processingEnv.buildFolder+ "\nplatform: "+roundEnvironment.platform.name
                    )


                    val greeterClass = ClassName("", "Greeter")
                    val file = FileSpec.builder("de.jensklingenberg", "DaggerAppComponent")
                            .addComment("//Generated")
                            .addType(TypeSpec.classBuilder("DaggerAppComponent").addSuperinterface(ClassName("sample", "AppComponent"))
                                    .addFunction(FunSpec.builder("greet")
                                            .addStatement("println(%P)", "Hello, \$name")
                                            .build())
                                    .build())

                            .build()
                    // file.writeTo(File(processingEnv.projectFolder + "generated/jvm/kotlin"))

                }




        roundEnvironment
                .getElementsAnnotatedWith("annotation.Module")
                .forEach {
                    val es = it
                    when (es) {


                        is Element.FunctionElement -> {
                            processingEnv.messager.report(
                                    CompilerMessageSeverity.WARNING,
                                    TAG + "***Function-------> " + es.simpleName +  " annotated with " + es.annotation.simpleName()
                            )
                        }
                    }
                }
        return true
    }


    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()

    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(
                "de.jensklingenberg.annotation.Extension","sample.FunExt","annotation.Module"
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
