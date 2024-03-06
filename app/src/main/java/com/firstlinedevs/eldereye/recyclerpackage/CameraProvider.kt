package com.firstlinedevs.eldereye.recyclerpackage

import com.firstlinedevs.eldereye.R

class CameraProvider {
    companion object{
        var cameraList: MutableList<CameraData> = mutableListOf(CameraData("Salón", R.drawable.camera1.toString()))
    }
}