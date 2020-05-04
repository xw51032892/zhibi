package com.example.tq.logic.model

import com.google.gson.annotations.SerializedName

data class PlachResponse (val status:String,val places:List<Place>){

}

data class Place (val name:String,val location:Location,@SerializedName("formatted_address")val lat:String){

}
data class Location(val lng:String,val log:String){

}
