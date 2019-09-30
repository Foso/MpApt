package de.jensklingenberg.ktorfit.di

import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.MPreconditions.Companion.checkNotNull

class TestModule_ProvideMotorFactory(
  private val instance: TestModule
) : Factory<Motor> {
  override fun get() = provideMotor( instance)

  companion object {
    fun provideMotor(instance: TestModule): Motor {
      val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
      return checkNotNull(instance.provideMotor(), errorMessage  )
    }

    fun create(instance: TestModule) = TestModule_ProvideMotorFactory( instance)
  }
}
