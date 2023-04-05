package com.atahan.compose_recipe.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atahan.compose_recipe.common.Common.COL_DESC
import com.atahan.compose_recipe.common.Common.COL_INGREDIENTS
import com.atahan.compose_recipe.common.Common.COL_IS_FAV
import com.atahan.compose_recipe.common.Common.COL_MEAL_TYPE
import com.atahan.compose_recipe.common.Common.COL_NAME
import com.atahan.compose_recipe.common.Common.COL_ON_MENU
import com.atahan.compose_recipe.common.Common.COL_PREP_TIME
import com.atahan.compose_recipe.common.Common.TABLE_NAME
import com.atahan.compose_recipe.enums.MealType
import kotlinx.parcelize.Parcelize

@Entity(tableName = TABLE_NAME)
@Parcelize
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = COL_NAME)
    var name: String,
    @ColumnInfo(name = COL_DESC)
    var description: String,
    @ColumnInfo(name = COL_IS_FAV)
    var isFavorite: Boolean = false,
    @ColumnInfo(name = COL_MEAL_TYPE)
    var type: MealType,
    @ColumnInfo(name = COL_INGREDIENTS)
    var ingredients: List<String>,
    @ColumnInfo(name = COL_PREP_TIME)
    var prepareTime: Int,
    @ColumnInfo(name = COL_ON_MENU)
    var isOnTheMealMenu: Boolean = false
): Parcelable