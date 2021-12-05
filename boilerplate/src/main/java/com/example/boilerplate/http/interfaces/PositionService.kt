package com.example.boilerplate.http.interfaces

import com.example.boilerplate.models.PositionRes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PositionService {
    @GET("lookup")
    fun get(@Query("locations") locations: String): Call<PositionRes>
}