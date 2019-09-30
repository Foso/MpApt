package de.jensklingenberg.ktorfit.di


import de.jensklingenberg.knife.annotations.Module
import de.jensklingenberg.knife.annotations.Provides

@Module
class ThirdModule() {





    @Provides
    fun provideThirdMotor()=Motor("test")

    @Provides
    fun provProvider() = "Hallo"

    @Provides
    fun provCiao() = "Hallo"
}

