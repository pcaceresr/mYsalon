package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AgregarClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

        val btnToListadoClientes = findViewById<Button>(R.id.activity_agregar_cliente_btn_guardar)

        btnToListadoClientes.setOnClickListener {
            val irVistaListadoClientes = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientes.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientes)
        }

        val btnToListadoClientesMenu =
            findViewById<Button>(R.id.activity_agregar_clientes_btn_clientes)

        btnToListadoClientesMenu.setOnClickListener {
            val irVistaListadoClientesMenu = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesMenu)


        }

    }

}