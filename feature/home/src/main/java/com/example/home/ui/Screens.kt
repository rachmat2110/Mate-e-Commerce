package com.example.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreens() {
    ScreentContent(title = "Home")
}

@Composable
fun ProductScreens() {
    ScreentContent(title = "Product")
}

@Composable
fun OrderScreens() {
    ScreentContent(title = "Order")
}

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
    HomeScreens()
}

@Preview
@Composable
fun ProductScreensPreview() {
    ProductScreens()
}

