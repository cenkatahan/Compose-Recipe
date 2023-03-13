package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.atahan.compose_recipe.R

@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    onCLickProfile: () -> Unit,
    onClickAdd: () -> Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_profile_default),
                contentDescription = "profile",
                modifier = Modifier.clickableWithoutRipple(
                    interactionSource = interactionSource,
                ) {
                    onCLickProfile()
                }
            )

            IconButton(onClick = { onClickAdd() }) {
                Icon(painter = painterResource(id = R.drawable.ic_add_circle), contentDescription = null)
            }

//            Icon(
//                painter = painterResource(id = R.drawable.ic_add_circle),
//                contentDescription = "location",
//                modifier = Modifier.clickableWithoutRipple(
//                    interactionSource = interactionSource
//                ) {
//                    onClickAdd()
//                }
//            )

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