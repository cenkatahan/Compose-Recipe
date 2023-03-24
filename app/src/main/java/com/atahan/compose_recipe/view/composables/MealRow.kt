package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.common.Mock
import com.atahan.compose_recipe.model.Screen

@Composable
fun MealRow(
    navController: NavHostController
) {
    val meals = Mock.fetchMockMeals()

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = "TITLE", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {

            meals.forEach { meal ->
                item {
                    var isFavorite by remember {
                        mutableStateOf(meal.isFavorite)
                    }
                    var isOnTheMenu by remember {
                        mutableStateOf(meal.isOnTheMealMenu)
                    }
                    MealCard(
                        meal = meal,
                        isFavorite = isFavorite,
                        isOnTheMenu = isOnTheMenu,
                        onClickDetail = {
                            navController.navigate(Screen.RecipeDetail.withArgs(meal.id.toString()))
                        },
                        onClickFavorite = {
                            isFavorite = it
                        },
                        onClickToMenu = {
                            isOnTheMenu = it
                        }
                    )
                }
            }

        }

    }

}