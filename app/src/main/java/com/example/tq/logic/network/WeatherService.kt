package com.example.tq.logic.network

import com.example.tq.SunnyWeatherApplication
import com.example.tq.logic.model.DailyResponse
import com.example.tq.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part

interface WeatherService {
    @GET("v2.5/${SunnyWeatherApplication.TOkEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Part("lng") lng: String, @Part("lat") lat: String): Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOkEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Part("lng") lng: String, @Part("lat") lat: String): Call<DailyResponse>
}