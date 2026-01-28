package com.example.vehicleinventory.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vehicleinventory.R
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme


@Composable
fun VehicleInventoryList(
    vehicles: List<Vehicle>,
    onFilterClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .offset(y = (-20).dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 24.dp)
        ) {
                Text(
                    text = "Vehicle Inventory List",
                    style = MaterialTheme.typography.titleMedium
                )
            Spacer(modifier = Modifier.height(16.dp))

            Card (
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 3.dp, horizontal = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    IconButton(
                        onClick = onFilterClick,
                        modifier = Modifier.size(24.dp)
                        ) {
                        Icon(
                            painterResource(R.drawable.ic_filter),
                            contentDescription = "filter",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = "Filter",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Table Header
            VehicleTableHeader()


            // Vehicle List
            LazyColumn(
                modifier = Modifier.weight(1f),
            ) {
                items(vehicles) { vehicle ->
                    VehicleItem(vehicle = vehicle)
                }
            }

         //   Spacer(modifier = Modifier.height(16.dp))


        }
    }
}

@Preview
@Composable
fun PreviewVehicleInventoryList(){
    VehicleInventoryTheme {
        VehicleInventoryList(
            vehicles = listOf(
                Vehicle(
                    modelAndBrand = "Activa 4G\nHonda",
                    vehicleNumber = "KA 01 AA 0027",
                    fuelType = "Petrol",
                    yearOfPurchase = "2018",
                    duration = "7 years 0 months"
                ),
                Vehicle(
                    modelAndBrand = "Nexon XM\nTata",
                    vehicleNumber = "KA 10 AM 2523",
                    fuelType = "Petrol",
                    yearOfPurchase = "2021",
                    duration = "5 years 1 month"
                ),
                Vehicle(
                    modelAndBrand = "Activa 125\nHonda",
                    vehicleNumber = "DL 8 CAF 9876",
                    fuelType = "Petrol",
                    yearOfPurchase = "2020",
                    duration = "5 years 4 months"
                ),
                Vehicle(
                    modelAndBrand = "Activa 125\nHonda",
                    vehicleNumber = "DL 8 CAF 9876",
                    fuelType = "Petrol",
                    yearOfPurchase = "2020",
                    duration = "4 years 3 months"
                ),
                Vehicle(
                    modelAndBrand = "City VX\nHonda",
                    vehicleNumber = "TN 22 CZ 3344",
                    fuelType = "Petrol",
                    yearOfPurchase = "2022",
                    duration = "3 years 2 months"
                ),
                Vehicle(
                    modelAndBrand = "Pulsar 150\nBajaj",
                    vehicleNumber = "UP 32 KT 1098",
                    fuelType = "Petrol",
                    yearOfPurchase = "2019",
                    duration = "6 years 5 months"
                )
            ),
            onFilterClick = {}
        )
    }
}