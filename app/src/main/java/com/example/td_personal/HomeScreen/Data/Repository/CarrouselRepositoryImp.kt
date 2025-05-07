package com.example.td_personal.HomeScreen.Data.Repository
import com.example.td_personal.HomeScreen.Data.DataSource.CarrouselDataSourceImp
import com.example.td_personal.HomeScreen.Data.Interface.CarrouselDataSource
import com.example.td_personal.HomeScreen.Domain.Entity.CarrouselEntity
import com.example.td_personal.HomeScreen.Domain.Interface.CarrouselRepository

class CarrouselRepositoryImp(private val dataSource: CarrouselDataSource) : CarrouselRepository {
    override suspend fun getCarrouselItems(): List<CarrouselEntity> {
        return dataSource.fetchCarrouselData().map { dto ->
            CarrouselEntity(
                id = dto.id,
                title = dto.title,
                imageUrl = dto.imageUrl
            )
        }
    }
}