package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.ui.theme.AppBlue
import com.atahan.compose_recipe.ui.theme.AppGrey
import com.atahan.compose_recipe.ui.theme.AppOrange
import com.atahan.compose_recipe.ui.theme.Shapes

@Composable
fun SearchBar(modifier: Modifier = Modifier, searchString: MutableState<String>) {

    TextField(
        value = searchString.value,
        onValueChange = {
            searchString.value = it
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
            .clip(RoundedCornerShape(16.dp)),
    )
}