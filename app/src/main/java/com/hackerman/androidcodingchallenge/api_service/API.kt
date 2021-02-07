package com.hackerman.androidcodingchallenge.api_service

import com.hackerman.androidcodingchallenge.repository.model.CardDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("/{cardNumber}")
    suspend fun getGetCardDetails(@Path("cardNumber") key: String):Response<CardDetail>
}