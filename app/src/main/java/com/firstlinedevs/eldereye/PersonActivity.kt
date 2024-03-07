package com.firstlinedevs.eldereye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        this.setTitle(R.string.title_person)
        initListeners()
    }

    private fun initListeners(){
        val opPCamera = findViewById<ImageView>(R.id.opPCamera)
        val cameraIntent = Intent(this,CameraActivity::class.java)
        cameraIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        opPCamera.setOnClickListener {
            startActivity(cameraIntent)
            finish()
        }
    }
}