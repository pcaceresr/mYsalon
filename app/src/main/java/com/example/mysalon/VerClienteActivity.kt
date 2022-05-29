package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class VerClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_cliente)

        val btnToListadoClientesEditar = findViewById<Button>(R.id.activity_ver_cliente_btn_editar)

        btnToListadoClientesEditar.setOnClickListener {
            val irVistaListadoClientesEditar = Intent(this, EditarClienteActivity::class.java)
            startActivity(irVistaListadoClientesEditar)
        }

        val btnToListadoClientesEliminar = findViewById<Button>(R.id.activity_ver_cliente_btn_eliminar)

        btnToListadoClientesEliminar.setOnClickListener {
            val irVistaListadoClientesEliminar = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesEliminar.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesEliminar)
        }

        val btnToListadoClientesMenu = findViewById<Button>(R.id.activity_ver_cliente_btn_clientes)

        btnToListadoClientesMenu.setOnClickListener {
            val irVistaListadoClientesMenu = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesMenu)
        }


    }
}