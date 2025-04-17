package com.example.home.ui.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.example.ui.component.MateImageViewClick
import com.example.ui.component.MateImageViewPhotoUrlRounded
import com.example.ui.component.MateTextRegular
import com.example.ui.component.RatingBar
import com.example.ui.theme.Gray
import com.example.ui.theme.Grey
import com.example.ui.theme.LightGrayishBlue
import com.example.ui.theme.VeryLightGrey
import com.example.ui.theme.VividRed

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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MateTextRegular(
                text = "NEW PRODUCT",
                modifier = Modifier.weight(1f)
            )
            MateImageViewClick(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                color = LightGrayishBlue
            )
            MateImageViewClick(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_katalog),
                color = LightGrayishBlue
            )
        }

        ItemProduct()
    }
}

@Composable
fun ItemProduct(){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .padding(horizontal = 16.dp)
            .background(Color.White)
    ) {
        items(10){item ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(bottom = 16.dp)
                        .clickable {

                        },
                    colors = CardDefaults.cardColors(
                        containerColor = LightGrayishBlue
                    )
                ) {
                    MateImageViewPhotoUrlRounded(
                        url = "https://picsum.photos/200",
                        descrption = "Rating"
                    )
                }

                Spacer(modifier = Modifier.padding(start = 8.dp))

                Column {
                    MateTextRegular(
                        text = "Product Name",
                        modifier = Modifier
                    )
                    MateTextRegular(
                        text = "Rp 1.000.000",
                        modifier = Modifier.padding(top = 7.dp),
                        color = VividRed
                    )
                    RatingBar(
                        rating = 2f,
                        modifier = Modifier.padding(top = 18.dp),
                        onRatingChanged = {

                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreensPreview() {
    ProductScreens()
}