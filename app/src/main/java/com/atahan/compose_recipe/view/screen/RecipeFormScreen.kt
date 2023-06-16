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
import androidx.compose.ui.Alignment
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
import com.atahan.compose_recipe.ui.theme.AppBlue
import com.atahan.compose_recipe.view.composables.FormTopBar
import com.atahan.compose_recipe.view.composables.RecipeDialog
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
                    //TODO get parameters from view-model
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
            var descriptionSteps by remember { mutableStateOf<ArrayList<String>>(arrayListOf()) }
            var ingredients by remember { mutableStateOf<ArrayList<String>>(arrayListOf()) }
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

            //TODO Move into an another composable
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Recipe Steps",
                style = MaterialTheme.typography.h6,
            )
            //TODO Description Section
            Column {
                Button(
                    onClick = {
                        //TODO open dialog
                        parameterType = ParameterType.DESCRIPTION_STEPS
                        isDialogShown = true
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_circle),
                        contentDescription = "add new description",
                    )
                }

                viewModel.descriptions.value.forEach { step ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.align(Alignment.CenterStart)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dot),
                                contentDescription = "dot",
                                tint = AppBlue
                            )
                            Text(
                                text = step,
                            )
                        }
                        IconButton(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            onClick = {
                                //TODO openDialog and edit
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit),
                                contentDescription = "edit",
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Ingredients",
                style = MaterialTheme.typography.h6,
            )
            Column {
                Button(
                    onClick = {
                        parameterType = ParameterType.INGREDIENT
                        isDialogShown = true
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_circle),
                        contentDescription = "add new description",
                    )
                }

                viewModel.ingredients.value.forEach { ingredient ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.align(Alignment.CenterStart)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_dot),
                                contentDescription = "dot",
                                tint = AppBlue
                            )
                            Text(
                                text = ingredient,
                            )
                        }
                        IconButton(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            onClick = {
                                //TODO openDialog and edit
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_edit),
                                contentDescription = "edit",
                            )
                        }
                    }
                }
            }

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
                        //TODO add step to descriptions.
                        when (parameterType) {
                            ParameterType.INGREDIENT -> viewModel.storeIngredient(it)
                            ParameterType.DESCRIPTION_STEPS -> viewModel.storeDescriptionStep(it)
                        }
                        isDialogShown = false
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