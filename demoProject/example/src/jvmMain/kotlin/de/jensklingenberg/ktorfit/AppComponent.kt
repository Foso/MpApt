package de.jensklingenberg.ktorfit

import de.jensklingenberg.knife.Component
import de.jensklingenberg.ktorfit.di.SecondModule

import de.jensklingenberg.ktorfit.di.TestModule
import de.jensklingenberg.ktorfit.di.ThirdModule

@Component(modules = [TestModule::class, SecondModule::class])
interface AppComponent {
    fun inject(myPresenter: MyPresenter)


}