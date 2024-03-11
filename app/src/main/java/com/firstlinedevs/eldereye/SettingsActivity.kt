package com.firstlinedevs.eldereye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setTitle("Ajustes")

        initListeners()
    }

    private fun initListeners(){
        val opSCamera = findViewById<ImageView>(R.id.opSCamera)
        val cameraIntent = Intent(this,CameraActivity::class.java)
        cameraIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        opSCamera.setOnClickListener {
            startActivity(cameraIntent)
            finish()
        }

        val opSPerson = findViewById<ImageView>(R.id.opSPerson)
        val personIntent = Intent(this,PersonActivity::class.java)
        personIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        opSPerson.setOnClickListener {
            startActivity(personIntent)
            finish()
        }
    }
}