package de.jensklingenberg.knife.internal

interface Lazy<T> {
    fun get(): T
}