package com.firstlinedevs.eldereye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog

class AsistenteActivity : AppCompatActivity() {

    private val options = arrayOf("Cocina", "Salón", "Dormitorio")
    private var defaultPosition = 0

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

        val btnSeleccion = findViewById<Button>(R.id.btnSeleccion)
        btnSeleccion.setOnClickListener {
            mostrarSeleccionAsistente()
        }
    }

    private fun mostrarDialogoMicrofono() {
        val microDialog = AlertDialog.Builder(this)
        microDialog.setTitle("Funcionalidad sin implementación")
        microDialog.setMessage("En la aplicación real, al mantener presionado el icono del micrófono, podrás transmitir un mensaje de voz a través de los diferentes asistentes que tengas configurados (Google Home, Alexas...)")
        microDialog.setPositiveButton(android.R.string.yes) { dialog, which ->}
        microDialog.show()
    }

    private fun mostrarSeleccionAsistente(){
        val btnSeleccion = findViewById<Button>(R.id.btnSeleccion)
        val sbVolumen = findViewById<SeekBar>(R.id.sbVolumen)

        val builderSingle = AlertDialog.Builder(this)
        builderSingle.setTitle("Seleccionar asistente")
        builderSingle.setPositiveButton(android.R.string.yes) { dialog, which -> dialog.dismiss()}
        builderSingle.setSingleChoiceItems(options,defaultPosition){dialog, which ->
            defaultPosition = which
            btnSeleccion.text = options[which]
            when(which){
                0 -> sbVolumen.progress = 50
                1 -> sbVolumen.progress = 70
                2 -> sbVolumen.progress = 30
            }
        }
        builderSingle.show()
    }
}