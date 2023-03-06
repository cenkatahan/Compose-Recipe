package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.atahan.compose_recipe.R

@Composable
fun SearchBar(modifier: Modifier = Modifier, searchString: MutableState<String>) {

    OutlinedTextField(
        value = searchString.value,
        onValueChange = {
            searchString.value = it
        },
        label = { Text(text = "Search...") },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search icon",
            )
        },
        modifier = modifier.fillMaxWidth()
    )
}