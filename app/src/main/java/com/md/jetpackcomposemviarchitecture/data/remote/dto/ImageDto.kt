package com.md.jetpackcomposemviarchitecture.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("id") var id: String,
    @SerializedName("gallery") var gallery: String,
    @SerializedName("src") var src: String,
    @SerializedName("srcSmall") var srcSmall: String,
    @SerializedName("prompt") var prompt: String,
    @SerializedName("width") var width: Int,
    @SerializedName("height") var height: Int,
    @SerializedName("seed") var seed: String,
    @SerializedName("grid") var grid: Boolean,
    @SerializedName("model") var model: String,
    @SerializedName("guidance") var guidance: Int,
    @SerializedName("promptid") var promptid: String,
    @SerializedName("nsfw") var nsfw: Boolean
)
