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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.atahan.compose_recipe.model.Screen
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun BottomSection(navController: NavHostController, modifier: Modifier = Modifier) {
    val backStackEntry = navController.currentBackStackEntryAsState().value
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
            val selected = screen.route == backStackEntry?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { /*TODO*/ },
                icon = {
                    ChooseIconBy(selected, screen)
                },

                )
        }
    }
}

@Composable
private fun ChooseIconBy(isSelected: Boolean, screen: Screen) {
    when (isSelected) {
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
}