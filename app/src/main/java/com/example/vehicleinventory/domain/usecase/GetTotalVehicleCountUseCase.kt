package com.example.vehicleinventory.domain.usecase

import com.example.vehicleinventory.domain.Repository.VehicleRepository
import javax.inject.Inject

class GetTotalVehicleCountUseCase @Inject constructor(private val repository: VehicleRepository) {
    operator fun invoke() = repository.getTotalVehicleCount()
}