package com.firstlinedevs.eldereye

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView

class CocinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocina)
        setTitle("Cámara Cocina")
        startVideo()
        initListeners()
    }

    private fun startVideo(){
        val vvCocina = findViewById<VideoView>(R.id.vvCocina)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.cocinaejemplo
        val uri = Uri.parse(videoPath)
        vvCocina.setVideoURI(uri)
        vvCocina.start()
    }

    private fun initListeners(){
        val vvCocina = findViewById<VideoView>(R.id.vvCocina)
        var imagePause = true
        val ivStart = findViewById<ImageView>(R.id.ivStart)
        ivStart.setOnClickListener {
            if(imagePause) {
                vvCocina.pause()
                ivStart.setImageResource(R.drawable.start)
                imagePause = false
            } else{
                vvCocina.start()
                ivStart.setImageResource(R.drawable.pause)
                imagePause = true
            }
        }

        val ivPrevious = findViewById<ImageView>(R.id.ivPrevious)
        ivPrevious.setOnClickListener {
            ivStart.setImageResource(R.drawable.pause)
            imagePause = true
            startVideo()
        }
    }
}