package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mysalon.controllers.ClienteController
import com.example.mysalon.models.Cliente
import com.example.mysalon.utils.TilValidator
import com.example.mysalon.utils.showDatePickerDialog
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
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

            val nombresApellidos = tilNombresApellidos.editText?.text.toString()
            val telefono = tilTelefono.editText?.text.toString()
            val email = tilEmail.editText?.text.toString()
            val cumpleanos = tilCumpleanos.editText?.text.toString()


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
                val cliente = Cliente(
                    id = null,
                    nombresApellidos = nombresApellidos,
                    telefono = telefono,
                    email = email,
                    cumpleanos = SimpleDateFormat("yyy-MM-dd").parse(cumpleanos)
                )

               ClienteController(this).agregarCliente(cliente)

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