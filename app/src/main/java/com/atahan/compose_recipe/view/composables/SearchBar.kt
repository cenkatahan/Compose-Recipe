package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchString: MutableState<String>,
    onSearchChange: (String) -> Unit
) {

    //BasicTextField may allow to customize TextField background.
    TextField(
        value = searchString.value,
        onValueChange = {
            searchString.value = it
            onSearchChange(it)
        },
        label = { Text(text = "Search...") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search icon",
                tint = AppBlue
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp)),
    )
}