package com.github.crisacm.module.easyretrofit.interceptor

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

fun getHttpLoginRequestInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor { message: String? -> Timber.v(message) }.apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}
