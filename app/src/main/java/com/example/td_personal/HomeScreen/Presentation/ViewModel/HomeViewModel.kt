package com.example.td_personal.HomeScreen.Presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.td_personal.HomeScreen.Domain.Entity.CarrouselEntity
import com.example.td_personal.HomeScreen.Factory.CarrouselFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val _carrouselItems = MutableStateFlow<List<CarrouselEntity>>(emptyList())
    val carrouselItems: StateFlow<List<CarrouselEntity>> = _carrouselItems

    fun loadCarrouselItems() {
        viewModelScope.launch {
            // Crear una nueva instancia del UseCase desde el Factory
            val useCase = CarrouselFactory.createCarrouselUseCase()
            _carrouselItems.value = useCase()
        }
    }
}