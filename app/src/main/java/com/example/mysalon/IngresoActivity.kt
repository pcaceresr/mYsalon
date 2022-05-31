package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IngresoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        val btnToIngresar = findViewById<Button>(R.id.activity_ingreso_btn_ingresar1)
        btnToIngresar.setOnClickListener {
            val irVistaMain = Intent(this, MainActivity::class.java)
            irVistaMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMain)
        }

        val btnToVolver = findViewById<Button>(R.id.activity_ingreso_btn_volver)
        btnToVolver.setOnClickListener {
            val irVistaBienvenido = Intent(this, BienvenidoActivity::class.java)
            irVistaBienvenido.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaBienvenido)
        }



    }
}