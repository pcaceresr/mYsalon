package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mysalon.controllers.AuthController
import com.example.mysalon.utils.TilValidator
import com.example.mysalon.utils.showDatePickerDialog
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class AgregarClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cliente)

        val btnToListadoClientes = findViewById<Button>(R.id.activity_agregar_cliente_btn_guardar)

        val tilNombresApellidos =
            findViewById<TextInputLayout>(R.id.activity_agregar_cliente_til_nombres_apellidos)
        val tilTelefono = findViewById<TextInputLayout>(R.id.activity_agregar_cliente_til_telefono)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_agregar_cliente_til_email)
        val tilCumpleanos =
            findViewById<TextInputLayout>(R.id.activity_agregar_cliente_til_cumpleanos)


        btnToListadoClientes.setOnClickListener {


            val nombresApellidos = tilNombresApellidos.editText?.text
            val telefono = tilTelefono.editText?.text
            val email = tilEmail.editText?.text
            val cumpleanos = tilCumpleanos.editText?.text


            val nombresApellidosValid = TilValidator(tilNombresApellidos)
                .required()
                .validarNombre()
                .isValid()

            val telefonoValid = TilValidator(tilTelefono)
                .required()
                .validarTelefono()
                .isValid()

            val emailValid = TilValidator(tilEmail)
                .required()
                .email()
                .isValid()

            val cumpleanosValid = TilValidator(tilCumpleanos)
                .required()
                .dateBefore(Date())
                .isValid()


            if (nombresApellidosValid && telefonoValid && emailValid && cumpleanosValid) {
                AuthController(this).agregarCliente(
                    nombresApellidos, telefono, email, cumpleanos)
            } else {
                Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()
            }

            tilCumpleanos.editText?.setOnClickListener{ _ ->
                showDatePickerDialog(this, tilCumpleanos, Date())
            }


        }

        val btnToListadoClientesMenu =
            findViewById<Button>(R.id.activity_agregar_clientes_btn_clientes)

        btnToListadoClientesMenu.setOnClickListener {
            val irVistaListadoClientesMenu = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesMenu)
        }

        val btnToListadoCitasMenu = findViewById<Button>(R.id.activity_agregar_cliente_btn_citas)

        btnToListadoCitasMenu.setOnClickListener {
            val irVistaMainMenu = Intent(this, AgendaActivity::class.java)
            irVistaMainMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainMenu)
        }

        val btnToListadoAgregarCitaMenu =
            findViewById<Button>(R.id.activity_agregar_cliente_btn_agregar_cita)

        btnToListadoAgregarCitaMenu.setOnClickListener {
            val irVistaAgregarCitaMenu = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCitaMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCitaMenu)
        }

    }

}