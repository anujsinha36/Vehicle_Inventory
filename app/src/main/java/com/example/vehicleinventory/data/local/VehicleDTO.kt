package com.example.vehicleinventory.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicles")
data class Vehicle(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val yearOfPurchase: Int,
    val brand: String ="",
    val model: String ="",
    val fuelType: String = "",
    val vehicleNumber: String = "",
    val ownerName: String = ""
)