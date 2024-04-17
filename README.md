# easy-retrofit-adapters

Android library to simplify Retrofit calls and manage response states like Success, Failed and Error.
## Installation

Add below codes to your root build.gradle file (not your module build.gradle file).
```kt
  allprojects {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

Then add the dependency to the `builde.gralde` of your module
```kt
  dependencies {
    implementation "com.github.crisacm:easyretrofit:1.0.0"
  }
```
## How to use

1. Whe need to return ApiResult into service class
```kotlin
  interface Service {

    @GET("users/{user}/repos")
    suspend fun getRepos(
      @Path("user") user: String
    ): ApiResult<List<Repos>>

  }
```

2. In the Retrofit instance the adapter ApiResultAdapterFactory must be added
```kotlin
  Retrofit.Builder()
      .baseUrl("https://api.github.com/")
      .addCallAdapterFactory(ApiResultAdapterFactory())
      .build()
```

3. Then to make a call we have to, by calling the instance of Service together with the function of the call.
```kotlin
  val repos: ApiResult<T> = service.getRepos("*")
    .onSuccess { data: T ->
        // ...
    }
    .onFailed { message: String ->
        // ...
    }
    .onError { t: Throwable ->
        // ...
    }
```

The use of suspended functions can also work with the `onSuspendSuccess`, `onSuspendFailed` and `onSuspendError` functions.# easy-retrofit-adapters