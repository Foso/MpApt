package de.jensklingenberg.mpapt.extension

import de.jensklingenberg.mpapt.model.AbstractProcessor
import org.jetbrains.kotlin.codegen.ClassBuilder
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.resolve.jvm.diagnostics.JvmDeclarationOrigin
import org.jetbrains.org.objectweb.asm.FieldVisitor
import org.jetbrains.org.objectweb.asm.MethodVisitor

class DelegatingClassBuilderImpl(
        val delegateBuilder: ClassBuilder) : org.jetbrains.kotlin.codegen.DelegatingClassBuilder() {
    override fun getDelegate() = delegateBuilder


    override fun newMethod(
            origin: JvmDeclarationOrigin, access: Int, name: String, desc: String, signature: String?, exceptions: Array<out String>?
    ): MethodVisitor {
        //  test.log("newMethod:   "+name)
        //  ClassParser.parseMethod(origin.descriptor as ClassDescriptor,)
        when (origin.descriptor) {
            is ClassDescriptor -> {
                val i = 1

            }
            is ClassConstructorDescriptor -> {
                val i = 1

            }
            is PropertyGetterDescriptor -> {
                val i = 1

            }
            is PropertySetterDescriptor -> {
                val i = 1

            }
            is SimpleFunctionDescriptor -> {
                val i = 1
            }
            else -> {

            }

        }
        val original = super.newMethod(origin, access, name, desc, signature, exceptions)
        return original
    }


    override fun newField(origin: JvmDeclarationOrigin, access: Int, name: String, desc: String, signature: String?, value: Any?): FieldVisitor {

        /**
         * Property
         */
        when (origin.descriptor) {
            is PropertyDescriptor -> {
                val i = 1

            }
            else -> {

            }
        }

        return super.newField(origin, access, name, desc, signature, value)
    }

}