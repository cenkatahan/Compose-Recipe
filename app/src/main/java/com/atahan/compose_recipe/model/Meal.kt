package com.atahan.compose_recipe.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    var name: String,
    var description: String,
    var isFavorite: Boolean = false,
    var type: MealType,
//    var ingredients: ArrayList<String>,
    var prepareTime: Int,
    var isOnTheMealMenu: Boolean = false
): Parcelable
