package com.example.mysalon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mysalon.controllers.ClientesController
import com.example.mysalon.ui.ClientesAdapter

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

       /* val tvToVerCliente =
            findViewById<TextView>(activity_listado_clientes_tv_title_cliente1)

        tvToVerCliente.setOnClickListener {
            val intent1 = Intent(this, VerClienteActivity::class.java)
            startActivity(intent1)
        }*/

        val lvClientes = findViewById<ListView>(R.id.activity_clietes_lv_clientes)

        val obtnerCliente = ClientesController(this).obtenerCliente()
        val adapter = ClientesAdapter(this, obtnerCliente)

        lvClientes.adapter = adapter

        lvClientes.setOnItemClickListener { adapterView, view, i, l ->
            run {
                val clientes = obtnerCliente[i]
                Toast.makeText(view.context, clientes.title, Toast.LENGTH_SHORT).show()

            }
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