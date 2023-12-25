package com.md.jetpackcomposemviarchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.md.jetpackcomposemviarchitecture.presentation.screens.HomeScreen
import com.md.jetpackcomposemviarchitecture.presentation.screens.HomeScreenViewModel
import com.md.jetpackcomposemviarchitecture.presentation.theme.JetpackComposeMVIArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMVIArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
                    HomeScreen(state = homeScreenViewModel.state) {
                        homeScreenViewModel.onEvent(it)
                    }
                }
            }
        }
    }
}
