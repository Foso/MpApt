package de.jensklingenberg.ktorfit

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.jensklingenberg.knife.internal.Provider
import kotlin.reflect.KClass


fun main() {
    App()

    val motor = ClassName("de.jensklingenberg.ktorfit.di", "Motor")

    val module = ClassName("de.jensklingenberg.ktorfit.di", "TestModule")
    val secondModule = ClassName("de.jensklingenberg.ktorfit.di", "SecondModule")

    val provideFunctionName = "provideCar"

    val providedType = ClassName("de.jensklingenberg.ktorfit.di", "Car")

    val className = module.simpleName + "_" + provideFunctionName.capitalize() + "Factory"


    val filePath = "/home/jens/Code/2019/MpApt/demoProject/example/src/jvmMain/kotlin/de/jensklingenberg/ktorfit/build"

    // generateFactory(GenFactoryClass(dependencies = deps, module = module, providerMethod = ProviderMethod(provideFunctionName, providedType), className = className, filePath = filePath))

    val test = InjectProperty("test", ClassName("de.jensklingenberg.ktorfit", "Test"))

    val car = InjectProperty("car", ClassName("de.jensklingenberg.ktorfit", "Car"))
    val motorp = InjectProperty("motor", ClassName("de.jensklingenberg.ktorfit", "Motor"))

    val injectTargetClass = ClassName("de.jensklingenberg.ktorfit", "Kodein_AppComponent")

    val injectedProperterties = listOf(test, car, motorp)

    val modules = listOf(module,secondModule)
    val compInterface = ClassName("de.jensklingenberg.ktorfit.di", "AppComponent")

    val funcs = listOf<ComponentFunction>(ComponentFunction("inject",ParameterType("myPresenter", ClassName("","MyPresenter"))))

    generateCompo(GenAppComponent(injectTargetClass, compInterface,injectedProperterties, modules,funcs))

}

class InjectProperty(val name: String, val type: ClassName)

class ParameterType(val name:String,val type: ClassName)
class ComponentFunction(val name:String, val valueParameter: ParameterType)
class GenAppComponent(val injectedClass: ClassName,val compInterface: ClassName, val injectProperty: List<InjectProperty> = emptyList(), val modules: List<ClassName>, val componetFuncions : List<ComponentFunction> = emptyList())

fun generateCompo(genAppComponent: GenAppComponent) {
    val instanceArgName = "instance"

    val constructorParameterList = genAppComponent.modules
            .map {
                val propName = it.simpleName.toLowerCase()
                ParameterSpec.builder(propName , it).build()
            }
    val injectTargetClass = genAppComponent.injectedClass

    val companionfunctionsList = genAppComponent.injectProperty.map {
        val propName = it.type.simpleName.toLowerCase()
        FunSpec.builder("inject" + it.type.simpleName)
                .addParameter(ParameterSpec.builder(instanceArgName, injectTargetClass).build())
                .addParameter(ParameterSpec.builder(propName, it.type).build())
                .addStatement("instance.${it.name}=$propName")
                .build()
    }

    val builderClass =ClassName("","Builder")

    val companion = TypeSpec.companionObjectBuilder()
            .addFunction( FunSpec.builder("builder")
                    .returns(builderClass)
                    .addStatement("return  Builder()")
                    .build())
            .build()

    val membersInjectorFunctionStatement = genAppComponent.injectProperty.map {
        val propName = it.type.simpleName.toLowerCase()

        "inject" + it.type.simpleName + "(" + instanceArgName + ",${propName}Provider.get())"
    }

    val props = genAppComponent.injectProperty.map { it.type }
            .map {
                val propName = it.simpleName.toLowerCase()
                PropertySpec.builder(propName + "Provider", it.asParameterOf(Provider::class)).initializer(it.simpleName.toLowerCase() + "Provider").build()
            }


    val builderFuncs = genAppComponent.modules.map {
        FunSpec.builder(it.simpleName.toLowerCase())
                .returns(builderClass)
                .addParameter(ParameterSpec.builder(instanceArgName, it).build())
                .addStatement(" this.testModule = MPreconditions.checkNotNull(testModule)")
                .addStatement(" this")

                .build()
    }


    val builder = TypeSpec.classBuilder(builderClass)
            .addFunctions(builderFuncs)


            .build()


    val membersInjectorFunction = FunSpec.builder("injectMembers").addParameter(ParameterSpec.builder("instance", injectTargetClass)
            // .defaultValue("\"pie\"")
            .build())
            .addStatements(membersInjectorFunctionStatement)
            .addModifiers(KModifier.OVERRIDE)
            .build()

    val file = FileSpec.builder("data", "${injectTargetClass.simpleName}_MembersInjector2")
            .addType(TypeSpec.classBuilder(injectTargetClass.simpleName)
                    .addSuperinterface(genAppComponent.compInterface)
                    .addType(companion)
                    .addProperties(props)
                    .primaryConstructor(FunSpec.constructorBuilder()
                            .addParameters(constructorParameterList)
                            .build())
                    .addType(builder)

                    .addFunction(membersInjectorFunction)

                    .build())
            .build()
    file.writeTo(System.out)
    // file.writeTo(File("/home/jens/Code/2019/MpApt/demoProject/example/src/jvmMain/kotlin/de/jensklingenberg/ktorfit/anno"))

}


class ProviderMethod(val name: String, val providedType: ClassName)

class GenFactoryClass(val dependencies: List<ClassName> = emptyList(), val module: ClassName, val providerMethod: ProviderMethod, val className: String, val filePath: String)


fun ClassName.asParameterOf(asClassName: KClass<*>): ParameterizedTypeName {
    return asClassName.asClassName().parameterizedBy(this)

}


private fun FunSpec.Builder.addStatements(statements: List<String>): FunSpec.Builder {

    statements.forEach {
        addStatement(it)
    }

    return this

}




