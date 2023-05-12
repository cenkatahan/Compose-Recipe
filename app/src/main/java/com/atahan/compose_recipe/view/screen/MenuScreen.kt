package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.BottomBar
import com.atahan.compose_recipe.view.composables.RecipeCard
import com.atahan.compose_recipe.view.composables.TopBar
import com.atahan.compose_recipe.viewmodel.MenuViewModel
import kotlin.math.floor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MenuScreen(
    navController: NavHostController,
    viewModel: MenuViewModel = hiltViewModel()
) {
//    val recipesOnTheMenu = Mock.fetchMockMeals().filter { it.isOnTheMealMenu }
    val recipesOnTheMenu = viewModel.recipesOnMenu

    Scaffold(
        topBar = {
            TopBar(
                modifier = Modifier.padding(16.dp),
                onCLickProfile = {
                    navController.navigate(Screen.Profile.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                },
                onClickAdd = {
                    navController.navigate(Screen.RecipeForm.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                },
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
                items(recipesOnTheMenu.value.size) { index ->
                    val isOnTheMenu by remember {
                        mutableStateOf(recipesOnTheMenu.value[index].isOnTheMealMenu)
                    }
                    var isFavorite by remember {
                        mutableStateOf(recipesOnTheMenu.value[index].isFavorite)
                    }

                    RecipeCard(
                        recipe = recipesOnTheMenu.value[index],
                        isOnTheMenu = isOnTheMenu,
                        isFavorite = isFavorite,
                        onClickToMenu = {
                            recipesOnTheMenu.value[index].isOnTheMealMenu = it
                            viewModel.updateRecipe(recipesOnTheMenu.value[index])
                        },
                        onClickFavorite = {
                            isFavorite = it
                            recipesOnTheMenu.value[index].isFavorite = it
                            viewModel.updateRecipe(recipesOnTheMenu.value[index])
                        }
                    )
                }
            }
        )
    }
}