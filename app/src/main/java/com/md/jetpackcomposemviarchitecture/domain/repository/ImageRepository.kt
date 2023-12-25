package com.md.jetpackcomposemviarchitecture.domain.repository

import com.md.jetpackcomposemviarchitecture.core.util.Resources
import com.md.jetpackcomposemviarchitecture.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImages(
        text: String
    ): Flow<Resources<List<Image>>>
}