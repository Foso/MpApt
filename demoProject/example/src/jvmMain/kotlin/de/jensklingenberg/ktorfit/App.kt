package de.jensklingenberg.ktorfit

import de.jensklingenberg.ktorfit.knife.ngenerated.KodeinAppComponent
import de.jensklingenberg.ktorfit.di.TestModule


class App() :Contract.View{

    companion object {
        lateinit var appi: AppComponent
    }

    init {
        appi = KodeinAppComponent.builder()
                .testModule(TestModule())
                .build()
        println("Hey")
        MyPresenter(this)
        MySecondClass()
    }
}


