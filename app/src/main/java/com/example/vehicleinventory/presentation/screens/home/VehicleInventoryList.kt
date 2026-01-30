package com.example.vehicleinventory.presentation.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
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
import com.example.vehicleinventory.data.local.Vehicle
import com.example.vehicleinventory.presentation.theme.VehicleInventoryTheme


@RequiresApi(Build.VERSION_CODES.O)
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
                    modifier = Modifier.clickable{onFilterClick()}
                    .padding(vertical = 8.dp, horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                        Icon(
                            painterResource(R.drawable.ic_filter),
                            contentDescription = "filter",
                            modifier = Modifier.size(12.dp)
                        )

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

//@Preview
//@Composable
//fun PreviewVehicleInventoryList(){
//    VehicleInventoryTheme {
//        VehicleInventoryList(
//            vehicles = ,
//            onFilterClick = {}
//        )
//    }
//}