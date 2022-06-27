package com.example.mysalon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mysalon.controllers.ClienteController
import com.example.mysalon.models.Cliente
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
        //consulto a la BD por los clientes del usuario conectado
        val clientes = ClienteController(this).obtenerClientes()

        //envio el listado de clientes al adaptador
        val adapter = ClientesAdapter(this, clientes)

        val lvClientes = findViewById<ListView>(R.id.activity_clietes_lv_clientes)
        lvClientes.adapter = adapter

        //cuando se hace clic en un registro, se va a la vista verCliente
        lvClientes.setOnItemClickListener { adapterView, view, i, l ->
            run {
                val clienteSeleccionado = clientes[i]
                //mostrar pantalla
                val irVistaVerCliente = Intent(this, VerClienteActivity::class.java)
                irVistaVerCliente.putExtra("CLIENTE_SELECCIONADO", clienteSeleccionado)
                irVistaVerCliente.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(irVistaVerCliente)
            }
        }


        val btnToListadoAgregarCitaMenu =
            findViewById<Button>(R.id.activity_listado_clientes_btn_agregar_cita)

        btnToListadoAgregarCitaMenu.setOnClickListener {
            val irVistaAgregarCitaMenu = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCitaMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCitaMenu)
        }

        val btnToListadoCitasMenu = findViewById<Button>(R.id.activity_listado_clientes_btn_citas)

        btnToListadoCitasMenu.setOnClickListener {
            val irVistaMainMenu = Intent(this, AgendaActivity::class.java)
            irVistaMainMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainMenu)
        }
    }
}