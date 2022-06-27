package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mysalon.controllers.ClienteController
import com.example.mysalon.models.Cliente
import com.google.android.material.textfield.TextInputLayout

class VerClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_cliente)

        val clienteSeleccionado = intent.getSerializableExtra("CLIENTE_SELECCIONADO") as Cliente
        //TODO: enlazar a la pantalla con un adapter

        val tilNombresApellidos =
            findViewById<TextInputLayout>(R.id.activity_ver_cliente_til_nombres_apellidos)
        val tilTelefono = findViewById<TextInputLayout>(R.id.activity_ver_cliente_til_telefono)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_ver_cliente_til_email)
        val tilCumpleanos = findViewById<TextInputLayout>(R.id.activity_editar_cliente_til_cumpleanos)

        tilNombresApellidos.getEditText()?.setText(clienteSeleccionado.nombresApellidos);



        val btnToListadoClientesEditar = findViewById<Button>(R.id.activity_ver_cliente_btn_editar)

        btnToListadoClientesEditar.setOnClickListener {
            val irVistaListadoClientesEditar = Intent(this, EditarClienteActivity::class.java)
            irVistaListadoClientesEditar.putExtra("CLIENTE_SELECCIONADO", clienteSeleccionado)
            startActivity(irVistaListadoClientesEditar)
        }

        val btnToListadoClientesEliminar = findViewById<Button>(R.id.activity_ver_cliente_btn_eliminar)

        btnToListadoClientesEliminar.setOnClickListener {
            //eliminar desde la BD
            ClienteController(this).eliminarCliente(clienteSeleccionado);

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

        val btnToListadoCitasMenu = findViewById<Button>(R.id.activity_ver_cliente_btn_citas)

        btnToListadoCitasMenu.setOnClickListener {
            val irVistaMainMenu = Intent(this, AgendaActivity::class.java)
            irVistaMainMenu .flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainMenu )
        }

        val btnToListadoAgregarCitaMenu = findViewById<Button>(R.id.activity_ver_cliente_btn_agregar_cita)

        btnToListadoAgregarCitaMenu.setOnClickListener {
            val irVistaAgregarCitaMenu = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCitaMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCitaMenu)
        }


    }
}