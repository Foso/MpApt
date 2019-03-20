package de.jensklingenberg

import com.squareup.kotlinpoet.*
import de.jensklingenberg.annotation.Extension
import de.jensklingenberg.compiler.common.findAnnotation
import de.jensklingenberg.compiler.common.readArgument
import de.jensklingenberg.compiler.kaptmpp.*
import org.jetbrains.kotlin.cli.common.config.kotlinSourceRoots
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.resolve.constants.KClassValue
import org.jetbrains.kotlin.resolve.descriptorUtil.module

class ExtensionProcessor(configuration: CompilerConfiguration) :
        AbstractProcessor(configuration) {
    override fun getSupportedPlatform() = listOf(Platform.ALL)

    val TAG = "ExtensionProcessor:"


    override fun process(roundEnvironment: RoundEnvironment): Boolean {


        roundEnvironment
                .getElementsAnnotatedWith(Extension::class.qualifiedName.toString())
                .forEach { element ->


                    configuration.kotlinSourceRoots.forEach {
                        processingEnv.messager.report(
                                CompilerMessageSeverity.WARNING, ""
                                //      TAG + "***SourceRott " + it.path + " " + roundEnvironment.platform.name
                        )
                    }


                    when (element) {

//      (element.annotation.readArgument("to").value as ArrayList<KClassValue>).first().getArgumentType(element.descriptor.module)?.constructor?.declarationDescriptor as? ClassDescriptor
                        is Element.ClassElement -> {

                            val targetClass = (element.annotation?.readArgument("to")?.value as ArrayList<KClassValue>).first().getArgumentType(element.descriptor.module)?.constructor?.declarationDescriptor as? ClassDescriptor


                            processingEnv.messager.report(
                                    CompilerMessageSeverity.WARNING,
                                    TAG + "***Class " + element.descriptor.name + " annoated with: "+element.annotation.simpleName()+ " " + roundEnvironment.module?.name + " with target class :"+targetClass?.name
                            )
                        }
                    }

                    processingEnv.messager.report(
                            CompilerMessageSeverity.WARNING, ""
                            //TAG + "*** process ***" + it.simpleName + "\n Pack" + it.pack + "\n Annotation:" + it.annotation + "\n buildfolder" + processingEnv.buildFolder+ "\nplatform: "+roundEnvironment.platform.name
                    )


                    val greeterClass = ClassName("", "Greeter")
                    val file = FileSpec.builder("de.jensklingenberg", "HelloWorld")
                            .addComment("//Generated")
                            .addType(TypeSpec.classBuilder("Greeter")
                                    .primaryConstructor(FunSpec.constructorBuilder()
                                            .addParameter("name", String::class)
                                            .build())
                                    .addProperty(PropertySpec.builder("name", String::class)
                                            .initializer("name")
                                            .build())
                                    .addFunction(FunSpec.builder("greet")
                                            .addStatement("println(%P)", "Hello, \$name")
                                            .build())
                                    .build())
                            .addFunction(FunSpec.builder("main")
                                    .addParameter("args", String::class, KModifier.VARARG)
                                    .addStatement("%T(args[0]).greet()", greeterClass)
                                    .build())
                            .build()

                    // file.writeTo(File(processingEnv.projectFolder + "/src/jsMain/kotlin/generated/"))

                }


        roundEnvironment
                .getElementsAnnotatedWith("sample.FunExt")
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
                "de.jensklingenberg.annotation.Extension","sample.FunExt"
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

private fun AnnotationDescriptor?.simpleName(): String {
    return this?.fqName?.shortName()?.asString()?: "No Name"

}

