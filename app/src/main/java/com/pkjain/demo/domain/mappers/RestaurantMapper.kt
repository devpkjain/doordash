package com.pkjain.demo.domain.mappers

import com.pkjain.demo.data.models.RestaurantDto
import com.pkjain.demo.domain.models.Restaurant
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface RestaurantMapper {
    companion object {
        val Instance = Mappers.getMapper(RestaurantMapper::class.java)!!
    }
    fun map(restaurentDto: RestaurantDto?): Restaurant
    fun mapList(restaurent: List<RestaurantDto>?): List<Restaurant>
}