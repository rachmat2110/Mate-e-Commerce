package com.example.home.ui.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.ui.ScreentContent
import com.example.ui.component.MateImageViewClick
import com.example.ui.component.MateTextRegular
import com.example.ui.theme.Gray
import com.example.ui.theme.Grey
import com.example.ui.theme.VeryLightGrey

@Composable
fun ProductScreens() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        //View untuk Search Bar Sama seperti linear layout horizontal orientation
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable {

                    },
                colors = CardDefaults.cardColors(
                    Grey.copy(alpha = 0.1f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    MateTextRegular(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)
                            .weight(1f),
                        text = "Cari barang kamu disini",
                        color = Gray
                    )
                    MateImageViewClick(
                        color = Gray,
                        onClick = {

                        },
                        imageVector = Icons.Outlined.Search
                    )
                }
            }
        }
        //End view untuk Search Bar Sama seperti linear layout horizontal orientation

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = VeryLightGrey
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreensPreview() {
    ProductScreens()
}