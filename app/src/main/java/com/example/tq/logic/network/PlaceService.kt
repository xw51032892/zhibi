package com.example.tq.logic.network

import com.example.tq.SunnyWeatherApplication
import com.example.tq.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${SunnyWeatherApplication.TOkEN}&lang=zh_CN")
    fun searchPlaces(@Query("query")query:String):Call<PlaceResponse>
}