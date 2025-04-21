package com.example.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.home.ui.home.HomeScreen



@Composable
fun AccountScreens() {
    ScreentContent(title = "Account")
}

@Composable
fun ScreentContent(title: String) {
    Column {
        Text(text = title)
    }
}

@Preview
@Composable
fun HomeScreensPreview() {
    HomeScreen()
}



