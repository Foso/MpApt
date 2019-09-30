package de.jensklingenberg.ktorfit.di

import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.MPreconditions.Companion.checkNotNull

class SecondModule_ProvideMotorFactory(
  private val instance: SecondModule
) : Factory<Motor> {
  override fun get() = provideMotor( instance)

  companion object {
    fun provideMotor(instance: SecondModule): Motor {
      val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
      return checkNotNull(instance.provideMotor(), errorMessage  )
    }

    fun create(instance: SecondModule) = SecondModule_ProvideMotorFactory( instance)
  }
}
