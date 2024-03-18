package com.firstlinedevs.eldereye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class AsistenteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asistente)
        setTitle("Asistentes")
        initListeners()
    }

    private fun initListeners(){
        val ivMicro = findViewById<ImageView>(R.id.ivMicro)
        ivMicro.setOnClickListener {
            mostrarDialogoMicrofono()
        }
    }

    fun mostrarDialogoMicrofono() {
        val microDialog = AlertDialog.Builder(this)
        microDialog.setTitle("Funcionalidad sin implementación")
        microDialog.setMessage("En la aplicación real, al mantener presionado el icono del micrófono, podrás transmitir un mensaje de voz a través de los diferentes asistentes que tengas configurados (Google Home, Alexas...)")
        microDialog.setPositiveButton(android.R.string.yes) { dialog, which ->}
        microDialog.show()
    }
}