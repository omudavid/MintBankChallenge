package com.hackerman.androidcodingchallenge.repository.model


import com.google.gson.annotations.SerializedName

data class Bank(
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("url")
    val url: String
)