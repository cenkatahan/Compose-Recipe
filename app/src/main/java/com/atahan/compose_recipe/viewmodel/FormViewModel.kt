package com.atahan.compose_recipe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.atahan.compose_recipe.enums.Category
import com.atahan.compose_recipe.enums.MealType
import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.repository.RecipeRepo
import com.atahan.compose_recipe.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val repo: RecipeRepo
) : ViewModel() {

    var isSuccess = mutableStateOf(false)
    var isLoading = mutableStateOf(false)
    var error = mutableStateOf("")

    var recipeName = mutableStateOf("")
    var prepTime = mutableStateOf("")
    var mealType = mutableStateOf(Category.ALL)
    var descriptions = mutableStateOf<ArrayList<String>>(arrayListOf())
    var ingredients = mutableStateOf<ArrayList<String>>(arrayListOf())

    fun save(recipe: Recipe) {
        val result = repo.add(recipe)

        when (repo.add(recipe)) {
            is Resource.Success -> {
                isSuccess.value = true
                isLoading.value = false
            }
            is Resource.Error -> {
                isLoading.value = false
                isSuccess.value = false
                result.message?.let { error.value = it }
            }
            else -> {
                isLoading.value = true
                isSuccess.value = false
            }
        }
    }

    fun storeRecipe(str: String) {
        recipeName.value = str
    }

    fun storePrepTime(time: String) {
        prepTime.value = time
    }

    fun storeMealType(type: Category) {
        mealType.value = type
    }

    fun storeDescriptionStep(step: String) {
        descriptions.value.add(step)
    }

    fun storeIngredient(ingredient: String) {
        ingredients.value.add(ingredient)
    }

}