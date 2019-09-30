package de.jensklingenberg.ktorfit.di

import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.MPreconditions.Companion.checkNotNull
import kotlin.String

class SecondModule_ProvCiaoFactory(
  private val instance: SecondModule
) : Factory<String> {
  override fun get() = provCiao( instance)

  companion object {
    fun provCiao(instance: SecondModule): String {
      val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
      return checkNotNull(instance.provCiao(), errorMessage  )
    }

    fun create(instance: SecondModule) = SecondModule_ProvCiaoFactory( instance)
  }
}
