package com.firstlinedevs.eldereye

import android.app.Application

class ElderEyeApplication: Application() {
    companion object{
        lateinit var prefs:Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}