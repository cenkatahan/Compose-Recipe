package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.common.Mock
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.BottomBar
import com.atahan.compose_recipe.view.composables.MealCard
import com.atahan.compose_recipe.view.composables.TopBar

@Composable
fun MealMenuScreen(navController: NavHostController) {
    val mealsOnTheMenu = Mock.fetchMockMeals().filter { it.isOnTheMealMenu }


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
}