package com.atahan.compose_recipe.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Meal(
    val id: String = UUID.randomUUID().toString(),
    var name: String,
    var description: String,
    var isFavorite: Boolean = false,
    var type: MealType,
//    var ingredients: ArrayList<String>,
    var prepareTime: Int,
    var isOnTheMealMenu: Boolean = false
): Parcelable