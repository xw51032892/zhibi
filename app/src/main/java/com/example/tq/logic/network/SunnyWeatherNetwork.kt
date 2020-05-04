package com.example.tq.logic.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetwork {
    private val placeService = ServiceCreator.create(PlaceService::class.java)
    suspend fun searchPlaces(query:String) = placeService.searchPlaces(query).await()
    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine { continuation -> enqueue(object:Callback<T>{
            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t);
            }


            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    val body = response.body();
                    val toString = response.body().toString();
                    Log.v("222",toString);
                    if (body!=null) {
                        continuation.resume(body);
                    }else{
                        continuation.resumeWithException(RuntimeException("response body is null"))
                    }
                }
            }

        }
        )   }
    }
}