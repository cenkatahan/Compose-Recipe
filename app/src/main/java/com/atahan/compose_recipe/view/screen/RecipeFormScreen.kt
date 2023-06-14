package com.atahan.compose_recipe.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
import com.atahan.compose_recipe.view.composables.FormTopBar
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
            FormTopBar(
                onClickHome = {
                    navController.navigate(Graph.APP_GRAPH) {
                        popUpTo(Screen.Home.route)
                    }
                },
                onClickConfirmAdd = {
                    //TODO implement code here.
                    //TODO get parameters from viewmodel
                    viewModel.save(
                        Recipe(
                            0,
                            viewModel.recipeName.value,
                            arrayListOf(),
                            false,
                            viewModel.mealType.value,
                            arrayListOf(),
//                        viewModel.prepTime.value.toInt()
                            0
                        )
                    )
                    println("RECIPE NAME: ${viewModel.recipeName.value}")

                    if (viewModel.isSuccess.value) {
                        navController.navigate(Graph.APP_GRAPH) {
                            popUpTo(Screen.Home.route)
                        }
                    }
                }
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            var recipeName by remember { mutableStateOf("") }
            var prepTime by remember { mutableStateOf("") }
            var mealType by remember { mutableStateOf(Category.ALL.title) }
            var descriptionSize by remember { mutableStateOf(1) }
            var isExpanded by remember { mutableStateOf(false) }

            Text(
                text = "Add a Recipe",
                style = MaterialTheme.typography.h2,
            )

            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = recipeName,
                onValueChange = {
                    recipeName = it
                    viewModel.storeRecipe(it)
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
                    viewModel.storePrepTime(it)
                },
                label = { Text(text = "Preparation Time") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(8.dp))
            ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = { isExpanded = !isExpanded }
            ) {
                TextField(
                    value = mealType,
                    onValueChange = { type ->
                        mealType = type
                        val selectedType = Category.values().first { it.title == type }
                        viewModel.storeMealType(selectedType)
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


            //TODO Description Section
//            Spacer(modifier = Modifier.height(8.dp))
//            Column {
//
//                (0 until descriptionSize).forEachIndexed { index, desc ->
//                    Spacer(modifier = Modifier.height(4.dp))
//                    TextField(
//                        value = "",
//                        onValueChange = {},
//                        label = { Text(text = "Recipe Description") },
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                }
//
//                Button(
//                    onClick = {
//                        descriptionSize++
//                    },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_add_circle),
//                        contentDescription = "add new description",
//                    )
//                }
//            }
        }

    }
}