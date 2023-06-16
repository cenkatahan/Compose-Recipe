package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.BottomBar
import com.atahan.compose_recipe.view.composables.RecipeCard
import com.atahan.compose_recipe.view.composables.RecipeTopBar
import com.atahan.compose_recipe.viewmodel.FavoriteViewModel
import kotlin.math.floor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoritesScreen(
    navController: NavHostController,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val favMeals = viewModel.favRecipes.value

    Scaffold(
        topBar = {
            RecipeTopBar(
                leadingIcon = painterResource(id = R.drawable.ic_profile_default),
                trailingIcon = painterResource(id = R.drawable.ic_add_circle),
                onClickLeadingIcon = {
                    navController.navigate(Screen.Profile.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                },
                onClickTrailingIcon = {
                    navController.navigate(Screen.RecipeForm.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(navController = navController, onItemClick = {
                navController.navigate(it.route) {
                    popUpTo(it.route) {
                        inclusive = true
                    }
                }
            })
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val fixedGripSize = floor(screenWidth / 144.dp).toInt()

        LazyVerticalGrid(
            columns = GridCells.Fixed(count = fixedGripSize),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(viewModel.favRecipes.value.size) { index ->
                    val isFavorite by remember {
                        mutableStateOf(viewModel.favRecipes.value[index].isFavorite)
                    }

                    val isOnMenu by remember {
                        mutableStateOf(favMeals[index].isOnTheMealMenu)
                    }

                    RecipeCard(
                        recipe = favMeals[index],
                        isFavorite = isFavorite,
                        isOnTheMenu = isOnMenu,
                        onClickFavorite = {
                            favMeals[index].isFavorite = it
                            viewModel.updateRecipe(favMeals[index])
                        },
                        onClickToMenu = {
                            favMeals[index].isOnTheMealMenu = it
                            viewModel.updateRecipe(favMeals[index])
                            println("${viewModel.favRecipes.value[index]}")
                        }
                    )
                }
            }
        )
    }
}