package com.example.vehicleinventory.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme

@Composable
fun VehicleTableHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                MaterialTheme.colorScheme.surfaceContainer,
                RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            )
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Model &\nBrand",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.weight(0.8f),
            textAlign = TextAlign.Center
        )
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
            color = MaterialTheme.colorScheme.outline
        )

        Text(
            text = "Vehicle Number",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.weight(1.3f),
            textAlign = TextAlign.Center
        )
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
            color = MaterialTheme.colorScheme.outline
        )
        Text(
            text = "Fuel Type",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.weight(0.8f),
            textAlign = TextAlign.Center
        )
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp),
            color = MaterialTheme.colorScheme.outline
        )
        Text(
            text = "Year of Purchase",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.weight(1.4f),
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PreviewVehicleTableHeader(){
    VehicleInventoryTheme {
        VehicleTableHeader()
    }
}