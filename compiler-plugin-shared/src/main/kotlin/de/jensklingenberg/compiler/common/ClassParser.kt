package de.jensklingenberg.compiler.common

import de.jensklingenberg.compiler.kaptmpp.AbstractProcessor
import de.jensklingenberg.compiler.kaptmpp.Element
import de.jensklingenberg.compiler.kaptmpp.Platform
import de.jensklingenberg.compiler.kaptmpp.RoundEnvironment
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.resolve.descriptorUtil.module
import org.jetbrains.kotlin.resolve.source.PsiSourceFile

class ClassParser() {


    companion object {
        val TAG = "dd"


        fun parse(descriptor: ClassDescriptor, generator: AbstractProcessor,roundEnvironment:RoundEnvironment) {
            val file = descriptor.source.containingFile
            val moduleName = descriptor.module.name.asString()

            val targetClass = descriptor

            val buildFolder = guessingProjectFolder(targetClass)+ "build/"
            generator.processingEnv.projectFolder=guessingProjectFolder(targetClass)
            generator.processingEnv.buildFolder = buildFolder
            generator.log("Reading class " + targetClass.name)


            val haAn = targetClass.hasAnnotation("de.jensklingenberg.annotation.Extension")
            val constructor = targetClass.constructors.first { it.isPrimary }
            val extAnno = targetClass.findAnnotation("de.jensklingenberg.annotation.Extension")
//


            generator.getSupportedAnnotationTypes().forEach { annotation ->
                if (targetClass.hasAnnotation(annotation)) {
                    roundEnvironment.elements.add(Element.ClassElement(targetClass.name.asString(), annotation = annotation,descriptor=targetClass))
                    generator.process(roundEnvironment)
                }

            }


            //Find Annotations of class
            descriptor.annotations.forEach {

                if (generator.getSupportedAnnotationTypes().contains(it.fqName?.shortName().toString())) {

                    generator.log(TAG + "*** IT' YYYYY  ***"+roundEnvironment.platform.name + targetClass.name)

                    val element = Element.ClassElement(
                            simpleName = targetClass.name.asString() ?: "",
                            annotation = it.fqName?.shortName().toString(),
                            pack = "ddd",
                            descriptor = targetClass//generator.configuration.kotlinSourceRoots
                    )

                    roundEnvironment.elements.add(element)
                    generator.process(roundEnvironment)

                }


            }



        }

        private fun guessingProjectFolder(descriptor: ClassDescriptor): String {
            //Remove <> from module name
            val cleanedModuleName = descriptor.module.name.asString().replace("<", "").replace(">", "")

            val projectPath = (descriptor.source.containingFile as PsiSourceFile).psiFile.virtualFile.canonicalPath?.replaceAfter(cleanedModuleName + "/", "")



            return projectPath?:"Project folder not found"

        }

        fun parseMethod(function: FunctionDescriptor,generator: AbstractProcessor,roundEnvironment:RoundEnvironment) {

            generator.getSupportedAnnotationTypes().forEach { annotation ->

                generator.log(TAG + "*** IT' YYYYY  ***"+annotation.toString())


                if(function.annotations.hasAnnotation(FqName(annotation))){
                    val func= function.annotations.findAnnotation(FqName(annotation))
                    val annotation = func?.fqName?.shortName().toString()

                    generator.process(RoundEnvironment(Platform.JVM).also { it.elements.add(Element.FunctionElement(simpleName = func?.fqName?.shortName()?.asString()?:"",annotation = "sample.FunExt")) })

                }

            }



        }

    }




}