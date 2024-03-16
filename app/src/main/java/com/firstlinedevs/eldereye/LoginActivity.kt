package com.firstlinedevs.eldereye

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.firstlinedevs.eldereye.ElderEyeApplication.Companion.prefs
import com.firstlinedevs.eldereye.recyclerpackage.CameraProvider

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initUI()
        initListeners()
    }

    private fun initUI(){
        if(!prefs.getName().equals("")){
            startActivity(Intent(this, PersonActivity::class.java))
            finish()
        }
    }

    private fun initListeners(){
        // Iniciar sesión
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etUser = findViewById<EditText>(R.id.etUser)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val errorLoginDialog = AlertDialog.Builder(this)
        errorLoginDialog.setTitle("Credenciales incorrectas")
        errorLoginDialog.setMessage("Ingrese las credenciales correctas, podrá encontrarlas abajo a la derecha")
        errorLoginDialog.setPositiveButton(android.R.string.yes) { dialog, which ->}

        btnLogin.setOnClickListener {
            if(etUser.text.toString().equals("user") && etPassword.text.toString().equals("123456")){
                prefs.saveName("user")
                startActivity(Intent(this, PersonActivity::class.java))
                finish()
            } else{
                errorLoginDialog.show()
            }
        }

        // Botón registro
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        val registerClickedDialog = AlertDialog.Builder(this)
        registerClickedDialog.setTitle("No implementado")
        registerClickedDialog.setMessage("Debido a que esta es una aplicación prototipo, esta opción no está disponible")
        registerClickedDialog.setPositiveButton("Aceptar") { dialog, which ->}

        tvRegister.setOnClickListener {
            registerClickedDialog.show()
        }
    }
}