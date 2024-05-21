package com.edurda77.dm01.data.remote


import com.google.gson.annotations.SerializedName

data class LogoDto(
    @SerializedName("date")
    val date: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)