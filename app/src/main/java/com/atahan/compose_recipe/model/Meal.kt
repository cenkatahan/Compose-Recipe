package com.atahan.compose_recipe.model

data class Meal(
    val name: String,
    val description: String,
    val isFavorite: Boolean,
    val type: MealType,
    val prepareTime: Int
)
