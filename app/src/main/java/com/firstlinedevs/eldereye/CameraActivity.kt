package com.firstlinedevs.eldereye

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstlinedevs.eldereye.recyclerpackage.CameraProvider
import com.firstlinedevs.eldereye.recyclerpackage.adapter.CameraAdapter


class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        setTitle("Cámaras")
        initRecyclerView()
        initListeners()
    }

    private fun initUI(){
        val metrics = DisplayMetrics()
        val width = metrics.widthPixels
        val height = metrics.heightPixels

    }

    private fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCamera)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CameraAdapter(CameraProvider.cameraList)
    }

    private fun initListeners(){
        val opCPerson = findViewById<ImageView>(R.id.opCPerson)
        val personIntent = Intent(this,PersonActivity::class.java)

        personIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        opCPerson.setOnClickListener {
            startActivity(personIntent)
            finish()
        }
    }
}