package com.hackerman.androidcodingchallenge.repository.model


import com.google.gson.annotations.SerializedName

data class Number(
        val length:Int?,
        val luhn:Boolean?
)