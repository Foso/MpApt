package de.jensklingenberg


import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import de.jensklingenberg.knife.Component
import de.jensklingenberg.knife.annotations.Module
import de.jensklingenberg.knife.annotations.Provides
import de.jensklingenberg.knife.annotations.Xinject
import de.jensklingenberg.knife.internal.MembersInjector
import de.jensklingenberg.knife.internal.Provider
import de.jensklingenberg.mpapt.common.nativeTargetPlatformName
import de.jensklingenberg.mpapt.common.readArgument
import de.jensklingenberg.mpapt.model.AbstractProcessor
import de.jensklingenberg.mpapt.model.Element
import de.jensklingenberg.mpapt.model.RoundEnvironment
import de.jensklingenberg.mpapt.utils.KonanTargetValues
import de.jensklingenberg.mpapt.utils.KotlinPlatformValues
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.descriptors.ValueParameterDescriptor
import org.jetbrains.kotlin.platform.TargetPlatform
import org.jetbrains.kotlin.resolve.constants.KClassValue
import org.jetbrains.kotlin.resolve.descriptorUtil.fqNameSafe
import org.jetbrains.kotlin.resolve.lazy.descriptors.LazyClassDescriptor
import java.io.File
import kotlin.reflect.KClass

class MpAptTestProcessor() : AbstractProcessor() {
    val TAG = "MyAnnotationProcessor"

    val provides = Provides::class.java.name
    val xinject = Xinject::class.java.name

    val component = Component::class.java.name
    val module = Module::class.java.name
    val provideFunctions = mutableListOf<Element.FunctionElement>()
    val injectedProperties = mutableListOf<Element.PropertyElement>()
    val moduleClasses = mutableListOf<Element.ClassElement>()
    val componentClasses = mutableListOf<Element.ClassElement>()


