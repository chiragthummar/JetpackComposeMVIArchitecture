package com.md.jetpackcomposemviarchitecture.presentation.screens

import com.md.jetpackcomposemviarchitecture.domain.model.Image

data class HomeScreenState(
    val images: List<Image> = emptyList(),
    val isLoading: Boolean = false,
    val text : String = ""
)