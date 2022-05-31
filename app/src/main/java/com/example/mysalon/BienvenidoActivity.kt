package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BienvenidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

val btnToIngreso = findViewById<Button>(R.id.activity_bienvenido_btn_ingresar)

        btnToIngreso.setOnClickListener {
            val irVistaIngreso = Intent(this, IngresoActivity::class.java)
            irVistaIngreso.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaIngreso)
        }

        val btnToRegistro = findViewById<Button>(R.id.activity_bienvenido_btn_registo)
        btnToRegistro.setOnClickListener {
            val irVistaIngresoRegistro = Intent(this, RegistroActivity::class.java)
            irVistaIngresoRegistro.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaIngresoRegistro)
        }

    }
}