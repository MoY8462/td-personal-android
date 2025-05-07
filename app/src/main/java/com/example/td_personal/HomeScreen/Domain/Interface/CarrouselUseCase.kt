package com.example.td_personal.HomeScreen.Domain.Interface

import com.example.td_personal.HomeScreen.Domain.Entity.CarrouselEntity

interface CarrouselUseCase {
    suspend operator fun invoke(): List<CarrouselEntity>
}