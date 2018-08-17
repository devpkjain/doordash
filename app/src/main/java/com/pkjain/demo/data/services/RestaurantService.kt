package com.pkjain.demo.data.services

import com.pkjain.demo.data.endpoints.RestaurantApi
import com.pkjain.demo.data.models.RestaurantDto
import com.pkjain.demo.utils.networking.NetworkTools
import io.reactivex.Single
import retrofit2.Response

class RestaurantService {
    var api: RestaurantApi = NetworkTools.retrofit.create(RestaurantApi::class.java)

    fun getRestaurantList(lat: Float, lng: Float, offset: Int, limit: Int): Single<Response<List<RestaurantDto>>> {
        return api.getResaurantList(lat, lng, offset, limit)
    }

    fun getRestaurant(id: String): Single<Response<RestaurantDto>> {
        return api.getResaurent(id)
    }
}