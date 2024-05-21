package com.edurda77.dm01.data.remote


import com.google.gson.annotations.SerializedName

data class PluginDto(
    @SerializedName("image_plugin")
    val imagePlugin: String,
    @SerializedName("title_plugin")
    val titlePlugin: String,
    @SerializedName("url_plugin")
    val urlPlugin: String
)