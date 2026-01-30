package com.example.vehicleinventory.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVehicle(vehicle: Vehicle)

    @Query("SELECT COUNT(*) FROM vehicles")
    fun getVehicleCount(): Flow<Int>
    //to make  UI automatically update when the data changes,using flow instead of suspend function

    @Query("SELECT COUNT(*) FROM vehicles WHERE fuelType = 'Electric'")
    fun getElectricVehicleCount(): Flow<Int>

    @Query("SELECT * FROM vehicles")
    fun getAllVehicles(): Flow<List<Vehicle>>

    @Query("DELETE FROM vehicles")
    suspend fun deleteAllVehicle()


}