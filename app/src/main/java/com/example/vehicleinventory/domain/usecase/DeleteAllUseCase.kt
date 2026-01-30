package com.example.vehicleinventory.domain.usecase

import com.example.vehicleinventory.domain.Repository.VehicleRepository
import javax.inject.Inject

class DeleteAllVehicleUseCase @Inject constructor(private val repository: VehicleRepository) {
    suspend operator fun invoke() = repository.deleteAllVehicle()
}