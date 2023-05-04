package com.atahan.compose_recipe.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atahan.compose_recipe.ui.theme.AppBlue

@Composable
fun OutlinedChip(
    background: Color = Color.White,
    color: Color = AppBlue
) {
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(color)
                .padding(2.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(background)
        ) {
            Text(
                text = "MILK",
                color = color,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
    Spacer(modifier = Modifier.width(8.dp))

}

@Preview
@Composable
fun PreviewOutlinedChip() {
    OutlinedChip()
}