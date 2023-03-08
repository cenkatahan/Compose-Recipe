package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.atahan.compose_recipe.model.Screen
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun BottomSection(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (Screen) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = AppBlue,
    ) {
        val screens = arrayListOf(
            Screen.Home,
            Screen.Favorites,
            Screen.MealMenu
        )

        screens.forEach { screen ->
            val selected = screen.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(screen) },
                icon = {
                    when (selected) {
                        true ->
                            Column(verticalArrangement = Arrangement.Center) {
                                Icon(
                                    painterResource(id = screen.selectedIcon),
                                    contentDescription = screen.route,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(
                                    text = screen.route,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        else ->
                            Column(verticalArrangement = Arrangement.Center) {
                                Icon(
                                    painterResource(id = screen.icon),
                                    contentDescription = screen.route,
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                )
                                Text(
                                    text = screen.route,
                                    fontWeight = FontWeight.Normal,
                                    textAlign = TextAlign.Center
                                )
                            }
                    }
                },
            )
        }
    }
}