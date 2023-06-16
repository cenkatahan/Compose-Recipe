package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.ui.theme.AppBlue


@Composable
fun RecipeTopBar(
    modifier: Modifier = Modifier,
    leadingIcon: Painter,
    trailingIcon: Painter,
    onClickLeadingIcon: () -> Unit,
    onClickTrailingIcon: () -> Unit
) {
    TopAppBar(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { onClickLeadingIcon() }
            ) {
                Icon(
                    painter = leadingIcon,
                    contentDescription = "profile",
                    tint = AppBlue
                )
            }

            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { onClickTrailingIcon() }
            ) {
                Icon(
                    painter = trailingIcon,
                    contentDescription = "add",
                    tint = AppBlue
                )
            }

        }
    }
}

@Preview
@Composable
fun AppPrev() {
    RecipeTopBar(
        leadingIcon = painterResource(id = R.drawable.ic_home),
        trailingIcon = painterResource(id = R.drawable.ic_profile_default),
        onClickLeadingIcon = {
            //TODO navigateBack
        },
        onClickTrailingIcon = {
            //TODO profile or add new recipe.
        }
    )
}