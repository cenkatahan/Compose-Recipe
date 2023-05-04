package com.atahan.compose_recipe.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.view.composables.OutlinedChip
import com.atahan.compose_recipe.viewmodel.DetailViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RecipeDetailScreen(
    recipeId: Int,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val recipe = viewModel.getRecipe(recipeId).data
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = 16.dp,
                end = 16.dp,
            )
            .verticalScroll(scrollState)
    ) {

        //TITLE
        //TODO add elvis ope.
        recipe?.let {
            Text(
                text = it.name,
                style = MaterialTheme.typography.h2,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        //BIG IMAGE
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    //TODO color for temporary background 0xFFFC5B5B
                    .background(
                        color = Color(0xB0FC5B5B),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {

                //FAV BUTTON
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(24.dp))
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color.White)
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = "favorite button"
                    )
                }

                //TODO MEAL BUTTON
//                IconButton(
//                    onClick = { },
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(24.dp))
//                        .background(Color.White)
//                        .align(Alignment.TopEnd)
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.ic_meal_plan),
//                        contentDescription = "favorite button"
//                    )
//                }
            }
        }


        //INGREDIENT CHIPS
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow {
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
            OutlinedChip()
        }

        //DESCRIPTION
        Spacer(modifier = Modifier.height(8.dp))
        //TODO add elvis ope.
        recipe?.description?.let {
            Text(
                text = it,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}