package com.example.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ui.component.MateButtonPrimary
import com.example.ui.component.MateButtonSosmedRow
import com.example.ui.component.MateEditText
import com.example.ui.component.MateEditTextPreview
import com.example.ui.component.MateImageViewClick
import com.example.ui.component.MateTextHeader
import com.example.ui.component.MateTextRegular
import com.example.ui.component.MateTextRegularWithClick
import com.example.ui.component.MateTextViewRow
import com.example.ui.theme.VeryDarkGrayBlue

@Composable
fun MainScreen(

) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            bottomNavigationBar(navController)
        }
    ){ innerPadding ->
        NavigationGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Composable

fun bottomNavigationBar(navController: NavController){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Product,
        BottomNavItem.Order,
        BottomNavItem.Account
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = VeryDarkGrayBlue
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 12.sp,
                            textAlign = TextAlign.Center
                        ),
                        color = VeryDarkGrayBlue
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                alwaysShowLabel = true
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier){
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        modifier = modifier)
    {
        composable(BottomNavItem.Home.route){ HomeScreens()}
        composable(BottomNavItem.Product.route){ ProductScreens() }
        composable(BottomNavItem.Order.route){ OrderScreens() }
        composable(BottomNavItem.Account.route){ AccountScreens() }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun MainScreenPreview(
) {
    MainScreen()
}