package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.enums.Category

@Composable
fun ChipGroup(
    selectedCategory: MutableState<Category>,
//    onClickCategory: (Category) -> Unit
) {
    val categories = Category.values()

//    var selected by remember {
//        mutableStateOf(Category.ALL)
//    }

    Row {
        LazyRow(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        ) {
            categories.forEach { category ->
                item {
                    Chip(
                        category = category,
                        selectedCategory = selectedCategory.value,
                        onClickSelect = {
                            selectedCategory.value = it
                            println("ChipGroup: $it")
                        }
                    )
                }
            }
        }
    }
}