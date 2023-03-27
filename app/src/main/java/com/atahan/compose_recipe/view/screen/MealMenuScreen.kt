package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun MealMenuScreen() {
    val mealsOnTheMenu = Mock.fetchMockMeals().filter { it.isOnTheMealMenu }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            mealsOnTheMenu.forEach { mealsOnTheMenu ->
                var isOnTheMenu by remember {
                    mutableStateOf(mealsOnTheMenu.isOnTheMealMenu)
                }

                MealCard(
                    recipe = mealsOnTheMenu,
                    isOnTheMenu = isOnTheMenu,
                    onClickToMenu = {
                        isOnTheMenu = it
                    }
                )
            }
        }
    }
}