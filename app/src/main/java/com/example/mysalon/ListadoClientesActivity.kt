package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mysalon.R.id.activity_listado_clientes_tv_title_cliente1

class ListadoClientesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_clientes)

        val btnToAgregarCliente =
            findViewById<Button>(R.id.activity_listado_clientes_btn_agregar_nuevo_cliente)

        btnToAgregarCliente.setOnClickListener {
            val intent = Intent(this, AgregarClienteActivity::class.java)
            startActivity(intent)
        }

        val tvToVerCliente =
            findViewById<TextView>(activity_listado_clientes_tv_title_cliente1)

        tvToVerCliente.setOnClickListener {
            val intent1 = Intent(this, VerClienteActivity::class.java)
            startActivity(intent1)
        }


        val btnToListadoAgregarCitaMenu = findViewById<Button>(R.id.activity_listado_clientes_btn_agregar_cita)

        btnToListadoAgregarCitaMenu.setOnClickListener {
            val irVistaAgregarCitaMenu = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCitaMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCitaMenu)
        }

        val btnToListadoCitasMenu = findViewById<Button>(R.id.activity_listado_clientes_btn_citas)

        btnToListadoCitasMenu.setOnClickListener {
            val irVistaMainMenu = Intent(this, AgendaActivity::class.java)
            irVistaMainMenu .flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainMenu )
        }
    }
}