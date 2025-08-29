package com.example.mixit.welcome
import InfiniteAutoScrollRow
import Resources.String.logIn
import Resources.String.start
import Resources.String.welcome
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mixit.navigation.Screen
import components.NavigateButton


@Composable
fun WelcomeScreen(navController: NavController) {

    val images = listOf(
        Resources.Icon.logo,
        Resources.Icon.cocktail1,
        Resources.Icon.cocktail2,
        Resources.Icon.cocktail3,
        Resources.Icon.cocktail4,
    )
    val images2 = listOf(
        Resources.Icon.cocktail2,
        Resources.Icon.cocktail1,
        Resources.Icon.cocktail4,
        Resources.Icon.cocktail3,
        Resources.Icon.logo,
    )
    val images3 = listOf(
        Resources.Icon.cocktail4,
        Resources.Icon.logo,
        Resources.Icon.cocktail1,
        Resources.Icon.cocktail3,
        Resources.Icon.logo,
        Resources.Icon.cocktail2,
    )
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = Resources.Icon.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

    ) {
        InfiniteAutoScrollRow(
            items = images,
            side = true,
            speed = 10f,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        InfiniteAutoScrollRow(
            items = images2,
            side = false,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        InfiniteAutoScrollRow(
            items = images3,
            side = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Text(
            text = stringResource(welcome),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))
        NavigateButton(
            text = stringResource(start), onClick = {
                navController.navigate(Screen.LogIn.route)

            })
    }
    }
}
