package com.example.td_personal.HomeScreen.Data.DataSource

import com.example.td_personal.HomeScreen.Data.DTO.CarrouselResponseDTO
import com.example.td_personal.HomeScreen.Data.Interface.CarrouselDataSource
import com.example.td_personal.HomeScreen.Data.Interface.CarrouselInterface

class CarrouselDataSourceImp(private val network: CarrouselInterface) : CarrouselDataSource {
    override suspend fun fetchCarrouselData(): List<CarrouselResponseDTO> {
        return network.getCarrouselData()
    }
}