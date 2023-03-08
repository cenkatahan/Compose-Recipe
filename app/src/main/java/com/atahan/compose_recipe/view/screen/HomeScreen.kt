package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.view.composables.BottomSection
import com.atahan.compose_recipe.view.composables.SearchBar
import com.atahan.compose_recipe.view.composables.TopSection

@Composable
fun HomeScreen(navController: NavHostController) {
    val mealSearched = remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopSection(modifier = Modifier.padding(16.dp)) },
        bottomBar = { BottomSection(navController = navController, onItemClick = {
            navController.navigate(it.route)
        }) }
    ) {
        SearchBar(
            modifier = Modifier.padding(16.dp),
            searchString = mealSearched
        )
    }
}