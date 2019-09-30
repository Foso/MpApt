package de.jensklingenberg.ktorfit.di

import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.MPreconditions.Companion.checkNotNull
import kotlin.String

class TestModule_ProvideDatabaseNameFactory(
  private val instance: TestModule
) : Factory<String> {
  override fun get() = provideDatabaseName( instance)

  companion object {
    fun provideDatabaseName(instance: TestModule): String {
      val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
      return checkNotNull(instance.provideDatabaseName(), errorMessage  )
    }

    fun create(instance: TestModule) = TestModule_ProvideDatabaseNameFactory( instance)
  }
}
