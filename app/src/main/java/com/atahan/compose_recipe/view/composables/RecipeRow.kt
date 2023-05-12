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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.viewmodel.HomeViewModel

@Composable
fun MealRow(
    navController: NavHostController,
    recipes: List<Recipe>,
    title: String = "TITLE",
    viewModel: HomeViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow {

            recipes.forEach { recipe ->
                item {
                    var isFavorite by remember {
                        mutableStateOf(recipe.isFavorite)
                    }
                    var isOnTheMenu by remember {
                        mutableStateOf(recipe.isOnTheMealMenu)
                    }
                    RecipeCard(
                        recipe = recipe,
                        isFavorite = isFavorite,
                        isOnTheMenu = isOnTheMenu,
                        onClickDetail = {
                            navController.navigate(Screen.RecipeDetail.withArgs(recipe.id.toString()))
                        },
                        onClickFavorite = {
                            isFavorite = it
                            recipe.isFavorite = it
                            viewModel.updateRecipe(recipe)
                        },
                        onClickToMenu = {
                            isOnTheMenu = it
                            recipe.isOnTheMealMenu = it
                            viewModel.updateRecipe(recipe)
                        }
                    )
                }
            }

        }

    }

}