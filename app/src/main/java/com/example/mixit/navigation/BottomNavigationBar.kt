package com.example.mixit.navigation
import Resources.Icon.advice
import Resources.Icon.cocktails
import Resources.Icon.diy
import Resources.Icon.game
import Resources.Icon.home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.mixit.navigation.data.NavigationItem


val navigationItems = listOf(
    NavigationItem(
        title = "Game",
        icon =  game,
        route = Screen.Game.route
    ),
    NavigationItem(
        title = "DIY",
        icon = diy,
        route = Screen.DIY.route
    ),
    NavigationItem(
        title = "Home",
        icon = home,
        route = Screen.Home.route
    ),
    NavigationItem(
        title = "Cocktails",
        icon = cocktails,
        route = Screen.Cocktails.route
    ),
    NavigationItem(
        title = "Advice",
        icon = advice,
        route = Screen.Advice.route
    )
)

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val selectedNavigationIndex = rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(containerColor =   MaterialTheme.colorScheme.background,modifier = modifier) {

        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    selectedNavigationIndex.intValue = index
                    navController.navigate(item.route) {
                        popUpTo(Screen.Home.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon( painter = painterResource(id = item.icon), contentDescription = item.title)
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedNavigationIndex.intValue)
                            Color.Black else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Gray,
                    indicatorColor = Color.White
                )
            )
        }
    }
}