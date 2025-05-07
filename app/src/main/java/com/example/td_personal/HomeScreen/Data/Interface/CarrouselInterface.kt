package com.example.td_personal.HomeScreen.Data.Interface

import com.example.td_personal.HomeScreen.Data.DTO.CarrouselResponseDTO
import retrofit2.Call
import retrofit2.http.GET

interface CarrouselInterface {
//    @GET("photos")
    suspend fun getCarrouselData(): List<CarrouselResponseDTO>
}