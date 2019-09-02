This is a (POC) demo project.
It shows how to use MpApt with Kotlin Poet.

In jsMain is a Api interface
```kotlin
interface Api {
    @GET("users/{value}")
    suspend fun getName(value: String): String

    @GET("users/Foso/image")
    suspend fun loadImage(): String

    @GET("users/Foso/images")
    suspend fun loadPictures(): Int
}

```

If you run build, the compiler plugin will generate a Ktor Client inside KtorfitApi class:

```kotlin
class KtorfitApi(
  val baseUrl: String
) : Api {
  val client: HttpClient = HttpClient()

  override suspend fun getName(value: String): kotlin.String = client.get(baseUrl+"users/{value}")

  override suspend fun loadImage(): kotlin.String = client.get(baseUrl+"users/Foso/image")

  override suspend fun loadPictures(): kotlin.Int = client.get(baseUrl+"users/Foso/images")

  fun create(): Api = this
}


```