package com.hackerman.androidcodingchallenge.di

import android.icu.util.TimeUnit
import com.hackerman.androidcodingchallenge.api_service.API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "https://lookup.binlist.net"

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLogger () : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    }

    @Provides
    @Singleton
    fun provideConverterFactory () : Converter.Factory {
        return GsonConverterFactory.create()
    }


    @Provides
    @Singleton
    fun provideClient (logger : HttpLoggingInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logger)
                .callTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
                .connectTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
                .writeTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideService (client: OkHttpClient, converterFactory : Converter.Factory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoginApiService (retrofit: Retrofit) : API{
        return retrofit.create(API::class.java)
    }
}