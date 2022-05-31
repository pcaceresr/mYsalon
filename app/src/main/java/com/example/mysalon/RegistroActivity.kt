package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        val btnToRegistrarse = findViewById<Button>(R.id.activity_registro_btn_volver)
        btnToRegistrarse.setOnClickListener {
            val irVistaIngreso = Intent(this, IngresoActivity::class.java)
            irVistaIngreso.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaIngreso)
        }



    }
}