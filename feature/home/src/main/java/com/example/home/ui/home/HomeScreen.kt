package com.example.home.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.example.ui.component.BannerSliderUiMate
import com.example.ui.component.MateImageViewClick
import com.example.ui.component.MateImageViewPhotoUrlRounded
import com.example.ui.component.MateTextRegular
import com.example.ui.theme.LightGrayishBlue
import com.example.ui.theme.StrongBlue
import com.example.ui.theme.VeryLightGrey
import com.example.ui.theme.VividMagenta

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

        Spacer(modifier = Modifier.weight(1f))

        //View untuk Bagian bawah (categories dan new Product)
        val tmp = listOf(
            ProductItem(
                title = "CATEGORIES",
                subItems = listOf(
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200"
                )
            ),
            ProductItem(
                title = "NEW PRODUCT",
                subItems = listOf(
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200",
                    "https://picsum.photos/200"
                )
            )
        )

        ItemProductHomeList(items = tmp)
        //End view untuk Bagian bawah (categories dan new Product)
    }
}


@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

data class ProductItem(
    val title: String = "",
    val subItems: List<String> = emptyList(),
)

@Composable
fun ItemProductHomeList(items: List<ProductItem>){
    LazyColumn(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(color = Color.White)
    ) {
        items(items){item ->

            //View untuk Categories, New product dan text See All
            Row(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                MateTextRegular(
                    text = item.title,
                    color = Color.Black,
                    modifier = Modifier.padding(16.dp)
                )

                val annotatedString = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = VividMagenta
                        )
                    ){
                        append("SEE ALL")
                    }
                }

                ClickableText(
                    text = annotatedString,
                    onClick = {

                    }
                )

            }
            //End view untuk Categories, New product dan text See All

            //View untuk gambar horizontal scrollview listnya
            if (item.subItems.isNotEmpty()){
                SubItemList(subItems = item.subItems)
            }
            //End view untuk gambar horizontal scrollview listnya
        }
    }
}

@Composable
fun SubItemList(subItems: List<String>){
    LazyRow(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        items(subItems){item->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 16.dp)
                    .clickable {

                    },
                colors = CardDefaults.cardColors(
                    containerColor = LightGrayishBlue
                )
            ) {
                MateImageViewPhotoUrlRounded(
                    url = item,
                    descrption = "image ke $item"
                )
            }
        }
    }
}

@Preview
@Composable
fun SubItemListPreview(){
    val temp = listOf(
        "https://picsum.photos/200",
        "https://picsum.photos/200"
    )
    SubItemList(subItems = temp)
}