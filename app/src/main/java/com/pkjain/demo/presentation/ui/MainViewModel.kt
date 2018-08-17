package com.pkjain.demo.presentation.ui

import com.pkjain.demo.domain.models.Restaurant
import com.pkjain.demo.presentation.ui.base.BasePaginationViewModel
import com.pkjain.demo.utils.pagination.factory.RestaurentDataSourceFactory

class MainViewModel() :
        BasePaginationViewModel<RestaurentDataSourceFactory, Restaurant>() {
    var lati: Float = 37.422740f
    var long: Float = -122.139956f

    init {
        dataSourceFactory = RestaurentDataSourceFactory(getListener(), lati, long)
    }

    override fun getPageSize(): Int = 10

    /**
     * Handles a new user search
     */
    fun newSearch(lat: Float = lati, lng: Float = long) {
        dataSourceFactory.lat = lat
        dataSourceFactory.lng = lng
        clearData()
    }
}