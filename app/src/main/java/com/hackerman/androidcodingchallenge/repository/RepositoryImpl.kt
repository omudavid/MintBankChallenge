package com.hackerman.androidcodingchallenge.repository

import android.util.Log
import com.hackerman.androidcodingchallenge.api_service.API
import com.hackerman.androidcodingchallenge.repository.model.CardDetail
import javax.inject.Inject

class RepositoryImpl@Inject constructor(
    private val api: API
) : Repository {


    override suspend fun  getCardDetails(cardNumber: String): CardDetail? {
        var response =  api.getGetCardDetails(cardNumber)
        return if(response.isSuccessful){
            Log.d("DEBUG123",response.code().toString())
            response.body()
        }else null
    }


}