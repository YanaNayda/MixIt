package com.example.mixit.navigation.data
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItemDrawers(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)
