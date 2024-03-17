package com.app.assesmenttest.room

import androidx.paging.PagingSource
import com.app.assesmenttest.room.entity.Cars

interface CarsRepository {

    suspend fun insertAll(list: List<Cars>)

    fun getAllCars(): PagingSource<Int, Cars>

    fun getTotalCarsCount(): Int

    suspend fun getCarsById(id: String): Cars?

    suspend fun clearAll()
}