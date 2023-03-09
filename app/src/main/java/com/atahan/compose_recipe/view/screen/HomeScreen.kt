package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.view.composables.ChipGroup
import com.atahan.compose_recipe.view.composables.SearchBar

@Composable
fun HomeScreen() {
    val mealSearched = remember { mutableStateOf("") }

    Column {
        SearchBar(
            modifier = Modifier.padding(16.dp),
            searchString = mealSearched
        )

        ChipGroup()
    }
}