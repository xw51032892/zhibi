package com.example.tq.logic.model

data class RealtimeResponse(val status:String,val result:Result){
    data class Result(val realtime:Realtime)
    data class Realtime(val ari_quality:Air_Quality,val skyvon:String,val temperature:Float)
    data class Air_Quality(val api:Aqi)
    data class Aqi(val chn:Float)


}