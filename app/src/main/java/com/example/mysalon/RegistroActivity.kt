package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        val btnToRegistrarse = findViewById<Button>(R.id.activity_registro_btn_volver)
        val tilNombre =findViewById<TextInputLayout>(R.id.activity_registro_til_nombre)
        val tilApellidos =findViewById<TextInputLayout>(R.id.activity_registro_til_apellidos)
        val tilCumpleanos =findViewById<TextInputLayout>(R.id.activity_registro_til_nombre_salon)
        val tilEmail =findViewById<TextInputLayout>(R.id.activity_registro_til_email)
        val tilPassword =findViewById<TextInputLayout>(R.id.activity_registro_til_password)


        btnToRegistrarse.setOnClickListener {
            val irVistaIngreso = Intent(this, IngresoActivity::class.java)
            irVistaIngreso.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaIngreso)
        }



    }
}