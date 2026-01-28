package com.example.vehicleinventory.data.local

import com.example.vehicleinventory.domain.Repository.VehicleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VehicleRepoImpl @Inject constructor(
    private val vehicleDao: VehicleDao
): VehicleRepository {

    override fun getVehicles() : Flow<List<Vehicle>> {
       return vehicleDao.getAllVehicles()
    }

    override suspend fun addVehicle(vehicle: Vehicle) {
        vehicleDao.insertVehicle(vehicle)
    }

    override fun getTotalVehicleCount(): Flow<Int> {
       return vehicleDao.getVehicleCount()
    }

    override fun getElectricVehicleCount(): Flow<Int> {
        return vehicleDao.getElectricVehicleCount()
    }
}