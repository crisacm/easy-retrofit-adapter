package com.github.crisacm.retrofitadapters.di

import com.github.crisacm.module.easyretrofit.adapter.ApiResultAdapterFactory
import com.github.crisacm.module.easyretrofit.interceptor.getHttpLoginRequestInterceptor
import com.github.crisacm.retrofitadapters.api.service.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(getHttpLoginRequestInterceptor())
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://ok.surf/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(ApiResultAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsService(
        retrofit: Retrofit
    ): NewsService = retrofit.create(NewsService::class.java)
}