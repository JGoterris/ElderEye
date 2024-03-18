package com.firstlinedevs.eldereye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LuzActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_luz)
        setTitle("Monitorizar Luz")
    }
}