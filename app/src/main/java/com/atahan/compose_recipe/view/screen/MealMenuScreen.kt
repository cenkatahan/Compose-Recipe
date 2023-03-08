package com.atahan.compose_recipe.view.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.atahan.compose_recipe.model.Screen

@Composable
fun MealMenuScreen() {
    Text(text = Screen.MealMenu.route, fontSize = 32.sp)
}