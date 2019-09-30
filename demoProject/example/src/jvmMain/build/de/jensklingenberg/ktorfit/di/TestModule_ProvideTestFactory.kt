package de.jensklingenberg.ktorfit.di

import de.jensklingenberg.knife.internal.Factory
import de.jensklingenberg.knife.internal.MPreconditions.Companion.checkNotNull

class TestModule_ProvideTestFactory(
  private val instance: TestModule
) : Factory<Test> {
  override fun get() = provideTest( instance)

  companion object {
    fun provideTest(instance: TestModule): Test {
      val errorMessage = "Cannot return null from a non-@Nullable @Provides method"
      return checkNotNull(instance.provideTest(), errorMessage  )
    }

    fun create(instance: TestModule) = TestModule_ProvideTestFactory( instance)
  }
}
