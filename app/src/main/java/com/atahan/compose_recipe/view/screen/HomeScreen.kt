package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.atahan.compose_recipe.view.composables.BottomSection
import com.atahan.compose_recipe.view.composables.SearchBar
import com.atahan.compose_recipe.view.composables.TopSection

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val mealSearched = remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopSection(modifier = Modifier.padding(16.dp)) },
        bottomBar = { BottomSection(navController = navController) }
    ) {
        SearchBar(
            modifier = Modifier.padding(16.dp),
            searchString = mealSearched
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}