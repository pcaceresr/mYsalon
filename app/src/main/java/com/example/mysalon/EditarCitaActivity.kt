package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mysalon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class EditarCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_cita)

        val btnToGuardar = findViewById<Button>(R.id.activity_editar_cita_btn_guardar)
        val tilNombresApellidos =
            findViewById<TextInputLayout>(R.id.activity_editar_cita_til_nombres_apellidos)
        val tilCategoria = findViewById<TextInputLayout>(R.id.activity_editar_cita_til_categoria)
        val tilTipoServicio =
            findViewById<TextInputLayout>(R.id.activity_editar_cita_til_tipo_servicio)
        val tilFechaHora = findViewById<TextInputLayout>(R.id.activity_editar_cita_til_fecha_hora)



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

        val btnToListadoClientesMenu = findViewById<Button>(R.id.activity_editar_cita_btn_clientes)

        btnToListadoClientesMenu.setOnClickListener {
            val irVistaListadoClientesMenu = Intent(this, ListadoClientesActivity::class.java)
            startActivity(irVistaListadoClientesMenu)
        }


        val btnToDescartar = findViewById<Button>(R.id.activity_editar_cita_btn_descartar)

        btnToDescartar.setOnClickListener {
            val irVerCita = Intent(this, MainActivity::class.java)
            irVerCita.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVerCita)
        }

        val btnToListadoCitasMenu = findViewById<Button>(R.id.activity_editar_cita_btn_citas)

        btnToListadoCitasMenu.setOnClickListener {
            val irVistaMainMenu = Intent(this, MainActivity::class.java)
            irVistaMainMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaMainMenu)
        }

        val btnToListadoAgregarCitaMenu =
            findViewById<Button>(R.id.activity_editar_cita_btn_agregar_cita)

        btnToListadoAgregarCitaMenu.setOnClickListener {
            val irVistaAgregarCitaMenu = Intent(this, AgregarCitaActivity::class.java)
            irVistaAgregarCitaMenu.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaAgregarCitaMenu)
        }

    }
}