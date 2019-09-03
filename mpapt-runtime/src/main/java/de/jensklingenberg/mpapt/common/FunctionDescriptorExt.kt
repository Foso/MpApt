package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.model.FunctionParameter
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.descriptors.FunctionDescriptor
import org.jetbrains.kotlin.descriptors.SourceElement
import org.jetbrains.kotlin.resolve.source.KotlinSourceElement
import org.jetbrains.kotlin.resolve.source.getPsi


/**
 * TODO: i dont know how to get the packageName of a function parameter
 */
fun FunctionDescriptor.getFunctionParameters(): List<FunctionParameter> {
    //@de.ktorfit.POST public abstract suspend fun postPictures(helloWorld: sample.model.HelloWorld): kotlin.Unit defined in sample.data.Api[SimpleFunctionDescriptorImpl@470930f5]

    return if (valueParameters.isNotEmpty()) {
        this.valueParameters.map { parameter ->
            // normal:
            //value-parameter id: kotlin.Int defined in de.jensklingenberg.mpapt.CommonAnnotated.firstFunction2[ValueParameterDescriptorImpl@725a91a6]
            // Typedefs:
            //value-parameter id: de.jensklingenberg.mpapt.Datum /* = kotlin.ranges.CharProgression */ defined in de.jensklingenberg.mpapt.CommonAnnotated.firstFunction2[ValueParameterDescriptorImpl@692444bb]
            val fullPackage = parameter.toString().substringAfter(": ")
                .substringBefore(" defined")
                .substringBefore(" /* =")
            FunctionParameter(
                parameter.name.asString(),
                parameter.type.toString().endsWith("?"),
                Package(
                    fullPackage.split(".").last().replace("?", ""),
                    fullPackage.split(".").dropLast(1).joinToString(".")
                )
            )
        }.toList()
    } else {
        emptyList()
    }


}

/**
 * I dont know how to get full package of the return type
 */
fun FunctionDescriptor.getReturnTypeImport(): String = this.toString().substringAfter("): ").substringBefore(" defined")

fun FunctionDescriptor.simpleName(): String = this.name.asString()

/**
 * getPsi() on Kotlin Native was always crashing
 */
fun SourceElement.safeAsPsi(): PsiElement? {
    if (this is KotlinSourceElement) {
        return this.psi
    } else {
        this.getPsi()
    }
    return null
}


