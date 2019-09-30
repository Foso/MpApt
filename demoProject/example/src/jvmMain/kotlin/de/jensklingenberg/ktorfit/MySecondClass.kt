package de.jensklingenberg.ktorfit

import de.jensklingenberg.knife.annotations.Xinject
import de.jensklingenberg.ktorfit.di.Car
import de.jensklingenberg.ktorfit.di.Test

class MySecondClass(){

    @Xinject
    lateinit var test: Test

    @Xinject
    lateinit var car : Car

    init {
        println("MySendCloas")


    }

}