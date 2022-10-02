package com.puyo.kapas.feature_kapas.presentation.util.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.puyo.kapas.ui.theme.Grey
import com.puyo.kapas.ui.theme.Orange

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Job,
        NavigationItem.History,
        NavigationItem.Leaderboard,
        NavigationItem.Profile
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Grey
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    if (currentRoute == item.route)
                        Icon(
                            painter = painterResource(id = item.iconSelected),
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp)
                        )
                    else
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp)
                        )
                },
                label = { Text(text = item.title, fontSize = 11.sp)},
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                    }
                },
                selected = currentRoute == item.route,
                selectedContentColor = Orange,
                unselectedContentColor = Grey,
                modifier = Modifier.height(88.dp)
            )
        }
    }
}