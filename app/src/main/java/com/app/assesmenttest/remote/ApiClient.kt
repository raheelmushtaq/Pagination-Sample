package com.app.assesmenttest.remote

import com.app.assesmenttest.room.entity.Medicine
import retrofit2.http.GET

interface ApiClient {

    @GET("26dcba46-ec7c-4d0b-bf51-865fcdf28ead")
    suspend fun getMedicines(): ArrayList<Medicine>

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }
}