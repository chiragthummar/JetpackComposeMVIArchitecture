package com.md.jetpackcomposemviarchitecture.data.remote

import com.md.jetpackcomposemviarchitecture.data.remote.dto.ImageListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("search")
    suspend fun getInfiniteApiImages(
        @Query("q") q : String
    ): ImageListDto
}