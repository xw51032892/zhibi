package com.example.tq.logic.model

import android.util.Log
import androidx.lifecycle.liveData
import com.example.tq.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    fun searchPlaces(query:String) = liveData(Dispatchers.IO){
            val result  = try{ val searchPlaces = SunnyWeatherNetwork.searchPlaces(query)
                if (searchPlaces.status=="ok") {
                    val place = searchPlaces.places
                    Log.w("333",place.get(0).toString());
                    Result.success(place);
                }else{
                    Result.failure(RuntimeException("response status is ${searchPlaces.status}"))
                }
            }catch (e:Exception){
                Result.failure<List<Place>>(e);
            }
        emit(result)
    }
}