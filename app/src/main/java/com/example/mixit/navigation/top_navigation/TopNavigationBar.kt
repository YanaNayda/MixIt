package com.example.mixit.navigation.top_navigation
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.compose.primaryContainerLightHighContrast
import com.example.compose.primaryTopBar
import com.example.mixit.navigation.Screen



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    navController : NavHostController,
    onProfileClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "MixIt",
                modifier = Modifier.padding(start = 10.dp),
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = primaryTopBar
        ),
        navigationIcon = {
            IconButton(onClick =  { /* TODO: Open Drawer */ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        },

        actions = {
            IconButton(onClick = onProfileClick) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = Color.White
                )
            }
        }
    )
}

