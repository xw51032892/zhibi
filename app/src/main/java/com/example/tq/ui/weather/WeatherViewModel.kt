package com.example.tq.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.tq.logic.model.Location
import com.example.tq.logic.model.Repository

class WeatherViewModel :ViewModel() {
    private val locationLiveData = MutableLiveData<Location>()

    var locationLng =""

    var locationLat = ""

    var placeName = ""

    val a  = Transformations.switchMap(locationLiveData){
        Repository.refreshWeather(it.lng,it.lat)
    }
     fun refreshWeather(lng:String,lat:String){
         locationLiveData.value = Location(lng, lat)
    }


}