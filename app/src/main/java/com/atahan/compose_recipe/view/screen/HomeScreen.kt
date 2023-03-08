package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.view.composables.SearchBar

@Composable
fun HomeScreen(navController: NavHostController) {
    val mealSearched = remember { mutableStateOf("") }

    Column {
        SearchBar(
            modifier = Modifier.padding(16.dp),
            searchString = mealSearched
        )
    }
}