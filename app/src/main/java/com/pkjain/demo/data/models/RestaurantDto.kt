package com.pkjain.demo.data.models

/**
 *
 */
data class RestaurantDto constructor(val is_time_surging: Boolean? = false,
                                     val max_order_size: String? = null,
                                     val delivery_fee: Int? = null,
                                     val max_composite_score: Int? = null,
                                     val id: Int? = null,
                                     val average_rating: Float? = null,
                                     val name: String? = null,
                                     val description: String? = null,
                                     val cover_img_url: String? = null,
                                     val status: String? = null
)