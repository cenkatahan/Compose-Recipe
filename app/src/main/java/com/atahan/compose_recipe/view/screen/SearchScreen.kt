package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.atahan.compose_recipe.view.composables.MealCard
import com.atahan.compose_recipe.view.composables.SearchBar
import com.atahan.compose_recipe.viewmodel.SearchViewModel
import kotlin.math.floor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val searchString = remember { mutableStateOf("") }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val fixedGripSize = floor(screenWidth / 144.dp).toInt()
    val recipes = remember { viewModel.recipes.value }

    Scaffold {
        Column {
            SearchBar(
                searchString = searchString,
                modifier = modifier
                    .padding(16.dp),
                onSearchChange = {
                    viewModel.search(it)
                    println("SEARCH: $it")
                    viewModel.searchedRecipes.value.forEach { recipe ->
                        println("SEARCH RECIPES: ${recipe.name}}")
                    }
                }
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(count = fixedGripSize),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    items(viewModel.searchedRecipes.value.size) { index ->
                        var isFavorite by remember {
                            mutableStateOf(recipes[index].isFavorite)
                        }

                        var isOnMenu by remember {
                            mutableStateOf(recipes[index].isOnTheMealMenu)
                        }

                        MealCard(
                            recipe = recipes[index],
                            isFavorite = isFavorite,
                            isOnTheMenu = isOnMenu,
                            onClickFavorite = {
                                isFavorite = it
                                recipes[index].isFavorite = it
//                            viewModel.updateRecipe(favMeals[index])
                            },
                            onClickToMenu = {
                                isOnMenu = it
                                recipes[index].isOnTheMealMenu = it
//                            viewModel.updateRecipe(favMeals[index])
                                println("${viewModel.recipes.value[index]}")
                            }
                        )
                    }
                }
            )
        }
    }
}