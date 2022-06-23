package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.mysalon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class AgregarCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cita)

        val btnToGuardar = findViewById<Button>(R.id.activity_agregar_cita_btn_guardar)
        val tilNombresApellidos = findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_nombres_apellidos)
        val spnCategoria = findViewById<Spinner>(R.id.activity_agregar_cita_spn_categoria)
        val spnTipoServicio = findViewById<Spinner>(R.id.activity_agregar_cita_spn_tipo_servicio)
        val tilFechaHora = findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_fecha_hora)

        val adapterCategoria = ArrayAdapter.createFromResource(
            this,
            R.array.categorias_array,
            android.R.layout.simple_spinner_item
        )
            spnCategoria.adapter = adapterCategoria

        val adapterTipoServicio = ArrayAdapter.createFromResource(
            this,
            R.array.tipoServicio_array,
            android.R.layout.simple_spinner_item
        )
            spnTipoServicio.adapter = adapterTipoServicio

        btnToGuardar.setOnClickListener {

            val nombresApellidos = tilNombresApellidos.editText?.text

            val fechaHora = tilFechaHora.editText?.text


            val nombresApellidosValid = TilValidator(tilNombresApellidos)
                .required()
                .validarNombre()
                .isValid()

            val fechaHoraValid = TilValidator(tilFechaHora)
                .required()
                .isValid()

            if (nombresApellidosValid && fechaHoraValid) {
                val irVistaAgenda = Intent(this, AgendaActivity::class.java)
                irVistaAgenda.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(irVistaAgenda)
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