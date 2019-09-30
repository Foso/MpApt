package de.jensklingenberg.ktorfit

import de.jensklingenberg.knife.internal.MembersInjector
import de.jensklingenberg.knife.internal.Provider
import de.jensklingenberg.ktorfit.di.Car
import de.jensklingenberg.ktorfit.di.Test

class MyPresenter_MembersInjector(
  val testProvider: Provider<Test>,
  val carProvider: Provider<Car>
) : MembersInjector<MyPresenter> {
  override fun injectMembers(instance: MyPresenter) {
    injectTest(instance,testProvider.get())
    injectCar(instance,carProvider.get())
  }

  companion object {
    fun injectTest(instance: MyPresenter, test: Test) {
      instance.test=test
    }

    fun injectCar(instance: MyPresenter, car: Car) {
      instance.car=car
    }
  }
}
