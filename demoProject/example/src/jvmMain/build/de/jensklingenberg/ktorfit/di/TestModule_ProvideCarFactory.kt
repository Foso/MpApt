package de.jensklingenberg.ktorfit.di

import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.MPreconditions.Companion.checkNotNull
import de.jensklingenberg.knife.internal.Provider

class TestModule_ProvideCarFactory(
  private val instance: TestModule,
  val motorProvider: Provider<Motor>
) : Factory<Car> {
  override fun get() = provideCar( instance,motorProvider.get())

  companion object {
    fun provideCar(instance: TestModule, motor: Motor): Car {
      val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
      return checkNotNull(instance.provideCar(motor), errorMessage  )
    }

    fun create(instance: TestModule, motorProvider: Provider<Motor>) = TestModule_ProvideCarFactory(
        instance,motorProvider)
  }
}
