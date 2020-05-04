package com.example.tq

import android.app.Application
import android.content.Context

class SunnyWeatherApplication:Application() {
    companion object{
        lateinit var context: Context
        const val TOkEN = "VNJu8qIUEnkD5XA1"
    }
    override fun onCreate() {
        super.onCreate()
        context = this
    }
}