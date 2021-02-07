package com.hackerman.androidcodingchallenge.di

import com.hackerman.androidcodingchallenge.repository.Repository
import com.hackerman.androidcodingchallenge.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
abstract class RepositoryInjectionModule {

    @Binds
    abstract fun bindToInterface(repositoryImpl: RepositoryImpl): Repository
}