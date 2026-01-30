package com.example.vehicleinventory.di

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.vehicleinventory.data.local.VehicleDao
import com.example.vehicleinventory.data.local.VehicleDatabase
import com.example.vehicleinventory.data.repository.VehicleRepoImpl
import com.example.vehicleinventory.domain.Repository.VehicleRepository
import com.example.vehicleinventory.domain.usecase.AddVehicleUseCase
import com.example.vehicleinventory.domain.usecase.GetElectricVehicleCountUseCase
import com.example.vehicleinventory.domain.usecase.GetTotalVehicleCountUseCase
import com.example.vehicleinventory.domain.usecase.GetVehiclesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): VehicleDatabase {
        val db = Room.databaseBuilder(
            appContext,
            VehicleDatabase::class.java,
            "vehicle_database"
        ).build()

        // Log the expected DB file path so you can inspect it on the device/emulator
        try {
            val path = appContext.getDatabasePath("vehicle_database").absolutePath
            Log.d("AppModule", "Vehicle DB path: $path")
        } catch (e: Exception) {
            Log.w("AppModule", "Failed to resolve DB path: ${e.message}")
        }

        return db
    }

    @Provides
    @Singleton
    fun provideVehicleDao(database: VehicleDatabase) = database.vehicleDao()

    @Provides
    @Singleton
    fun provideVehicleRepository(vehicleDao: VehicleDao): VehicleRepository =
        VehicleRepoImpl(vehicleDao)

    @Provides
    fun provideGetVehiclesUseCase(repository: VehicleRepository): GetVehiclesUseCase =
        GetVehiclesUseCase(repository)

    @Provides
    fun provideAddVehicleUseCase(repository: VehicleRepository): AddVehicleUseCase =
        AddVehicleUseCase(repository)

    @Provides
    fun provideGetTotalVehicleCountUseCase(repository: VehicleRepository): GetTotalVehicleCountUseCase =
        GetTotalVehicleCountUseCase(repository)

    @Provides
    fun provideGetElectricVehicleCountUseCase(repository: VehicleRepository): GetElectricVehicleCountUseCase =
        GetElectricVehicleCountUseCase(repository)
}
