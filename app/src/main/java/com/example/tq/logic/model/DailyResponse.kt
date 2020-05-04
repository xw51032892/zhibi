package com.example.tq.logic.model

import com.google.gson.annotations.SerializedName
import java.sql.Date
import java.util.*

data class DailyResponse (val stauts:String,val result:Result){
    data class Result(val daily:Daily){

    }
    data class Daily(val temList: List<Temperature>,val skyList: List<Skycon>,@SerializedName("life_index")val lifeIndexList:List<LifeIndex>){

    }
    data class Temperature(val max:Float,val min:Float){

    }
    data class Skycon(val value:String,val date:Date){

    }

    data class LifeIndex(val coldRisk:List<LifeDescription>,val carWashing:List<LifeDescription>,val ultravioler:List<LifeDescription>,val dressingg:List<LifeDescription>){

    }
    data class LifeDescription(val desc:String){

    }



}