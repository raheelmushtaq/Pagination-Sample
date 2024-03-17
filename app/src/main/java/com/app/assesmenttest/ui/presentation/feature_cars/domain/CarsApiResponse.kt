package com.app.assesmenttest.ui.presentation.feature_cars.domain

import com.app.assesmenttest.room.entity.Cars

data class CarsApiResponse(
    val total_count: Int,
    val results: ArrayList<Cars> = ArrayList()
) {
}