package de.jensklingenberg.ktorfit.di


import de.jensklingenberg.knife.annotations.Module
import de.jensklingenberg.knife.annotations.Provides

@Module
class SecondModule() {


    @Provides
    fun provideMotor()=Motor("test")

    @Provides
    fun provProvider() = "Hallo"

    @Provides
    fun provCiao() = "Hallo"
}

