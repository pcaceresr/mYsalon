package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AgendaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val btnToAgregarCita = findViewById<Button>(R.id.activity_agenda_btn_agregar)
        btnToAgregarCita.setOnClickListener {
            val irVistaAgregarCita = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCita.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCita)
        }

        val btnToClientes = findViewById<Button>(R.id.activity_agenda_btn_clientes)
        btnToClientes.setOnClickListener {
            val irVistaListadoClientes = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientes.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientes)
        }

        val tvToVerCita = findViewById<TextView>(R.id.activity_agenda_Citas_tv_Cliente1)
        tvToVerCita.setOnClickListener {
            val irVistaVerCita = Intent(this, VerCitaActivity::class.java)
            irVistaVerCita.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaVerCita)
        }

    }
}