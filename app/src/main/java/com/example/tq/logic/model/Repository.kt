package com.example.tq.logic.model

import android.util.Log
import androidx.lifecycle.liveData
import com.example.tq.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import java.lang.Exception
import java.lang.RuntimeException
import kotlin.coroutines.CoroutineContext

object Repository {
    private val SUCCEED:String = "ok"
    fun searchPlaces(query:String) = fire(Dispatchers.IO){
                 val searchPlaces = SunnyWeatherNetwork.searchPlaces(query)
                if (searchPlaces.status== SUCCEED) {
                    val place = searchPlaces.places
                    Result.success(place);
                }else{
                    Result.failure(RuntimeException("response status is ${searchPlaces.status}"))
                }
    }
    fun refreshWeather(lng:String,lat:String) = fire(Dispatchers.IO){
            coroutineScope{
                val deferredRealtime = async {
                    SunnyWeatherNetwork.getDailyWeather(lng,lat)
                }
                val deferredDaily = async {
                    SunnyWeatherNetwork.getRealtimeWeather(lng, lat)
                }
                val realtimeResponse = deferredDaily.await()
                val dailyResponse = deferredRealtime.await()
                if (realtimeResponse.status== SUCCEED&&dailyResponse.stauts == SUCCEED){
                    val weather = Weather(realtimeResponse.result.realtime,dailyResponse.result.daily)
                    Result.success(weather)
                }else{
                    Result.failure(RuntimeException("realtime response status is ${realtimeResponse.status} daily response status is ${dailyResponse.stauts}"))
                }
            }
    }
    private fun <T> fire(context:CoroutineContext,block:suspend()->Result<T>)= liveData <Result<T>>{
        val result = try {
            block()
        }catch (e:Exception){
            Result.failure<T>(e);
        }
        emit(result)
    }

}