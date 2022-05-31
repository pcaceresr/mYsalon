package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AgregarCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cita)

        val btnToGuardar = findViewById<Button>(R.id.activity_agregar_cita_btn_guardar)
        btnToGuardar.setOnClickListener {
            val irVistaMain = Intent(this, MainActivity::class.java)
            irVistaMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMain)
        }

        val btnToCitas = findViewById<Button>(R.id.activity_agregar_cita_btn_citas)
        btnToGuardar.setOnClickListener {
            val irVistaMainCitas = Intent(this, MainActivity::class.java)
            irVistaMainCitas.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainCitas)
        }

        val btnToClientes = findViewById<Button>(R.id.activity_agregar_cita_btn_clientes)
        btnToClientes.setOnClickListener {
            val irVistaClientes = Intent(this, ListadoClientesActivity::class.java)
            irVistaClientes.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaClientes)
        }

    }
}