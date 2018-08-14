package com.pkjain.demo.utils.pagination.factory

import android.arch.paging.DataSource
import com.pkjain.demo.domain.models.Restaurant
import com.pkjain.demo.utils.pagination.datasource.RestaurentDataSource
import com.pkjain.demo.utils.pagination.datasource._base.OnDataSourceLoading

/**
 * Factory class that handles the creation of DataSources
 */
class RestaurentDataSourceFactory(var loading: OnDataSourceLoading,
                                  var lat: Float,
                                  var lng: Float
) : DataSource.Factory<Int, Restaurant>() {
    lateinit var source: RestaurentDataSource

    override fun create(): DataSource<Int, Restaurant>? {
        if (::source.isInitialized && source != null) source.invalidate()
        source = RestaurentDataSource(lat, lng)
        source.onDataSourceLoading = loading
        return source
    }
}