package com.pkjain.demo.domain.models

/**
 * Restaurant Model
 */
data class Restaurant constructor(var is_time_surging: Boolean? = false,
                                  var max_order_size: String? = null,
                                  var delivery_fee: Int? = null,
                                  var max_composite_score: Int? = null,
                                  var id: Int,
                                  var average_rating: Float?,
                                  var name: String?,
                                  var description: String?,
                                  var cover_img_url: String?,
                                  var status: String?
){
    constructor() : this(false, null, 0, 0, 0, null, null,
            null, null, null)
}