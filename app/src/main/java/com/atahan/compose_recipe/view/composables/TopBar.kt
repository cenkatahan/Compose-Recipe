package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.R
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onCLickProfile: () -> Unit,
    onClickAdd: () -> Unit
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
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
                onClick = { onCLickProfile() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile_default),
                    contentDescription = "profile",
                    tint = AppBlue
                )
            }

            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = { onClickAdd() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription = "add",
                    tint = AppBlue
                )
            }

        }
    }
}

fun Modifier.clickableWithoutRipple(
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
) = composed(
    factory = {
        this.then(
            Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = { onClick() }
            )
        )
    }
)


@Preview(showBackground = true)
@Composable
fun Preview() {
//    TopSection(modifier = Modifier.padding(16.dp))
}