package com.pkjain.demo.domain.managers

import com.pkjain.demo.data.services.RestaurantService
import com.pkjain.demo.domain.mappers.RestaurantMapper
import com.pkjain.demo.domain.models.Restaurant
import io.reactivex.Single

/**
 * Class that connects the Data layer to Presentation, where the API objects are manipulated and observed by
 * the Views (Activity, Fragment or View)
 */
class RestaurantManager {
    var restaurantService: RestaurantService = RestaurantService()

    fun getRestaurantList(lat: Float, lng: Float, offset: Int, limit: Int): Single<List<Restaurant>> {
        return restaurantService.getRestaurantList(lat, lng, offset, limit)
                .onErrorResumeNext({ throwable -> Single.error(throwable) })
                .flatMap { response ->
                    if (!response.isSuccessful) {
                        Single.error(Throwable(response.code().toString()))
                    } else Single.just(response)
                }
                .map { response -> response.body() }
                .map { list -> RestaurantMapper.Instance.mapList(list) }
    }

    fun getRestaurant(id: String): Single<Restaurant> {
        return restaurantService.getRestaurant(id)
                .onErrorResumeNext({ throwable -> Single.error(throwable) })
                .flatMap { response ->
                    if (!response.isSuccessful) {
                        Single.error(Throwable(response.code().toString()))
                    } else Single.just(response)
                }
                .map { response -> response.body() }
                .map { body -> RestaurantMapper.Instance.map(body) }
    }
}