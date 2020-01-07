package de.jensklingenberg

import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.SourceFile
import de.jensklingenberg.mpapt.common.MpAptProject
import de.jensklingenberg.mpapt.common.simpleName
import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.RoundEnvironment
import de.jensklingenberg.testAnnotations.*
import org.jetbrains.kotlin.codegen.extensions.ClassBuilderInterceptorExtension


import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.StorageComponentContainerContributor
import org.jetbrains.kotlin.js.translate.extensions.JsSyntheticTranslateExtension
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.junit.Assert
import org.junit.Test

open class TestCommonComponentRegistrar(val mpAptTestProcessor: AbstractProcessor) : ComponentRegistrar {

    override fun registerProjectComponents(
            project: MockProject,
            configuration: CompilerConfiguration
    ) {
        val processor = mpAptTestProcessor
        val mpapt = MpAptProject(processor, configuration)
        StorageComponentContainerContributor.registerExtension(project, mpapt)
        ClassBuilderInterceptorExtension.registerExtension(project, mpapt)
        JsSyntheticTranslateExtension.registerExtension(project, mpapt)

    }
}
annotation class TestAnnotation()



class CompilerPluginsTest {


    val kotlinSource2 = SourceFile.kotlin("KClass.kt", """
        package de.jensklingenberg.testAnnotations

@TestTypeAlias
typealias Word = String

@TestAnnotationClass
annotation class  AnnotatedAnnotatedClass

         @TestClass
    class Annotated @TestConstructor constructor() {

    constructor(name: String) : this()

    @TestProperty
    @TestField
    lateinit var myProperty: @TestType String

    var jens: String
        @TestPropertyGetter get() {
           return "Hello"
        }
        @TestPropertySetter set(value) {

        }

    @TestFunction
    fun firstFunction() : String {
           @TestExpression return ""
    }


    fun thirdFunction(@TestValueParameter param: @TestTypeParameter String) {
      @TestLocalVariable val localHallo :String
    }

}
    """)





    @Test
    fun `find class Annotation`() {

        var actualFoundName = ""


        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestClass::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestClass::class.java.name).forEach {
                    when (it) {
                        is Element.ClassElement -> {
                            actualFoundName = it.simpleName
                        }
                    }
                }
            }
        }



        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("Annotated", actualFoundName)
    }




    @Test
    fun `find function Annotation`() {

        var actualFoundName = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestFunction::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestFunction::class.java.name).forEach {
                    when (it) {
                        is Element.FunctionElement -> {
                            actualFoundName = it.func.simpleName()
                        }
                    }
                }


            }
        }



        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("firstFunction", actualFoundName)
    }

    @Test
    fun `find property Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestProperty::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestProperty::class.java.name).forEach {
                    when (it) {
                        is Element.PropertyElement -> {
                            actualFound = it.propertyDescriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("myProperty",actualFound)
    }





    @Test
    fun `find valueparameter Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestValueParameter::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestValueParameter::class.java.name).forEach {
                    when (it) {
                        is Element.ValueParameterElement -> {
                            actualFound = it.valueParameterDescriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("param",actualFound)
    }


    @Test
    fun `find typeparameter Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestTypeParameter::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestTypeParameter::class.java.name).forEach {
                    when (it) {
                        is Element.TypeParameterElement -> {
                            actualFound = it.typeParameterDescriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("param",actualFound)
    }

    @Test
    fun `find typealias Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestTypeAlias::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestTypeAlias::class.java.name).forEach {
                    when (it) {
                        is Element.TypeAliasElement -> {
                            actualFound = it.descriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("Word",actualFound)
    }

    @Test
    fun `find propertygetter Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestPropertyGetter::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestPropertyGetter::class.java.name).forEach {
                    when (it) {
                        is Element.PropertyGetterElement -> {
                            actualFound = it.propertyGetterDescriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("<get-jens>",actualFound)
    }

    @Test
    fun `find propertysetter Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestPropertySetter::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestPropertySetter::class.java.name).forEach {
                    when (it) {
                        is Element.PropertySetterElement -> {
                            actualFound = it.propertySetterDescriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("<set-jens>",actualFound)
    }

    @Test
    fun `find type Annotation`() {

      //TODO:
        Assert.assertTrue(false)
    }

    @Test
    fun `find testfile Annotation`() {

        //TODO:
        Assert.assertTrue(false)
    }

    @Test
    fun `find expression Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestExpression::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestExpression::class.java.name).forEach {
                    when (it) {
                        is Element.ExpressionElement -> {
                            actualFound = it.parentDescriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("firstFunction",actualFound)
    }


    @Test
    fun `find Annotation class Annotation`() {

        var actualFoundName = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestAnnotationClass::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestAnnotationClass::class.java.name).forEach {
                    when (it) {
                        is Element.AnnotationClassElement -> {
                            actualFoundName = it.simpleName
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)

            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertEquals("AnnotatedAnnotatedClass", actualFoundName)
    }

    @Test
    fun `find constructor Annotation`() {

        var actualFound = false

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestConstructor::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestConstructor::class.java.name).forEach {
                    when (it) {
                        is Element.ClassConstructorElement -> {
                            actualFound = true
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()
        Assert.assertTrue(actualFound)
    }

    @Test
    fun `find field Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestField::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestField::class.java.name).forEach {
                    when (it) {
                        is Element.FieldElement -> {
                            actualFound = it.descriptor.correspondingProperty.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()

        Assert.assertEquals("myProperty", actualFound)
    }

    @Test
    fun `find localVariable Annotation`() {

        var actualFound = ""

        val annotationProcessor = object : AbstractProcessor() {
            override fun getSupportedAnnotationTypes(): Set<String> = setOf(TestLocalVariable::class.java.name)

            override fun process(roundEnvironment: RoundEnvironment) {
                roundEnvironment.getElementsAnnotatedWith(TestLocalVariable::class.java.name).forEach {
                    when (it) {
                        is Element.LocalVariableElement -> {
                            actualFound = it.localVariableDescriptor.name.toString()
                        }
                    }
                }
            }
        }

        val result = KotlinCompilation().apply {
            sources = listOf(kotlinSource2)


            // pass your own instance of a compiler plugin
            compilerPlugins = listOf(TestCommonComponentRegistrar(annotationProcessor))

            inheritClassPath = true
            messageOutputStream = System.out // see diagnostics in real time
        }.compile()

        Assert.assertEquals("localHallo", actualFound)
    }

}