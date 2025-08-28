package com.example.mixit.signIn

import Resources.Icon.background
import Resources.Icon.cocktail1
import Resources.Icon.cocktail2
import Resources.String.iconArrowLeft
import Resources.String.register
import Resources.String.signIn
import Resources.String.userConfirmPasswordHint
import Resources.String.userEmailHint
import Resources.String.userNameHint
import Resources.String.userPasswordHint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.NavigateButton
import components.UserTextField
@Composable
fun HalfImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    side: String = "left" // "left" או "right"
) {
    val shape = remember(side) {
        object : Shape {
            override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
                return if (side == "left") {
                    Outline.Rectangle(Rect(0f, 0f, size.width / 2, size.height)) // חצי שמאלי
                } else {
                    Outline.Rectangle(Rect(size.width / 2, 0f, size.width, size.height)) // חצי ימני
                }
            }
        }
    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.clip(shape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun SignIn() {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

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
                    contentDescription = "cocktail1"
                )
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(cocktail2),
                    contentDescription = "cocktail2"
                )
            }

            Spacer(modifier = Modifier.height(80.dp))

            IconButton(
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.White
                ),
                modifier = Modifier.align(Alignment.Start),
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = stringResource(iconArrowLeft),
                    modifier = Modifier.size(150.dp)
                )
            }


                Text(text = stringResource(signIn).uppercase(),
                    color = Color.White, fontWeight = FontWeight.Bold, fontSize = 28.sp,
                    modifier = Modifier
                        .clickable {
                        })


            Spacer(modifier = Modifier.height(70.dp))


            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                UserTextField(
                    value = name, onValueChange = { name = it }, label = stringResource(
                        userNameHint),
                    leadingIcon = Icons.Default.Person
                )

                UserTextField(
                    value = email, onValueChange = { email = it }, label = stringResource(
                        userEmailHint),
                    leadingIcon = Icons.Default.Email
                )

                UserTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = stringResource(userPasswordHint),
                    leadingIcon = Icons.Default.Lock
                )

                UserTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = stringResource(userConfirmPasswordHint),
                    leadingIcon = Icons.Default.Lock
                )

                Spacer(modifier = Modifier.height(40.dp))

                NavigateButton(
                    text = stringResource(register), onClick = {})
            }
        }
    }
}