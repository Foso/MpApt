package de.jensklingenberg.ktorfit.di

data class Car(val name:String,val motor: Motor){
    fun start(){
        println("Car started")
    }
}

data class Motor(val name : String)