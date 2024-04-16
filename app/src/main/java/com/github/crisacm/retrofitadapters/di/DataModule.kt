package com.github.crisacm.retrofitadapters.di

import com.github.crisacm.retrofitadapters.data.repo.MainRepo
import com.github.crisacm.retrofitadapters.data.repo.MainRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindMainRepo(mainRepoImpl: MainRepoImpl): MainRepo
}