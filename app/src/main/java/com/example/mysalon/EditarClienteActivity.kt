package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mysalon.controllers.ClienteController
import com.example.mysalon.models.Cliente
import com.example.mysalon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.time.LocalDate

class EditarClienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_cliente)

        val clienteSeleccionado = intent.getSerializableExtra("CLIENTE_SELECCIONADO") as Cliente

        val btnToListadoClientesGuardar = findViewById<Button>(R.id.activity_editar_cliente_btn_guardar)
        val tilNombresApellidos = findViewById<TextInputLayout>(R.id.activity_editar_cliente_til_nombres_apellidos)
        val tilTelefono = findViewById<TextInputLayout>(R.id.activity_editar_cliente_til_telefono)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_editar_cliente_til_email)
        val tilCumpleanos = findViewById<TextInputLayout>(R.id.activity_editar_cliente_til_cumpleanos)

        tilNombresApellidos.getEditText()?.setText(clienteSeleccionado.nombresApellidos)
        tilTelefono.getEditText()?.setText(clienteSeleccionado.telefono)
        tilEmail.getEditText()?.setText(clienteSeleccionado.email)

        val mes = clienteSeleccionado.cumpleanos.month.toString()
        val anio = clienteSeleccionado.cumpleanos.year.toString()
        val dia = clienteSeleccionado.cumpleanos.day.toString()
        var fecha = SimpleDateFormat("yyyy-MM-dd").parse(anio+"-"+mes+"-"+dia)
        println(fecha)

      //tilCumpleanos.getEditText()?.setText(SimpleDateFormat("yyyy-MM-dd").parse(anio+"-"+mes+"-"+dia))

        btnToListadoClientesGuardar.setOnClickListener {

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
                .isValid()

            if (nombresApellidosValid && telefonoValid && emailValid && cumpleanosValid) {

                //actualizar a la BD
                val clienteEditado = Cliente(
                    id = clienteSeleccionado.id,
                    nombresApellidos = nombresApellidos,
                    telefono = telefono,
                    email = email,
                    cumpleanos = SimpleDateFormat("yyy-MM-dd").parse(cumpleanos)
                )

                ClienteController(this).editarCliente(clienteEditado);

                val irVistaListadoClientesGuardar =
                    Intent(this, ListadoClientesActivity::class.java)
                irVistaListadoClientesGuardar.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(irVistaListadoClientesGuardar)

            } else {
                Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()
            }


        }

        val btnToListadoClientesDescartar =
            findViewById<Button>(R.id.activity_editar_cliente_btn_descartar)

        btnToListadoClientesDescartar.setOnClickListener {
            val irVistaVerCliente = Intent(this, VerClienteActivity::class.java)
            irVistaVerCliente.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaVerCliente)
        }

        val btnToListadoClientesMenu =
            findViewById<Button>(R.id.activity_editar_cliente_btn_clientes)

        btnToListadoClientesMenu.setOnClickListener {
            val irVistaListadoClientesMenu = Intent(this, ListadoClientesActivity::class.java)
            irVistaListadoClientesMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaListadoClientesMenu)
        }

        val btnToListadoCitasMenu = findViewById<Button>(R.id.activity_editar_cliente_btn_citas)

        btnToListadoCitasMenu.setOnClickListener {
            val irVistaMainMenu = Intent(this, AgendaActivity::class.java)
            irVistaMainMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainMenu)
        }

        val btnToListadoAgregarCitaMenu =
            findViewById<Button>(R.id.activity_editar_cliente_btn_agregar_cita)

        btnToListadoAgregarCitaMenu.setOnClickListener {
            val irVistaAgregarCitaMenu = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCitaMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCitaMenu)
        }


    }
}