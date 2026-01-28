package com.example.vehicleinventory.domain.Repository

import com.example.vehicleinventory.data.local.Vehicle
import kotlinx.coroutines.flow.Flow

interface VehicleRepository {

    fun getVehicles(): Flow<List<Vehicle>>

    suspend fun addVehicle(vehicle: Vehicle)

    fun getTotalVehicleCount(): Flow<Int>

    fun getElectricVehicleCount(): Flow<Int>
}