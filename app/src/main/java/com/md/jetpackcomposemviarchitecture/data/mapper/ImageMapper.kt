package com.md.jetpackcomposemviarchitecture.data.mapper

import com.md.jetpackcomposemviarchitecture.data.remote.dto.ImageDto
import com.md.jetpackcomposemviarchitecture.domain.model.Image

fun ImageDto.toImage(): Image {
    return Image(
        id = id,
        width = width,
        height = height,
        srcSmall = srcSmall,
        src = src
    )
}

