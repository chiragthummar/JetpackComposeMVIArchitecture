package com.md.jetpackcomposemviarchitecture.presentation.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.md.jetpackcomposemviarchitecture.domain.model.Image

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(state: HomeScreenState, onEvent: (HomeScreenEvents) -> Unit) {

    val keyboardManager = LocalSoftwareKeyboardController.current

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "MVI App", color = MaterialTheme.colorScheme.onPrimary)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) { pv ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pv),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                placeholder = {
                    Text(text = "Enter image prompt")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = state.text, onValueChange = {
                    onEvent(HomeScreenEvents.UpdateText(it))
                },
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardManager?.hide()
                        onEvent(HomeScreenEvents.LoadImages(state.text))
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                trailingIcon = {
                    if(state.text.isNotEmpty()){
                        IconButton(onClick = {
                            onEvent(HomeScreenEvents.UpdateText(""))
                        }) {
                            Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear")
                        }
                    }
                }
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator()
                } else if (state.images.isEmpty()) {
                    Text(text = "No images found")
                } else {
                    MyListView(images = state.images)
                }

            }
        }
    }
}

@Composable
fun MyListView(
    images: List<Image>
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(4.dp),
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ) {
        items(images, key = {
            it.id
        }) { img ->
            ImageItem(img.srcSmall)
        }
    }
}

@Composable
fun ImageItem(url: String) {
    Box(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = MaterialTheme.colorScheme.onPrimaryContainer),
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = url),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        )
    }
}