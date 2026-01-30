package com.example.vehicleinventory

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.size


@Composable
fun CustomCheckbox(
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    size: Dp = 20.dp
) {
    Icon(
        painter = painterResource(
            id = if (isSelected) R.drawable.ic_checkbox_checked
            else R.drawable.ic_checkbox_unchecked
        ),
        contentDescription = if (isSelected) "Checked" else "Unchecked",
        // The default tint can interfere with the SVG's colors, so set it to Unspecified.
        tint = Color.Unspecified,
        modifier = modifier.size(size)
    )
}
