package com.pkjain.demo.utils.pagination.datasource

import android.annotation.SuppressLint
import com.pkjain.demo.domain.managers.RestaurantManager
import com.pkjain.demo.domain.models.Restaurant
import com.pkjain.demo.utils.pagination.datasource._base.BaseDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Class that handles how to retrieve data for the recyclerview
 * @see BaseDataSource
 */
class RestaurentDataSource(var lat: Float, var lng: Float) : BaseDataSource<Restaurant>() {
    val manager: RestaurantManager = RestaurantManager()

    @SuppressLint("CheckResult")
    override fun loadInitialData(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Restaurant>) {
        // in the initial load, we will start at page 0, and retrieve the number of pages in the params.requestLoadSize
        manager.getRestaurantList(lat, lng,0, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(this::addDisposable)
                .subscribe(
                        { items -> submitInitialData(items, params, callback) },
                        { error -> submitInitialError(error) }
                )
    }

    @SuppressLint("CheckResult")
    override fun loadAditionalData(params: LoadParams<Int>, callback: LoadCallback<Int, Restaurant>) {
        manager.getRestaurantList(lat, lng, params.key, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(this::addDisposable)
                .subscribe(
                        { items -> submitData(items, params, callback) },
                        { error -> submitError(error) }
                )
    }
}