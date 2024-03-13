package com.firstlinedevs.eldereye

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        this.setTitle(R.string.title_person)
        initListeners()
    }

    private fun initListeners(){
        val btnLlamar = findViewById<Button>(R.id.btnLlamar)
        btnLlamar.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789")))
        }

        val btnIr = findViewById<Button>(R.id.btnIr)
        btnIr.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/2NnLQX4N4koXCL578")))
        }

        val opPCamera = findViewById<ImageView>(R.id.opPCamera)
        val cameraIntent = Intent(this,CameraActivity::class.java)
        cameraIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        opPCamera.setOnClickListener {
            startActivity(cameraIntent)
            finish()
        }

        val opPSettings = findViewById<ImageView>(R.id.opPSettings)
        val settingsIntent = Intent(this,SettingsActivity::class.java)
        settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        opPSettings.setOnClickListener {
            startActivity(settingsIntent)
            finish()
        }
    }
}