package de.jensklingenberg.ktorfit.di


import de.jensklingenberg.knife.annotations.Module
import de.jensklingenberg.knife.annotations.Provides

@Module
class TestModule() {

    @Provides
    fun provideDatabaseName(): String {
        return "demo-dagger.db"
    }

    @Provides
    fun provideCar(motor: Motor) = Car("Honda",motor)


    @Provides
    fun provideTest() = Test()

    @Provides
    fun provideMotor()=Motor("test2")
}

/*
function = provideCar
moduleName = TestModule
returntype = Car
parameters Name and Type= motor: Motor

* class TestModule_ProvideCarFactory(val testModule: TestModule, val motorProvider:Provider<Motor>) : Factory<Car> {


    override fun get(): Car {
        return provideCar(testModule,motorProvider.get())

    }

    companion object{

        fun create(testModule: TestModule,motorProvider: Provider<Motor>): TestModule_ProvideCarFactory {
            return TestModule_ProvideCarFactory(testModule,motorProvider)
        }

        fun provideCar(instance: TestModule,motor: Motor): Car {
            return checkNotNull(instance.provideCar(motor), "Cannot return null from a non-@Nullable @Provides method");
        }


    }

}
*
* */