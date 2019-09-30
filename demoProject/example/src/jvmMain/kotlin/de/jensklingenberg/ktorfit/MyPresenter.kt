package de.jensklingenberg.ktorfit

import de.jensklingenberg.knife.annotations.Xinject
import de.jensklingenberg.ktorfit.di.Car
import de.jensklingenberg.ktorfit.di.Test

class MyPresenter(val view: Contract.View): Contract.Presenter {


    @Xinject
    lateinit var test: Test

    @Xinject
    lateinit var car : Car

    init {
        App.appi.inject(this)
        test.druck()
        car.start()
        println(car.motor.name)
    }
}

