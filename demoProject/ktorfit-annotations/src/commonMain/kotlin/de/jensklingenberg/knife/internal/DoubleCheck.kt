package de.jensklingenberg.knife.internal

class DoubleCheck<T>(provider: Provider<T>) : Provider<T>,Lazy<T> {


    override fun get(): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}