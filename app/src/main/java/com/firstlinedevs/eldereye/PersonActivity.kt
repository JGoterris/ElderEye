package com.firstlinedevs.eldereye

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.firstlinedevs.eldereye.ElderEyeApplication.Companion.prefs

class PersonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        this.setTitle(R.string.title_person)
        initUI()
        initListeners()
    }

    private fun initUI(){
        val cbAlgoritmo = findViewById<CheckBox>(R.id.cbAlgoritmo)
        cbAlgoritmo.isChecked = prefs.getAlgoritmo()
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

        val cbPulsaciones = findViewById<CheckBox>(R.id.cbAlgoritmo)
        cbPulsaciones.setOnClickListener {
            if(cbPulsaciones.isChecked){
                mostrarDialogoAlgoritmoActivado()
                prefs.saveAlgoritmo(true)
            } else{
                prefs.saveAlgoritmo(false)
            }
        }

        val btnLuz = findViewById<Button>(R.id.btnLuz)
        btnLuz.setOnClickListener {
            startActivity(Intent(this,LuzActivity::class.java))
        }

        val btnAsistente = findViewById<Button>(R.id.btnAsistente)
        btnAsistente.setOnClickListener {
            startActivity(Intent(this,AsistenteActivity::class.java))
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

    fun mostrarDialogoAlgoritmoActivado() {
        val algoritmoDialog = AlertDialog.Builder(this)
        algoritmoDialog.setTitle("Algoritmo automático activado")
        algoritmoDialog.setMessage("La inteligencia artificial para detectar anomalías cardiacas se ejecutará automáticamente cada 15 minutos.")
        algoritmoDialog.setPositiveButton(android.R.string.yes) { dialog, which ->}
        algoritmoDialog.show()
    }
}