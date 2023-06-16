package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.enums.Category
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.*
import com.atahan.compose_recipe.viewmodel.HomeViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val scrollState = rememberScrollState()
    val selectedCategory = remember { mutableStateOf(Category.ALL) }

    Scaffold(
        topBar = {
            RecipeTopBar(
                leadingIcon = painterResource(id = R.drawable.ic_profile_default),
                trailingIcon = painterResource(
                    id = R.drawable.ic_add_circle
                ),
                onClickLeadingIcon = {
                    navController.navigate(Screen.Profile.route) {
                        popUpTo(Screen.Home.route)
                    }
                },
                onClickTrailingIcon = {
                    navController.navigate(Screen.RecipeForm.route) {
                        popUpTo(Screen.Home.route)
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

            SearchButton(
                navController = navController,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            ChipGroup(
                selectedCategory = selectedCategory,
            )

            //TODO move this column into a composable.
            Column {
                val recipes by remember { viewModel.recipes }
                //TODO add composables for isLoading and error.
                val isLoading by remember { viewModel.isLoading }
                val error by remember { viewModel.error }

                when (selectedCategory.value) {
                    Category.ALL -> {
                        Category.values().forEach {
                            MealRow(
                                navController = navController,
                                recipes = recipes,
                                title = it.title
                            )
                        }
                    }
                    else -> {
                        MealRow(
                            navController = navController,
                            recipes = recipes.filter { it.type.title == selectedCategory.value.name },
                            title = selectedCategory.value.name
                        )
                    }
                }
            }
        }
    }
}