    override fun process(roundEnvironment: RoundEnvironment) {

        roundEnvironment.getElementsAnnotatedWith(provides).forEach { element ->
            when (element) {
                is Element.FunctionElement -> {
                    provideFunctions.add(element)
                }
            }
        }
        roundEnvironment.getElementsAnnotatedWith(xinject).forEach { element ->
            when (element) {
                is Element.PropertyElement -> {
                    //getFunctions.add(element.func)
                    injectedProperties.add(element)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(module).forEach { element ->
            when (element) {
                is Element.ClassElement -> {
                    moduleClasses.add(element)
                    //getFunctions.add(element.func)
                }
            }
        }

        roundEnvironment.getElementsAnnotatedWith(component).forEach { element ->
            when (element) {
                is Element.ClassElement -> {
                    componentClasses.add(element)

                    //getFunctions.add(element.func)
                }
            }
        }

    }

    override fun isTargetPlatformSupported(platform: TargetPlatform): Boolean {
        val targetName = platform.first().platformName

        return when (targetName) {
            KotlinPlatformValues.JS -> false
            KotlinPlatformValues.JVM -> true
            KotlinPlatformValues.NATIVE -> {
                return when (configuration.nativeTargetPlatformName()) {
                    KonanTargetValues.LINUX_X64, KonanTargetValues.MACOS_X64 -> {
                        false
                    }
                    else -> {
                        false
                    }
                }
            }
            else -> {
                log(targetName)
                false
            }
        }

    }

    override fun getSupportedAnnotationTypes(): Set<String> = setOf(provides, xinject, component, module)

    override fun processingOver() {
        /**
         * Read the values from the Component Annotation
         */
        val selectedModulesPackages = componentClasses.first().annotation?.readArgument("modules")?.map { it.value as KClassValue.Value.NormalClass }?.map { it.value.toString().replace("/", ".") }
                ?: emptyList()
        val i = 1

        /**
         * Get all the modules that are set in the Component Annotation
         */
        val selectedModules = moduleClasses.filter {
            val desc = it.classDescriptor
            val packageName = desc.containingDeclaration.fqNameSafe.toString()

            val path = packageName + "." + desc.name
            //  path.equals("de.jensklingenberg.ktorfit.di.SecondModule")
            selectedModulesPackages.contains(path)
        }

        /**
         * Get all the provideFunctions in Modules that are used by AppComponent
         */
        val funcsInSelectedModules = provideFunctions.filter { func -> selectedModules.any { it.classDescriptor == func.descriptor } }


        //componentClasses.first().annotation.readArgument("modules")
        ////moduleClasses.map { it.classDescriptor }.filter { it.containingDeclaration.fqNameSafe }


        // generateMembers()
        // (componentClasses.first().classDescriptor as LazyClassDescriptor).declaredCallableMembers
        val injectFunctionsInComponent = (componentClasses.first().classDescriptor as LazyClassDescriptor).declaredCallableMembers
       val classImportThatUseInject = injectFunctionsInComponent.flatMap { it.valueParameters }.map { it.getTypePackage()+"."+it.type }
        log("$TAG***Processor over ***")
        val filePath = "/home/jens/Code/2019/MpApt/demoProject/example/src/jvmMain/build"


        funcsInSelectedModules.map { it.func }.forEach {

            val containingClassDes = it.containingDeclaration as ClassDescriptor

            val module = ClassName(containingClassDes.getPackage(), it.containingDeclaration.name.asString())

            val provideFunctionName = it.name.toString()

            val providedType = ClassName(it.returnTypePackage(), it.returnType.toString())

            val className = module.simpleName + "_" + provideFunctionName.capitalize() + "Factory"


            val deps = it.valueParameters.map {
                ClassName(it.getTypePackage(), it.returnType.toString())
            }
            generateFactory(GenFactoryClass(dependencies = deps, module = module, providerMethod = ProviderMethod(provideFunctionName, providedType), className = className, filePath = filePath))
        }
        //groupPropsByClass.filterKeys { it.fqNameSafe.asString() == "de.jensklingenberg.ktorfit.MyPresenter" }
        val groupPropsByClass = injectedProperties.map { it.propertyDescriptor }.groupBy { it.containingDeclaration }
        injectedProperties.map { it.propertyDescriptor }.groupBy { it.containingDeclaration }
                .forEach { (entry, vale) ->

                    if(classImportThatUseInject.none { it == entry.fqNameSafe.asString() }){

                        return
                    }

                    val injectProperties = vale.map { InjectProperty(it.name.asString(), ClassName(it.getTypePackage(), it.type.toString())) }

                    val injectTargetClass = ClassName((entry as ClassDescriptor).getPackage(), entry.name.asString())

                    generateMemberInjectors(GenMemberInjector(injectedClass = injectTargetClass, injectProperty = injectProperties, filePath = filePath))

                }

    }


    class InjectProperty(val name: String, val type: ClassName)
    class GenMemberInjector(val injectedClass: ClassName, val injectProperty: List<InjectProperty> = emptyList(), val filePath: String)

    fun generateMemberInjectors(genMemberInjector: GenMemberInjector) {
        val instanceArgName = "instance"

        val constructorParameterList = genMemberInjector.injectProperty.map { it.type }
                .map {
                    val propName = it.simpleName.toLowerCase()
                    ParameterSpec.builder(propName + "Provider", it.asParameterOf(Provider::class)).build()
                }
        val injectTargetClass = genMemberInjector.injectedClass

        val companionfunctionsList = genMemberInjector.injectProperty.map {
            val propName = it.type.simpleName.toLowerCase()
            FunSpec.builder("inject" + it.type.simpleName)
                    .addParameter(ParameterSpec.builder(instanceArgName, injectTargetClass).build())
                    .addParameter(ParameterSpec.builder(propName, it.type).build())
                    .addStatement("instance.${it.name}=$propName")
                    .build()
        }


        val companion = TypeSpec.companionObjectBuilder()
                .addFunctions(companionfunctionsList)
                .build()

        val membersInjectorFunctionStatement = genMemberInjector.injectProperty.map {
            val propName = it.type.simpleName.toLowerCase()

            "inject" + it.type.simpleName + "(" + instanceArgName + ",${propName}Provider.get())"
        }

        val props = genMemberInjector.injectProperty.map { it.type }
                .map {
                    val propName = it.simpleName.toLowerCase()
                    PropertySpec.builder(propName + "Provider", it.asParameterOf(Provider::class)).initializer(it.simpleName.toLowerCase() + "Provider").build()
                }


        val membersInjectorFunction = FunSpec.builder("injectMembers").addParameter(ParameterSpec.builder("instance", injectTargetClass)
                // .defaultValue("\"pie\"")
                .build())
                .addStatements(membersInjectorFunctionStatement)
                .addModifiers(KModifier.OVERRIDE)
                .build()

        val file = FileSpec.builder(genMemberInjector.injectedClass.packageName, "${injectTargetClass.simpleName}_MembersInjector")
                .addType(TypeSpec.classBuilder("${injectTargetClass.simpleName}_MembersInjector")
                        .addSuperinterface(injectTargetClass.asParameterOf(MembersInjector::class))
                        .addType(companion)
                        .addProperties(props)
                        .primaryConstructor(FunSpec.constructorBuilder()
                                .addParameters(constructorParameterList)
                                .build())

                        .addFunction(membersInjectorFunction)

                        .build())
                .build()
        //file.writeTo(System.out)
        file.writeTo(File(genMemberInjector.filePath))

    }


    fun ClassDescriptor.getPackage(): String {
        return this.original.fqNameSafe.asString().substringBefore("." + this.original.name)
    }

    fun ValueParameterDescriptor.getTypePackage(): String {
        return toString().substringAfter(name.asString() + ":").substringBefore(".$type").trim()
    }

    fun PropertyDescriptor.getTypePackage(): String {
        return toString().substringAfter(name.asString() + ":").substringBefore(".$type").trim()
    }

    private fun FunctionDescriptor.returnTypePackage(): String {
        return this.toString().substringAfter("): ").substringBefore("." + this.returnType.toString())
    }

    class ProviderMethod(val name: String, val providedType: ClassName)

    class GenFactoryClass(val dependencies: List<ClassName> = emptyList(), val module: ClassName, val providerMethod: ProviderMethod, val className: String, val filePath: String)


    private fun FunSpec.Builder.addStatements(statements: List<String>): FunSpec.Builder {

        statements.forEach {
            addStatement(it)
        }

        return this

    }


}

fun ClassName.asParameterOf(asClassName: KClass<*>): ParameterizedTypeName {
    return asClassName.asClassName().parameterizedBy(this)

}

private fun FunSpec.Builder.addStatements(statements: List<String>): FunSpec.Builder {

    statements.forEach {
        addStatement(it)
    }

    return this

}