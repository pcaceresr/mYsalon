package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class VerCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_cita)

        val btnToListadoClientesMenu = findViewById<Button>(R.id.activity_ver_cita_btn_clientes)

        btnToListadoClientesMenu.setOnClickListener {
            val irVistaListadoClientesMenu = Intent(this, ListadoClientesActivity::class.java)
            startActivity(irVistaListadoClientesMenu)
        }


    }
}