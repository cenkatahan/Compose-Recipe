package com.atahan.compose_recipe.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val id: Int,
    var name: String,
    var description: String,
    var isFavorite: Boolean = false,
    var type: MealType,
    var ingredients: List<String>,
    var prepareTime: Int,
    var isOnTheMealMenu: Boolean = false
): Parcelable