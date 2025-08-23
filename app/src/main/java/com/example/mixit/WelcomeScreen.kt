package com.example.mixit
import InfiniteAutoScrollRow
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WelcomeScreen() {
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
            text = "Welcome to MixIt !",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF),
                contentColor = Color.Black
            )
        ) {
            Text(
                text = "Start",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
    }
}
