package com.atahan.compose_recipe.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.atahan.compose_recipe.enums.Category
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
    var descriptions = mutableStateListOf<String>()
    var ingredients = mutableStateListOf<String>()

    fun save(recipe: Recipe) {

        when (val result = repo.add(recipe)) {
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

}