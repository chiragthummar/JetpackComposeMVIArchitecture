package com.md.jetpackcomposemviarchitecture.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ImageListDto(
    @SerializedName("images")
    val images : ArrayList<ImageDto>
)
