package com.example.td_personal.HomeScreen.Domain.Interface

import com.example.td_personal.HomeScreen.Domain.Entity.CarrouselEntity

interface CarrouselRepository {
    suspend fun getCarrouselItems(): List<CarrouselEntity>
}