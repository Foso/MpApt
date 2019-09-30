package de.jensklingenberg.ktorfit.knife.ngenerated

import de.jensklingenberg.knife.internal.MPreconditions
import de.jensklingenberg.knife.internal.Provider
import de.jensklingenberg.ktorfit.*
import de.jensklingenberg.ktorfit.di.*

class KodeinAppComponent(val testModule: TestModule) : AppComponent {


    private var provideDatabaseNameProvider: TestModule_ProvideDatabaseNameFactory? = null

    var testProvider: Provider<Test>? = null
    var carProvider: Provider<Car>? = null
    var motorProvider:Provider<Motor>?=null
    init {
        initialize(testModule)
    }

    private fun initialize(testModule: TestModule) {
        this.motorProvider = TestModule_ProvideMotorFactory.create(testModule)
        this.testProvider = TestModule_ProvideTestFactory(testModule)
        this.carProvider = TestModule_ProvideCarFactory.create(testModule,motorProvider!!)
        this.provideDatabaseNameProvider = TestModule_ProvideDatabaseNameFactory.create(testModule)

    }

    override fun inject(myPresenter: MyPresenter) {
        injectMyPresenter(myPresenter)
    }



    private fun injectMyPresenter(instance: MyPresenter): KodeinAppComponent {
        MyPresenter_MembersInjector.injectTest(instance, testProvider!!.get())
        MyPresenter_MembersInjector.injectCar(instance, carProvider!!.get())

        return this
    }

    class Builder() {
        var testModule: TestModule? = null

        fun build(): AppComponent {
            return KodeinAppComponent(testModule ?: TestModule())
        }

        fun testModule(testModule: TestModule): Builder {
            this.testModule = MPreconditions.checkNotNull(testModule)
            return this
        }
    }

    companion object {
        fun builder() = Builder()

    }
}