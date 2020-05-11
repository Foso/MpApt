package de.jensklingenberg.mpapt.model

import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.descriptors.impl.LocalVariableDescriptor
import org.jetbrains.kotlin.psi.KtExpression

sealed class Element constructor(
        open val simpleName: String = "",
        open val path: String = "",
        open val elementKind: ElementKind = ElementKind.OTHER,
        open val annotation: AnnotationDescriptor? = null,
        open val pack: String = ""
) {
    /**
     * Elements annotated with [AnnotationTarget.CLASS]
     */
    data class ClassElement(
            override val simpleName: String = "",
            override val path: String = "",
            override val elementKind: ElementKind = ElementKind.CLASS,
            override val annotation: AnnotationDescriptor? = null,
            override val pack: String = "",
            val classDescriptor: ClassDescriptor
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.ANNOTATION_CLASS]
     */
    data class AnnotationClassElement(
            override val simpleName: String = "",
            override val path: String = "",
            override val elementKind: ElementKind = ElementKind.CLASS,
            override val annotation: AnnotationDescriptor? = null,
            override val pack: String = "",
            val classDescriptor: ClassDescriptor
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.FUNCTION]
     */
    data class FunctionElement(
            override val simpleName: String,
            override val elementKind: ElementKind = ElementKind.FUNCTION,
            override val annotation: AnnotationDescriptor? = null,
            val descriptor: ClassOrPackageFragmentDescriptor,
            val func: FunctionDescriptor
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.PROPERTY]
     */
    data class PropertyElement(val propertyDescriptor: PropertyDescriptor,
                               override val annotation: AnnotationDescriptor? = null,
                               override val elementKind: ElementKind = ElementKind.PROPERTY
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.VALUE_PARAMETER]
     */
    data class ValueParameterElement(val valueParameterDescriptor: ValueParameterDescriptor,
                                     override val annotation: AnnotationDescriptor? = null,
                                     override val elementKind: ElementKind = ElementKind.VALUE_PARAMETER
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.TYPE_PARAMETER]
     */
    data class TypeParameterElement(val typeParameterDescriptor: TypeParameterDescriptor,
                                    override val annotation: AnnotationDescriptor? = null,
                                    override val elementKind: ElementKind = ElementKind.TYPE_PARAMETER
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.PROPERTY_GETTER]
     */
    data class PropertyGetterElement(val propertyGetterDescriptor: PropertyGetterDescriptor,
                                     override val annotation: AnnotationDescriptor? = null,
                                     override val elementKind: ElementKind = ElementKind.PROPERTY_GETTER
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.PROPERTY_SETTER]
     */
    data class PropertySetterElement(val propertySetterDescriptor: PropertySetterDescriptor,
                                     override val annotation: AnnotationDescriptor? = null,
                                     override val elementKind: ElementKind = ElementKind.PROPERTY_SETTER
    ) : Element()


    /**
     * Elements annotated with [AnnotationTarget.CONSTRUCTOR]
     */
    data class ClassConstructorElement(val classConstructorDescriptor: ClassConstructorDescriptor,
                                       override val annotation: AnnotationDescriptor? = null,
                                       override val elementKind: ElementKind = ElementKind.CONSTRUCTOR
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.LOCAL_VARIABLE]
     */
    data class LocalVariableElement(val localVariableDescriptor: LocalVariableDescriptor,
                                    override val annotation: AnnotationDescriptor? = null,
                                    override val elementKind: ElementKind = ElementKind.LOCAL_VARIABLE
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.TYPEALIAS]
     */
    data class TypeAliasElement(val descriptor: TypeAliasDescriptor,
                                override val annotation: AnnotationDescriptor? = null,
                                override val elementKind: ElementKind = ElementKind.ALIAS
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.FIELD]
     */
    data class FieldElement(val descriptor: FieldDescriptor,
                            override val annotation: AnnotationDescriptor? = null,
                            override val elementKind: ElementKind = ElementKind.FIELD
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.FILE]
     */
    data class FileElement(override val annotation: AnnotationDescriptor? = null,
                           override val elementKind: ElementKind = ElementKind.FILE
    ) : Element()

    /**
     * Elements annotated with [AnnotationTarget.EXPRESSION]
     */
    data class ExpressionElement(val ktExpression: KtExpression,
                                 override val annotation: AnnotationDescriptor? = null,
                                 val parentDescriptor: DeclarationDescriptor,
                                 override val elementKind: ElementKind = ElementKind.EXPRESSION
    ) : Element()

}


enum class ElementKind {
    /** Class, interface or object, annotation class is also included */
    CLASS,
    /** Annotation class only */
    ANNOTATION_CLASS,
    /** Generic type parameter (unsupported yet) */
    TYPE_PARAMETER,
    /** Property */
    PROPERTY,
    /** Field, including property's backing field */
    FIELD,
    /** Local variable */
    LOCAL_VARIABLE,
    /** Value parameter of a function or a constructor */
    VALUE_PARAMETER,
    /** Constructor only (primary or secondary) */
    CONSTRUCTOR,
    /** Function (constructors are not included) */
    FUNCTION,
    /** Property getter only */
    PROPERTY_GETTER,
    /** Property setter only */
    PROPERTY_SETTER,
    /** Type usage */
    TYPE,
    /** Any expression */
    EXPRESSION,
    /** File */
    FILE,
    /** Type alias */
    OTHER,
    /** Type alias */
    ALIAS
}