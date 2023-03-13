package com.atahan.compose_recipe.model

data class Meal(
    var name: String,
    var description: String,
    var isFavorite: Boolean = false,
    var type: MealType,
    var prepareTime: Int
)
