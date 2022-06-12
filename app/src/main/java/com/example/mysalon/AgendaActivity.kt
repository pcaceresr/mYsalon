package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.mysalon.controllers.AgendaController
import com.example.mysalon.ui.AgendaAdapter

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

        /*val tvToVerCita = findViewById<TextView>(R.id.activity_agenda_Citas_tv_Cliente1)
        tvToVerCita.setOnClickListener {
            val irVistaVerCita = Intent(this, VerCitaActivity::class.java)
            irVistaVerCita.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            star*/

        val lvAgenda = findViewById<ListView>(R.id.activity_agenda_lv_agenda)

        val allTask = AgendaController(this).getAll()
        val adapter = AgendaAdapter(this, allTask)

        lvAgenda.adapter = adapter

        lvAgenda.setOnItemClickListener { adapterView, view, i, l ->
            run {
            val agenda = allTask[i]
            Toast.makeText(view.context, agenda.title,Toast.LENGTH_SHORT).show()

        }}

    }
}