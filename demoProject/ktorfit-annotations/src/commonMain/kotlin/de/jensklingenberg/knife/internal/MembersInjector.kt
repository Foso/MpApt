package de.jensklingenberg.knife.internal

interface MembersInjector<T> {

    fun injectMembers(instance: T)
}