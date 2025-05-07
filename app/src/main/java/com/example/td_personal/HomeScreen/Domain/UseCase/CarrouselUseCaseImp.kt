package com.example.td_personal.HomeScreen.Domain.UseCase

import com.example.td_personal.HomeScreen.Domain.Entity.CarrouselEntity
import com.example.td_personal.HomeScreen.Domain.Interface.CarrouselRepository
import com.example.td_personal.HomeScreen.Domain.Interface.CarrouselUseCase

class CarrouselUseCaseImp(private val repository: CarrouselRepository) : CarrouselUseCase {
    override suspend fun invoke(): List<CarrouselEntity> {
        return repository.getCarrouselItems()
    }
}