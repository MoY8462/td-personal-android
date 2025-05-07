package com.example.td_personal.HomeScreen.Factory

import com.example.td_personal.HomeScreen.Data.DataSource.CarrouselDataSourceImp
import com.example.td_personal.HomeScreen.Data.Interface.CarrouselDataSource
import com.example.td_personal.HomeScreen.Data.Repository.CarrouselRepositoryImp
import com.example.td_personal.HomeScreen.Domain.Interface.CarrouselRepository
import com.example.td_personal.HomeScreen.Domain.Interface.CarrouselUseCase
import com.example.td_personal.HomeScreen.Domain.UseCase.CarrouselUseCaseImp
import com.example.td_personal.HomeScreen.Interface.CarrouselInterfaceImp
import com.example.td_personal.HomeScreen.Interface.MockCarrouselInterfaceImp

object CarrouselFactory {
    fun createCarrouselUseCase(): CarrouselUseCase {
        // Crear la implementación del Network
        val network = MockCarrouselInterfaceImp()

        // Crear el DataSource
        val dataSource: CarrouselDataSource = CarrouselDataSourceImp(network)

        // Crear el Repository
        val repository: CarrouselRepository = CarrouselRepositoryImp(dataSource)

        // Crear y devolver el UseCase
        return CarrouselUseCaseImp(repository)
    }
}