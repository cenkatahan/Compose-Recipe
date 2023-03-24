package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.atahan.compose_recipe.common.Mock

@Composable
fun RecipeDetailScreen(recipeId: Int) {
    val recipe = Mock.fetchMockMeals().first { it.id == recipeId }

    //TITLE
    //BIG IMAGE
        //FAV BUTTON
        //MEAL BUTTON
    //INGREDIENT CHIPS

    //DESCRIPTION

    Column {
        Text(text = recipe.name, fontSize = 40.sp)
    }

    Text(text = "RecipeDetailScreen")
}