package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.enums.Category
import com.atahan.compose_recipe.model.Recipe
import com.atahan.compose_recipe.navigation.Graph
import com.atahan.compose_recipe.navigation.Screen
import com.atahan.compose_recipe.view.composables.AddItemSection
import com.atahan.compose_recipe.view.composables.RecipeDialog
import com.atahan.compose_recipe.view.composables.RecipeTopBar
import com.atahan.compose_recipe.viewmodel.FormViewModel

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "MutableCollectionMutableState")
@Composable
fun RecipeFormScreen(
    navController: NavHostController,
    viewModel: FormViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            RecipeTopBar(
                leadingIcon = painterResource(id = R.drawable.ic_home),
                trailingIcon = painterResource(id = R.drawable.ic_confirm),
                onClickLeadingIcon = {
                    navController.navigate(Graph.APP_GRAPH) {
                        popUpTo(Screen.Home.route)
                    }
                },
                onClickTrailingIcon = {
                    viewModel.save(
                        Recipe(
                            0,
                            viewModel.recipeName.value,
                            ArrayList(viewModel.descriptions.toList()),
                            false,
                            viewModel.mealType.value,
                            ArrayList(viewModel.ingredients.toList()),
                            viewModel.prepTime.value.toInt()
                        )
                    )

                    if (viewModel.isSuccess.value) {
                        navController.navigate(Graph.APP_GRAPH) {
                            popUpTo(Screen.Home.route)
                        }
                    }
                }
            )
        }
    ) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .verticalScroll(scrollState),
        ) {

            var recipeName by remember { mutableStateOf("") }
            var prepTime by remember { mutableStateOf("") }
            var mealType by remember { mutableStateOf(Category.ALL.title) }
            var isExpanded by remember { mutableStateOf(false) }
            var isDialogShown by remember { mutableStateOf(false) }
            var parameterType by remember { mutableStateOf(ParameterType.DESCRIPTION_STEPS) }

            Text(
                text = "Add a Recipe",
                style = MaterialTheme.typography.h2,
            )

            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = recipeName,
                onValueChange = {
                    recipeName = it
                    viewModel.recipeName.value = it
                },
                label = { Text(text = "Recipe Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = prepTime,
                onValueChange = {
                    if (it.isEmpty()) {
                        prepTime = ""
                        return@TextField
                    }
                    if (it.toInt() > 100) {
                        return@TextField
                    }
                    prepTime = it
                    viewModel.prepTime.value = it
                },
                label = { Text(text = "Preparation Time") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(8.dp))
            //TODO Move into an another composable
            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = { isExpanded = !isExpanded }
            ) {
                TextField(
                    value = mealType,
                    onValueChange = { type ->
                        mealType = type
                        val selectedType = Category.values().first { it.title == type }
                        viewModel.mealType.value = selectedType
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Enter Meal Type")
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_dropdown),
                            contentDescription = "down"
                        )
                    }
                )

                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = {
                        isExpanded = false
                    }
                ) {
                    Category.values().forEach { category ->
                        DropdownMenuItem(
                            onClick = {
                                mealType = category.name
                                isExpanded = !isExpanded
                            }
                        ) {
                            Text(text = category.name)
                        }

                    }

                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Recipe Steps",
                style = MaterialTheme.typography.h6,
            )
            AddItemSection(
                section = viewModel.descriptions,
                toggleDialog = {
                    isDialogShown = it
                    parameterType = ParameterType.DESCRIPTION_STEPS
                },
                onClickDelete = { viewModel.descriptions.removeAt(it) },
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Ingredients",
                style = MaterialTheme.typography.h6,
            )
            AddItemSection(
                section = viewModel.ingredients,
                toggleDialog = {
                    isDialogShown = it
                    parameterType = ParameterType.INGREDIENT
                },
                onClickDelete = { viewModel.ingredients.removeAt(it) },
            )


            if (isDialogShown) {
                RecipeDialog(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(Color.White),
                    onDismiss = {
                        isDialogShown = false
                    },
                    onConfirm = {
                        when (parameterType) {
                            ParameterType.INGREDIENT -> viewModel.ingredients.add(it)
                            ParameterType.DESCRIPTION_STEPS -> viewModel.descriptions.add(it)
                        }
                        isDialogShown = false
                        println("VIEWMODEL: \n${viewModel.descriptions}")
                    },
                )
            }
        }

    }
}

enum class ParameterType {
    INGREDIENT,
    DESCRIPTION_STEPS
}