package com.example.vehicleinventory.domain.usecase

import com.example.vehicleinventory.data.local.Vehicle
import com.example.vehicleinventory.domain.Repository.VehicleRepository
import javax.inject.Inject

class AddVehicleUseCase @Inject constructor(private val repository: VehicleRepository) {

    suspend operator fun invoke(vehicle: Vehicle) = repository.addVehicle(vehicle)
}