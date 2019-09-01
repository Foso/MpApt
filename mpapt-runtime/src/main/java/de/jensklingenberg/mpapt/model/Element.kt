package de.jensklingenberg.mpapt.model

import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.descriptors.annotations.AnnotationDescriptor
import org.jetbrains.kotlin.psi.KtProperty

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
     * Elements annotated with [AnnotationTarget.FUNCTION]
     */
    data class FunctionElement(
            override val simpleName: String,
            override val elementKind: ElementKind = ElementKind.FUNCTION,
            override val annotation: AnnotationDescriptor? = null,
            val descriptor: ClassDescriptor,
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
    OTHER
}