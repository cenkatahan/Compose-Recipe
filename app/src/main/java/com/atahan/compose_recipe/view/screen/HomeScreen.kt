package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.view.composables.ChipGroup
import com.atahan.compose_recipe.view.composables.MealRow
import com.atahan.compose_recipe.view.composables.SearchBar

@Composable
fun HomeScreen(onClickNavigateAdd: () -> Unit, onClickNavigateProfile: () -> Unit) {
    val mealSearched = remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(state = scrollState)
    ) {
        SearchBar(
            modifier = Modifier.padding(16.dp),
            searchString = mealSearched
        )

        ChipGroup()

        Column {
            (0..9).forEach {
                MealRow()
            }
        }
    }
}