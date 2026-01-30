package com.example.vehicleinventory.presentation.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehicleinventory.data.local.Vehicle
import com.example.vehicleinventory.domain.util.getVehicleAge
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun VehicleItem(vehicle: Vehicle) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth().height(72.dp)
                .background(
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                )
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Model & Brand
            Column(
                modifier = Modifier.weight(0.8f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = vehicle.model,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                    Text(
                        text = vehicle.brand,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

            }

            // Vertical Divider 1
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                color = MaterialTheme.colorScheme.outline
            )

            // Vehicle Number
            Text(
                text = vehicle.vehicleNumber,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1.3f),
                maxLines = 1

            )

            // Vertical Divider 2
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                color = MaterialTheme.colorScheme.outline
            )
            // Fuel Type
            Text(
                text = vehicle.fuelType,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(0.8f),

            )

            // Vertical Divider 3
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp),
                color = MaterialTheme.colorScheme.outline
            )
            // Year of Purchase & Duration
            Column(
                modifier = Modifier.weight(1.4f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "${vehicle.yearOfPurchase}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = getVehicleAge(vehicle.yearOfPurchase),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Horizontal Divider at bottom
        Divider(color = Color(0xFFE2E8F0), thickness = 1.dp)
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewVehicleItem(){
    VehicleInventoryTheme {
        VehicleItem(
            vehicle =
                Vehicle(
                    brand = "Activa 4G",
                    model = "Honda",
                    vehicleNumber = "KA 01 AA 0027",
                    fuelType = "Petrol",
                    yearOfPurchase = "2018".toInt(),
                    ownerName = "7 years 6 months"
                )
        )
    }
}