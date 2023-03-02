package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.view.composables.TopSection

@Composable
fun HomeScreen() {

    Row {
        TopSection(modifier = Modifier.padding(16.dp))
    }
}