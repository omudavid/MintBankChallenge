package com.hackerman.androidcodingchallenge.utils

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardNumberValidator @Inject constructor() {

    fun isValidCardNumber( number:String):Boolean{
        return number.length>=4 && number.toIntOrNull()!=null
    }

}