package de.jensklingenberg

import com.squareup.kotlinpoet.*
import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.Provider
import java.io.File

fun generateFactory(genFactoryClass: MpAptTestProcessor.GenFactoryClass) {

    val instanceArgName = "instance"

    val provideFunctionName = genFactoryClass.providerMethod.name

    val providedType = genFactoryClass.providerMethod.providedType

    val module = genFactoryClass.module

    val className = genFactoryClass.className

    val neededClassDeps = genFactoryClass.dependencies


    val genProvideFunction = FunSpec.builder(provideFunctionName)
            .addParameter(ParameterSpec.builder(instanceArgName, module).build())
            .addParameters(neededClassDeps.map { ParameterSpec.builder(it.simpleName.toLowerCase(), it).build() })
            .returns(providedType)
            .addCode(getProvideFunctionReturnStatement(provideFunctionName, neededClassDeps.map { it.simpleName.toLowerCase() }))
            .build()

    val genCreateFunction = FunSpec.builder("create")
            .addParameter(ParameterSpec.builder(instanceArgName, module).build())
            .addParameters(neededClassDeps.map { ParameterSpec.builder(it.simpleName.toLowerCase() + "Provider", it.asParameterOf(Provider::class)).build() })
            .addStatement(getCreateFunctionReturnStatement(className, neededClassDeps.map { it.simpleName.toLowerCase() }))
            .build()

    val companion = TypeSpec.companionObjectBuilder()
            .addFunction(genProvideFunction)
            .addFunction(genCreateFunction)
            .build()


    val genGetFunction = FunSpec.builder("get")
            .addStatement(getGetFunctionReturnStatement(provideFunctionName, neededClassDeps.map { it.simpleName.toLowerCase() }))
            .addModifiers(KModifier.OVERRIDE)
            .build()

    val injectTagetClass = ClassName("data", className)


    val constructorProviderParameterList = neededClassDeps.map {
        val propName = it.simpleName.toLowerCase()

        ParameterSpec.builder(propName + "Provider", it.asParameterOf(Provider::class)).build()

    }
    val primConstructor = FunSpec.constructorBuilder()
            .addParameter(ParameterSpec.builder(instanceArgName, module).addModifiers(KModifier.PRIVATE).build())
            .addParameters(constructorProviderParameterList)
            .build()

    val props = neededClassDeps
            .map { PropertySpec.builder(it.simpleName.toLowerCase() + "Provider", it.asParameterOf(Provider::class)).initializer(it.simpleName.toLowerCase() + "Provider").build() }
            .toMutableList()
            .also {
                it.add(
                        PropertySpec.builder(instanceArgName, module).initializer(instanceArgName).build()

                )
            }

    val file = FileSpec.builder(module.packageName, className).addImport("de.jensklingenberg.knife.internal.MPreconditions.Companion", "checkNotNull")
            .addType(TypeSpec
                    .classBuilder(injectTagetClass)
                    .addSuperinterface(providedType.asParameterOf(Factory::class))
                    .primaryConstructor(primConstructor)
                    .addProperties(props)
                    .addFunction(genGetFunction)
                    .addType(companion)
                    .build())
            .build()
    file.writeTo(System.out)
    file.writeTo(File(genFactoryClass.filePath))

    // val inter = Provider::class.asClassName().parameterizedBy(injectTargetClass)

}


fun getProvideFunctionReturnStatement(className: String, injectedObjects: List<String>): String {

    val args = injectedObjects.joinToString { it }

    val mm = """
        |val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
        |return checkNotNull(instance.$className($args), errorMessage  )
    """.trimMargin()
    return mm

}


fun getGetFunctionReturnStatement(provideFunctionName: String, injectedObjects: List<String>): String {


    val args = injectedObjects.joinToString { it + "Provider.get()" }

    val text = if (args.isEmpty()) {
        "instance"
    } else {
        "instance,$args"
    }

    return "return $provideFunctionName( $text)"

}


fun getCreateFunctionReturnStatement(className: String, injectedObjects: List<String>): String {


    val args = injectedObjects.joinToString { it + "Provider" }

    val text = if (args.isEmpty()) {
        "instance"
    } else {
        "instance,$args"
    }

    return "return $className( $text)"

}