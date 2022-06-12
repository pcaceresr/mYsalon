package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mysalon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class AgregarCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_cita)

        val btnToGuardar = findViewById<Button>(R.id.activity_agregar_cita_btn_guardar)
        val tilNombresApellidos =
            findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_nombres_apellidos)
        val tilCategoria = findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_categoria)
        val tilTipoServicio =
            findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_tipo_servicio)
        val tilFechaHora = findViewById<TextInputLayout>(R.id.activity_agregar_cita_til_fecha_hora)

        btnToGuardar.setOnClickListener {

            val nombresApellidos = tilNombresApellidos.editText?.text
            val categoria = tilCategoria.editText?.text
            val tipoServicio = tilTipoServicio.editText?.text
            val fechaHora = tilFechaHora.editText?.text


            val nombresApellidosValid = TilValidator(tilNombresApellidos)
                .required()
                .validarNombre()
                .isValid()

            val categoriaValid = TilValidator(tilCategoria)
                .required()
                .isValid()

            val tipoServicioValid = TilValidator(tilTipoServicio)
                .required()
                .isValid()

            val fechaHoraValid = TilValidator(tilFechaHora)
                .required()
                .isValid()

            if (nombresApellidosValid && categoriaValid && tipoServicioValid && fechaHoraValid) {
                val irVistaMain = Intent(this, MainActivity::class.java)
                irVistaMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(irVistaMain)
            } else {
                Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()
            }

        }

        val btnToCitasMenu = findViewById<Button>(R.id.activity_agregar_cita_btn_citas)
        btnToCitasMenu.setOnClickListener {
            val irVistaMainCitas = Intent(this, AgendaActivity::class.java)
            irVistaMainCitas.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainCitas)
        }

        val btnToClientes = findViewById<Button>(R.id.activity_agregar_cita_btn_clientes)
        btnToClientes.setOnClickListener {
            val irVistaClientes = Intent(this, ListadoClientesActivity::class.java)
            irVistaClientes.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaClientes)
        }

    }
}