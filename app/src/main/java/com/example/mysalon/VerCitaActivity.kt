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
            irVistaListadoClientesMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesMenu)
        }

        val btnToEditar = findViewById<Button>(R.id.activity_ver_cita_btn_editar)

        btnToEditar.setOnClickListener {
            val irVistaEditarCita = Intent(this, EditarCitaActivity::class.java)
            irVistaEditarCita.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaEditarCita)
        }

        val btnToEliminar = findViewById<Button>(R.id.activity_ver_cita_btn_eliminar)

        btnToEliminar.setOnClickListener {
            val irVistaMain = Intent(this, AgendaActivity::class.java)
            irVistaMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMain)
        }

        val btnToListadoCitasMenu = findViewById<Button>(R.id.activity_ver_cita_btn_citas)

        btnToListadoCitasMenu.setOnClickListener {
            val irVistaMainMenu = Intent(this, AgendaActivity::class.java)
            irVistaMainMenu .flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainMenu )
        }

        val btnToAgregarCitaMenu = findViewById<Button>(R.id.activity_ver_cita_btn_agregar_cita)

        btnToAgregarCitaMenu.setOnClickListener {
            val irVistaAgregarCitaMenu = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCitaMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCitaMenu)
        }

    }
}