package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.common.Mock
import com.atahan.compose_recipe.view.composables.MealCard

@Composable
fun FavoritesScreen() {
    val favMeals = Mock.fetchMockMeals().filter { it.isFavorite }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            favMeals.forEach { favMeal ->
                var isFavorite by remember {
                    mutableStateOf(favMeal.isFavorite)
                }

                MealCard(
                    meal = favMeal,
                    isFavorite = isFavorite,
                    onClickFavorite = {
                        isFavorite = it
                    }
                )
                
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}