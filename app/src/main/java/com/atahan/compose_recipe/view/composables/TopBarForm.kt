package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun FormTopBar(
    modifier: Modifier = Modifier,
    onClickHome: () -> Unit,
    onClickConfirmAdd: () -> Unit
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
                onClick = { onClickHome() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "profile",
                    tint = AppBlue
                )
            }

            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { onClickConfirmAdd() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_confirm),
                    contentDescription = "add",
                    tint = AppBlue
                )
            }

        }
    }
}