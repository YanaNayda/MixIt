package com.example.mixit.login

import Resources.Icon.background
import Resources.Icon.cocktail1
import Resources.Icon.cocktail2
import Resources.String.buttonFacebook
import Resources.String.buttonGoogle
import Resources.String.createAnAccount
import Resources.String.forgotPassword
import Resources.String.logIn
import Resources.String.orLogInWith
import Resources.String.userEmailHint
import Resources.String.userNameHint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.mixit.R
import com.example.mixit.navigation.Screen
import components.NavigateButton
import components.UserTextField


@Composable
fun LogIn(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.Top,
            Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(cocktail1),
                    contentDescription = ""
                )
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(cocktail2),
                    contentDescription = ""
                )
            }

            Text(text = stringResource(logIn).uppercase(),
                color = Color.White, fontWeight = FontWeight.Bold, fontSize = 28.sp,
                modifier = Modifier.clickable {
                })

            Spacer(modifier = Modifier.height(70.dp))


            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                UserTextField(
                    value = email, onValueChange = { email = it }, label = stringResource(
                        userNameHint
                    ),
                    leadingIcon = Icons.Default.Email
                )

                UserTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = stringResource(
                        userEmailHint
                    ),
                    leadingIcon = Icons.Default.Lock
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = stringResource(forgotPassword), textDecoration = TextDecoration.Underline,
                    color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 50.dp)
                        .clickable {
                        })

                Spacer(modifier = Modifier.height(25.dp))

                NavigateButton(
                    text = stringResource(logIn), onClick = {
                        navController.navigate(Screen.Home.route)

                    })

                Spacer(modifier = Modifier.height(60.dp))

                Text(text = stringResource(orLogInWith), textDecoration = TextDecoration.Underline,
                    color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp,
                    modifier = Modifier.clickable {
                    })

                NavigateButton(
                    text = stringResource(buttonFacebook), onClick = {})

                NavigateButton(
                    text = stringResource(buttonGoogle), onClick = {})

                Text(text = stringResource(createAnAccount), textDecoration = TextDecoration.Underline,
                    color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp,
                    modifier = Modifier.clickable {
                    })
            }
        }
    }
}