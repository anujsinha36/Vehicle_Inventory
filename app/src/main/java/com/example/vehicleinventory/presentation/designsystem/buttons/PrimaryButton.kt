package com.example.vehicleinventory.presentation.designsystem.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehicleinventory.presentation.ui.theme.VehicleInventoryTheme

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    leadingIcon: (@Composable () -> Unit)? = null
){
    Button(
        onClick = onClick,
        modifier = modifier.height(52.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RoundedCornerShape(12.dp)

    ) {
        leadingIcon?.invoke()
        if (leadingIcon != null){
            Spacer(modifier.width(10.dp))
        }
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.surface
        )
    }
}

@Preview
@Composable
fun PreviewPrimaryButton(){
    VehicleInventoryTheme {
        PrimaryButton(
            text = "Add Vehicle",
            onClick = { },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "TODO()"

                )
            }
        )
    }
}