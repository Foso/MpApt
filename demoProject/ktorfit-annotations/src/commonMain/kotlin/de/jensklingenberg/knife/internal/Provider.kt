package de.jensklingenberg.knife.internal

interface Provider<T> {
    fun get(): T
}