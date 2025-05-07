package com.example.td_personal.HomeScreen.Interface

import com.example.td_personal.HomeScreen.Data.DTO.CarrouselResponseDTO
import com.example.td_personal.HomeScreen.Data.Interface.CarrouselInterface
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

class CarrouselInterfaceImp : CarrouselInterface {
    private val api: CarrouselApi = Retrofit.Builder()
        .baseUrl("https://example.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CarrouselApi::class.java)

    override suspend fun getCarrouselData(): List<CarrouselResponseDTO> {
        return api.getCarrouselData()
    }
    interface CarrouselApi {
        @GET("carrousel")
        suspend fun getCarrouselData(): List<CarrouselResponseDTO>
    }
}