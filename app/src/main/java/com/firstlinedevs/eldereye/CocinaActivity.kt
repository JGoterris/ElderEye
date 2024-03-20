package com.firstlinedevs.eldereye

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class CocinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocina)

        startVideo()
    }

    private fun startVideo(){
        val vvCocina = findViewById<VideoView>(R.id.vvCocina)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.cocinaejemplo
        val uri = Uri.parse(videoPath)
        vvCocina.setVideoURI(uri)
        vvCocina.start()
    }
}