package com.example.vehicleinventory.presentation.screens.addvehicle

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun SectionHeader(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.inverseOnSurface,

    )
}