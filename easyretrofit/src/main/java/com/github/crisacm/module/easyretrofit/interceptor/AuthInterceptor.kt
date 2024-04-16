package com.github.crisacm.module.easyretrofit.interceptor

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(user: String, pass: String) : Interceptor {
    private var credentials: String = Credentials.basic(user, pass)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authRequest = request.newBuilder()
            .addHeader("Authorization", credentials)
            .build()

        return chain.proceed(authRequest)
    }
}
