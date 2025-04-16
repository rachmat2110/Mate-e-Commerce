package com.example.home.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.example.ui.component.BannerSliderUiMate
import com.example.ui.component.MateImageViewClick
import com.example.ui.component.MateTextRegular
import com.example.ui.theme.StrongBlue
import com.example.ui.theme.VeryLightGrey

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StrongBlue)
    ) {
        // View untuk bar atas sepanjang search bar (sama seperti linear layout horizontal)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            // View untuk card search bar
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable {

                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.2f)
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    MateImageViewClick(
                        color = Color.White,
                        imageVector = Icons.Outlined.Search,
                        onClick = {

                        }
                    )
                    MateTextRegular(
                        text = "Cari barang kamu disini",
                        color = Color.White
                    )
                }
            }
            // View end untuk card search bar

            MateImageViewClick(
                color = Color.White,
                imageVector = Icons.Outlined.ShoppingCart,
                onClick = {

                }
            )
        }
        // View end untuk bar atas sepanjang search bar (sama seperti linear layout horizontal)

        // View untuk banner slides
        val image = listOf(
            painterResource(id = com.example.ui.R.drawable.sample_slide1),
            painterResource(id = com.example.ui.R.drawable.sample_slide1),
            painterResource(id = com.example.ui.R.drawable.sample_slide1),
        )
        BannerSliderUiMate(
            bannerImage = image,
            onClick = {

            }
        )
        // End view untuk banner slides
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}