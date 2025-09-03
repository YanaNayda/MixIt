package com.example.mixit.navigation.drawers_navigation

import Resources.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon


import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mixit.navigation.data.NavigationItem
import com.example.mixit.navigation.data.NavigationItemDrawers
import com.example.mixit.ui.theme.M3NavigationDrawerTheme
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonNull.content
import androidx.compose.ui.res.painterResource
import com.example.compose.primaryTopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    navController: NavHostController,
) {
    M3NavigationDrawerTheme {
        val leftDrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        var rightDrawerState by remember { mutableStateOf(DrawerValue.Closed) }
        val scope = rememberCoroutineScope()

        val itemsMenu = listOf(
            NavigationItemDrawers(
                title = "All",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
            ),
            NavigationItemDrawers(
                title = "Notifications",
                selectedIcon = Icons.Filled.Info,
                unselectedIcon = Icons.Outlined.Info,
                badgeCount = 45
            ),
            NavigationItemDrawers(
                title = "Settings",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
            ),

            null,

            NavigationItemDrawers(
                title = "About Us",
                selectedIcon = Icons.Filled.Info,
                unselectedIcon = Icons.Outlined.Info,
                badgeCount = 45
            ),
            NavigationItemDrawers(
                title = "Contact Us",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
            ),
            NavigationItemDrawers(
                title = "Log Out",
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
            )
        )
        val itemsProfile= listOf(
            NavigationItemDrawers(
                title = "All",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
            ),
            NavigationItemDrawers(
                title = "My Profile",
                selectedIcon = Icons.Filled.Person,
                unselectedIcon = Icons.Outlined.Person,
            ),
            NavigationItemDrawers(
                title = "My Cocktails",
                selectedIcon = Icons.Filled.ThumbUp,
                unselectedIcon = Icons.Outlined.ThumbUp,
            ),
            NavigationItemDrawers(
                title = "My Favourite",
                selectedIcon = Icons.Filled.FavoriteBorder,
                unselectedIcon = Icons.Outlined.FavoriteBorder,
            )
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = primaryTopBar
        ) {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            var selectedItemIndex by rememberSaveable {
                mutableStateOf(0)
            }
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet {
                        Spacer(modifier = Modifier.height(16.dp))
                        itemsMenu.forEachIndexed { index, item ->
                            if (item == null) {
                                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                            } else {
                                NavigationDrawerItem(
                                    label = { Text(text = item.title) },
                                    selected = index == selectedItemIndex,
                                    onClick = {
                                        selectedItemIndex = index
                                        scope.launch { drawerState.close() }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    },
                                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                )
                            }
                        }
                    }
                }
            ) {
                Box {
                    Scaffold(
                        topBar = {
                            TopAppBar(

                                title = {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        Icon(
                                            painter = painterResource(Resources.Icon.logo),
                                            contentDescription = "Logo",

                                            )
                                    }
                                },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
                                        }
                                    }) {
                                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                                    }
                                },
                                actions = {
                                    IconButton(onClick = {
                                        rightDrawerState =
                                            if (rightDrawerState == DrawerValue.Closed) DrawerValue.Open else DrawerValue.Closed
                                    }) {
                                        Icon(Icons.Default.Person, contentDescription = "Profile")
                                    }
                                }
                            )
                        }
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {

                        }
                    }


                    RightDrawer(
                        drawerState = rightDrawerState,
                        onClose = { rightDrawerState = DrawerValue.Closed }
                    ) {
                        DrawerContent(items = itemsProfile) { rightDrawerState = DrawerValue.Closed }
                    }
                }
            }

        }
    }
}
@Composable
fun DrawerContent(items: List<NavigationItemDrawers?>, onItemClick: () -> Unit) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        items.forEach { item ->
            if (item == null) {
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            } else {
                NavigationDrawerItem(
                    label = { Text(item.title) },
                    selected = false,
                    onClick = onItemClick,
                    icon = {
                        Icon(item.unselectedIcon, contentDescription = item.title)
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    }
}

@Composable
fun RightDrawer(
    drawerState: DrawerValue,
    onClose: () -> Unit,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = drawerState == DrawerValue.Open,
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { it })
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(250.dp)

                .background(MaterialTheme.colorScheme.surface)
        ) {
            Column {
                IconButton(onClick = onClose) {
                    Icon(Icons.Default.Close, contentDescription = "Close")
                }
                content()
            }
        }
    }
}