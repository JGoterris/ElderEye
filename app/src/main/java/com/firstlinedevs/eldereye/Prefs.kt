package com.firstlinedevs.eldereye

import android.content.Context


class Prefs (val context: Context) {

    val SHARED_NAME = "ElderEye_db"
    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    val SHARED_USER_NAME = "username"
    fun saveName(name:String){
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun getName():String{
        return storage.getString(SHARED_USER_NAME, "")!! // El valor por defecto es el que devuelve si nunca se ha guardado nada (las dos !! es por si es nulo)
    }

    val SHARED_ALGORITMO = "algoritmo"
    fun saveAlgoritmo(boolean: Boolean){
        storage.edit().putBoolean(SHARED_ALGORITMO, boolean).apply()
    }

    fun getAlgoritmo():Boolean{
        return storage.getBoolean(SHARED_ALGORITMO, false) // El valor por defecto es el que devuelve si nunca se ha guardado nada (las dos !! es por si es nulo)
    }
}