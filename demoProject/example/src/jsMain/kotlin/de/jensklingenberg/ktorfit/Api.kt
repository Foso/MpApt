package de.jensklingenberg.ktorfit

import de.jensklingenberg.ktofitAnnotations.GET

interface Api {
    @GET("users/{value}")
    suspend fun getName(value: String): String

    @GET("users/Foso/image")
    suspend fun loadImage(): String

    @GET("users/Foso/images")
    suspend fun loadPictures(): Int
}