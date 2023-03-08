package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.atahan.compose_recipe.model.Screens

@Composable
fun BottomSection(modifier: Modifier = Modifier) {

    BottomNavigation {
        val screens = arrayListOf(
            Screens.Home,
            Screens.Favorites,
            Screens.MealMenu
        )

        screens.forEach { bottomNavItem ->
            Row {

            }
        }
    }
}