package com.edurda77.dm01.data.remote


import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("content")
    val content: String,
    @SerializedName("image_news")
    val imageNews: String,
    @SerializedName("title_news")
    val titleNews: String
)