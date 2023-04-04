package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.*

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val mealSearched = remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

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

        Column(
            modifier = Modifier
                .verticalScroll(state = scrollState)
        ) {

            Text(
                text = "Neriman Hanım, ne yapacağız bugün?",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(16.dp),
                color = Color.Black
            )

            SearchBar(
                modifier = Modifier.padding(16.dp),
                searchString = mealSearched
            )

            ChipGroup()

            Column {
                repeat((0..9).count()) {
                    MealRow(navController)
                }
            }
        }
    }
}