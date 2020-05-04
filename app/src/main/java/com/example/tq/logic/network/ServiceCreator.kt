package com.example.tq.logic.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceCreator {
    private const val BASE_Url="https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_Url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> create(service:Class<T>):T = retrofit.create(service)

    inline fun <reified T> create():T= create(T::class.java)


}