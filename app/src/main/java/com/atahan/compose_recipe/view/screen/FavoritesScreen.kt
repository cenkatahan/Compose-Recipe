package com.atahan.compose_recipe.view.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.atahan.compose_recipe.model.Screen

@Composable
fun FavoritesScreen() {
    Text(text = Screen.Favorites.route, fontSize = 32.sp)
}