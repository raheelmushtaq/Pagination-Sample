package com.app.assesmenttest.remote

import com.app.assesmenttest.room.entity.Cars
import com.app.assesmenttest.ui.presentation.feature_cars.domain.CarsApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET("all-vehicles-model/records")
    suspend fun getCars(

        @Query("limit") limit: Int, @Query("offset") offset: Int,
        @Query("order_by") order_by: String = "make",
//        @Query("select") select:String="make,model,drive,engid,fueltype,id,trany,vclass%2C%20year%2C%20ucity%2C%20pv2%2C%20pv4%2C%20barrels08%2C%20cylinders%2C%20displ%2C%20eng_dscr%2C%20createdon%2C%20modifiedon&\""
    ): CarsApiResponse

    companion object {
        const val BASE_URL = "https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/"
    }
}