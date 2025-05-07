package com.example.td_personal.HomeScreen.Data.Interface

import com.example.td_personal.HomeScreen.Data.DTO.CarrouselResponseDTO

interface CarrouselDataSource {
    suspend fun fetchCarrouselData(): List<CarrouselResponseDTO>

}