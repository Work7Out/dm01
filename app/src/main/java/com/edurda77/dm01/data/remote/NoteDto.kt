package com.edurda77.dm01.data.remote


import com.google.gson.annotations.SerializedName

data class NoteDto(
    @SerializedName("content")
    val content: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
)