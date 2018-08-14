package com.pkjain.demo.data.endpoints

import com.pkjain.demo.data.models.RestaurantDto
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val PREFIX = "/v2/restaurant/"

interface RestaurantApi {

    @GET(PREFIX)
    fun getResaurantList(
            @Query("lat") lat: Float,
            @Query("lng") lng: Float,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int
    ): Single<Response<List<RestaurantDto>>>

    @GET(PREFIX + "{resId}")
    fun getResaurent(@Path("resId") resId: String
    ): Single<Response<RestaurantDto>>
}