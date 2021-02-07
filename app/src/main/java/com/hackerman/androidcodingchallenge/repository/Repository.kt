package com.hackerman.androidcodingchallenge.repository

import com.hackerman.androidcodingchallenge.repository.model.CardDetail

interface Repository {

   suspend fun  getCardDetails (cardNumber: String): CardDetail?



}