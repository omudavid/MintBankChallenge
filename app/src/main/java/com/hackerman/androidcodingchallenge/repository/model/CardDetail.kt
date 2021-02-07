package com.hackerman.androidcodingchallenge.repository.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CardDetail (
    @SerializedName("bank")
    val bank: Bank,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("country")
    val country: Country,
    @SerializedName("number")
    val number: Number,
    @SerializedName("scheme")
    val scheme: String,
    @SerializedName("type")
    val type: String
) :Serializable