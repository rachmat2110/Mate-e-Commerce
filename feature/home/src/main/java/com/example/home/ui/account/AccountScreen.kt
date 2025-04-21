package com.example.home.ui.account

import android.media.Image
import android.view.Menu
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.example.home.ui.ScreentContent
import com.example.ui.component.MateImageViewClick
import com.example.ui.component.MateImageViewPhotoUrlRounded
import com.example.ui.component.MateTextRegular
import com.example.ui.theme.StrongBlue

@Composable
fun AccountScreens() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StrongBlue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MateImageViewClick(
                color = Color.White,
                onClick = {

                }
            )

            MateTextRegular(
                text = "Profile",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                color = Color.White
            )

            MateImageViewClick(
                color = Color.White,
                onClick = {

                },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_logout)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        MateImageViewPhotoUrlRounded(
            url = "https://picsum.photos/200",
            descrption = "Photo Profile"
        )
        Spacer(modifier = Modifier.height(15.dp))
        MateTextRegular(
            text = "Name Account",
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(64.dp))
        Spacer(modifier = Modifier.weight(1f))

        LazyColumn(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.White)
        ) {
            items(returnDataProfile()){ item ->
                ItemMenuAccount(
                    iconLeft = item.iconLeft,
                    iconRight = item.iconRigt,
                    label = item.label
                )
            }
        }
    }
}
fun returnDataProfile() : List<MenuItem>{
    return listOf(
        MenuItem(
            iconLeft = Icons.Default.Person,
            iconRigt = Icons.Default.KeyboardArrowRight,
            label = "Edit Profile"
        ),
        MenuItem(
            iconLeft = Icons.Default.Place,
            iconRigt = Icons.Default.KeyboardArrowRight,
            label = "Shipping Address"
        ),
        MenuItem(
            iconLeft = Icons.Default.Favorite,
            iconRigt = Icons.Default.KeyboardArrowRight,
            label = "Whislist"
        ),
        MenuItem(
            iconLeft = Icons.Default.ShoppingCart,
            iconRigt = Icons.Default.KeyboardArrowRight,
            label = "Order History"
        ),
        MenuItem(
            iconLeft = Icons.Default.Notifications,
            iconRigt = Icons.Default.KeyboardArrowRight,
            label = "Notification"
        ),
        MenuItem(
            iconLeft = Icons.Default.ShoppingCart,
            iconRigt = Icons.Default.KeyboardArrowRight,
            label = "Cards"
        )
    )
}

data class MenuItem(
    val iconLeft: ImageVector,
    val iconRigt: ImageVector,
    val label: String
)

@Composable
fun ItemMenuAccount(
    modifier: Modifier = Modifier,
    label: String = "Edit Profile",
    iconLeft: ImageVector = Icons.Default.Person,
    iconRight: ImageVector = Icons.Default.KeyboardArrowRight,
    colorLeft: Color = Color.Black,
    colorRight: Color = Color.Black
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            MateImageViewClick(
                color = colorLeft,
                imageVector = iconLeft,
                imageDescription = "Icon Left"
            )
            MateTextRegular(
                text = label,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            )
            MateImageViewClick(
                color = colorRight,
                imageVector = iconRight,
                imageDescription = "Icon Right"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AccountScreensPreview() {
    AccountScreens()
}