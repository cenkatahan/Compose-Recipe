package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.enums.Category
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun Chip(
    category: Category,
    selectedCategory: Category,
    modifier: Modifier = Modifier,
    onClickSelect: (Category) -> Unit
) {
    val isSelected = category == selectedCategory
    val textColor = when (isSelected) {
        true -> Color.White
        else -> AppBlue
    }
    val background = when (isSelected) {
        true -> AppBlue
        else -> Color.White
    }

    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(background)
            .clickable {
                onClickSelect(category)
                println("$category")

            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = category.name.uppercase(),
            color = textColor,
            modifier = Modifier
                .padding(8.dp)
        )

    }

}