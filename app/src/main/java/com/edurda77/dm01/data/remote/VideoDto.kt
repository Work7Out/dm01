package com.edurda77.dm01.data.remote


import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("url")
    val url: String
)