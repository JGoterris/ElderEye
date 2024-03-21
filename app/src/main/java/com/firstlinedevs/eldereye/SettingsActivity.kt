package com.firstlinedevs.eldereye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.firstlinedevs.eldereye.ElderEyeApplication.Companion.prefs

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setTitle("Ajustes")

        initListeners()
    }

    private fun initListeners(){
        val clPerfil = findViewById<ConstraintLayout>(R.id.clPerfil)
        clPerfil.setOnClickListener{
            mostrarDialogoNoImplementado("No implementado","En esta opción se podrían configurar los perfiles de la persona mayor y de su supervisor (el cliente de esta app).")
        }

        val clDispositivos = findViewById<ConstraintLayout>(R.id.clDispositivos)
        clDispositivos.setOnClickListener{
            mostrarDialogoNoImplementado("No implementado","En esta opción se podrían configurar las cámaras y los dispositivos de medición (AmazFit, Fitbit...).")
        }

        val clAsistentes = findViewById<ConstraintLayout>(R.id.clAsistentes)
        clAsistentes.setOnClickListener{
            mostrarDialogoNoImplementado("No implementado","En esta opción se podrían configurar los distintos asistentes como Alexas, Google Homes y similares.")
        }

        val clCerrar = findViewById<ConstraintLayout>(R.id.clCerrar)
        clCerrar.setOnClickListener{
            cerrarSesion()
        }

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

    private fun mostrarDialogoNoImplementado(titulo: String, mensaje: String) {
        val dialogo = AlertDialog.Builder(this)
        dialogo.setTitle(titulo)
        dialogo.setMessage(mensaje)
        dialogo.setPositiveButton(android.R.string.yes) { dialog, which ->}
        dialogo.show()
    }

    private fun cerrarSesion(){
        val dialogoCerrar = AlertDialog.Builder(this)
        dialogoCerrar.setTitle("Cerrar Sesión")
        dialogoCerrar.setMessage("¿Seguro que quiere cerrar sesión?")
        dialogoCerrar.setPositiveButton(android.R.string.yes) { dialog, which ->
            prefs.wipe()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()

        }
        dialogoCerrar.setNegativeButton(android.R.string.no) { dialog, which -> dialog.dismiss()}
        dialogoCerrar.show()
    }
}