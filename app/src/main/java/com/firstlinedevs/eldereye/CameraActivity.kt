package com.firstlinedevs.eldereye

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstlinedevs.eldereye.recyclerpackage.CameraProvider
import com.firstlinedevs.eldereye.recyclerpackage.adapter.CameraAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


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

        val fabAddCamera = findViewById<FloatingActionButton>(R.id.fabAddCamera)
        fabAddCamera.setOnClickListener {
            mostrarDialogo()
        }
    }

    fun mostrarDialogo() {
        val context = this
        val builder = AlertDialog.Builder(context)

        val view = layoutInflater.inflate(R.layout.add_camera, null)
        val etCameraName = view.findViewById<EditText>(R.id.etCameraName)
        builder.setView(view)

        builder.setPositiveButton(android.R.string.ok) { dialog, p1 ->

        }

        builder.setNegativeButton(android.R.string.cancel) { dialog, p1 ->
            dialog.cancel()
        }

        builder.show()
    }
}