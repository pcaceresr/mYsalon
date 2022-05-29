package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EditarClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_cliente)

        val btnToListadoClientesGuardar = findViewById<Button>(R.id.activity_editar_cliente_btn_guardar)

        btnToListadoClientesGuardar.setOnClickListener {
            val irVistaListadoClientesGuardar = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesGuardar.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesGuardar)
        }

        val btnToListadoClientesDescartar = findViewById<Button>(R.id.activity_editar_cliente_btn_descartar)

        btnToListadoClientesDescartar.setOnClickListener {
            val irVistaListadoClientesDescartar = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesDescartar.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesDescartar)
        }

        val btnToListadoClientesMenu = findViewById<Button>(R.id.activity_editar_cliente_btn_clientes)

        btnToListadoClientesMenu.setOnClickListener {
            val irVistaListadoClientesMenu = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesMenu)
        }




    }
}