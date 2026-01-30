package com.example.vehicleinventory.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehicleinventory.presentation.theme.GradientEndBlue
import com.example.vehicleinventory.presentation.theme.GradientStartBlue
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme

@Composable
fun TopSection(
    userName: String,
    totalVehicles: Int,
    totalEV: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        GradientStartBlue,
                        GradientEndBlue
                    )
                )
            ) // Used brush gradient as ellipses were not working
            .padding(top = 40.dp, bottom = 24.dp, start = 15.dp, end = 15.dp)
    ) {
            // Greeting Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Profile Picture
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(com.example.vehicleinventory.R.drawable.avatar),
                        contentDescription = ""
                    )
                }
                Column {
                    Text(
                        text = "Hi, $userName 👋",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.surface
                    )
                    Text(
                        text = "Welcome back!",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surface
                    )
                }


            }

            Spacer(modifier = Modifier.height(35.dp))

            // Statistics Cards Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                TotalStatCard(
                    modifier = Modifier.weight(1f),
                    title = "Total Vehicles",
                    value = totalVehicles.toString(),
                )

                EVStatCard(
                    modifier = Modifier.weight(1f),
                    title = "Total EV",
                    value = totalEV.toString(),
                )
            }
        }
}


@Preview
@Composable
fun PreviewTopSection(){
    VehicleInventoryTheme {
        TopSection(
            userName = "Amin",
            totalVehicles = 0,
            totalEV = 0
        )
    }
}