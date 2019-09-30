package de.jensklingenberg.knife

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
annotation class Component(
        val modules: Array<KClass<*>> = emptyArray()
)