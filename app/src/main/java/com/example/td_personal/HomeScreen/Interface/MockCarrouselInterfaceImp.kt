package com.example.td_personal.HomeScreen.Interface

import com.example.td_personal.HomeScreen.Data.DTO.CarrouselResponseDTO
import com.example.td_personal.HomeScreen.Data.Interface.CarrouselInterface

class MockCarrouselInterfaceImp: CarrouselInterface {
    override suspend fun getCarrouselData(): List<CarrouselResponseDTO> {
        return listOf(
            CarrouselResponseDTO("1", "Mock Title 1", "https://example.com/image1.jpg"),
            CarrouselResponseDTO("2", "Mock Title 2", "https://example.com/image2.jpg")
        )
    }
}