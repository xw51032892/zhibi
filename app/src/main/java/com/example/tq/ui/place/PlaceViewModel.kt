package com.example.tq.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.tq.logic.model.Place
import com.example.tq.logic.model.Repository

class PlaceViewModel:ViewModel() {
    private val searchLiveData = MutableLiveData<String>();
    val placeList =ArrayList<Place>();

    val placeLiveData = Transformations.switchMap(searchLiveData){
        Repository.searchPlaces(it)
    }
    fun searchPlaces(query:String){
        searchLiveData.value = query;
    }

}