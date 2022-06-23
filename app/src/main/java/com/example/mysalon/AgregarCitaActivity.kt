package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.mysalon.controllers.AuthController
import com.example.mysalon.utils.TilValidator
import com.example.mysalon.utils.showDatePickerDialog
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class AgregarCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cita)

        val btnToGuardar = findViewById<Button>(R.id.activity_agregar_cita_btn_guardar)
        val tilNombresApellidos =
            findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_nombres_apellidos)
        val spnCategoria = findViewById<Spinner>(R.id.activity_agregar_cita_spn_categoria)
        val spnTipoServicio = findViewById<Spinner>(R.id.activity_agregar_cita_spn_tipo_servicio)
        val tilFecha = findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_fecha)
        val tilHora = findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_hora)

        val adapterCategoria = ArrayAdapter.createFromResource(
            this,
            R.array.categorias_array,
            android.R.layout.simple_spinner_item
        )
        tilFecha.editText?.setOnClickListener({ _ ->
            showDatePickerDialog(this, tilFecha, Date())
        })

        /*adapterCategoria.setDropDpwnViewResourse(android.R.layout.simple_spinner_dropdown_item)*/
        spnCategoria.adapter = adapterCategoria

        val adapterTipoServicio = ArrayAdapter.createFromResource(
            this,
            R.array.tipoServicio_array,
            android.R.layout.simple_spinner_item
        )
        spnTipoServicio.adapter = adapterTipoServicio

        btnToGuardar.setOnClickListener {

            val nombresApellidos = tilNombresApellidos.editText?.text.toString()
            val categorias = spnCategoria.selectedItem.toString()
            val tipoServicio = spnTipoServicio.selectedItem.toString()
            val fecha = tilFecha.editText?.text.toString()
            val hora = tilHora.editText?.text.toString()

            val nombresApellidosValid = TilValidator(tilNombresApellidos)
                .required()
                .validarNombre()
                .isValid()

            val fechaValid = TilValidator(tilFecha)
                .required()
                .dateBefore(Date())
                .isValid()

            val horaValid = TilValidator(tilHora)
                .required()
                .isValid()

            Toast.makeText(this, categorias, Toast.LENGTH_SHORT).show()

            if (nombresApellidosValid && fechaValid && horaValid) {
                AuthController(this).agregarCita(
                    nombresApellidos,
                    categorias,
                    tipoServicio,
                    fecha,
                    hora

                )
                Toast.makeText(this, "Cita agregada exitosamentes", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()
            }

        }

        val btnToCitasMenu = findViewById<Button>(R.id.activity_agregar_cita_btn_citas)
        btnToCitasMenu.setOnClickListener {
            val irVistaAgenda = Intent(this, AgendaActivity::class.java)
            irVistaAgenda.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgenda)
        }

        val btnToClientes = findViewById<Button>(R.id.activity_agregar_cita_btn_clientes)
        btnToClientes.setOnClickListener {
            val irVistaClientes = Intent(this, ListadoClientesActivity::class.java)
            irVistaClientes.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaClientes)
        }

    }
}