package com.example.mysalon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.mysalon.controllers.AuthController
import com.example.mysalon.models.User
import com.example.mysalon.utils.TilValidator
import com.example.mysalon.utils.showDatePickerDialog
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)


        val btnToRegistrarse = findViewById<Button>(R.id.activity_registro_btn_volver)
        val tilNombre = findViewById<TextInputLayout>(R.id.activity_registro_til_nombre)
        val tilApellidos = findViewById<TextInputLayout>(R.id.activity_registro_til_apellidos)
        val tilNombreSalon = findViewById<TextInputLayout>(R.id.activity_registro_til_nombre_salon)
        val spnGender = findViewById<Spinner>(R.id.activity_register_spn_gender)
        val tilBirth = findViewById<TextInputLayout>(R.id.activity_registro_til_birth)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_registro_til_email)
        val tilPassword = findViewById<TextInputLayout>(R.id.activity_registro_til_password)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.generos_array,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnGender.adapter = adapter

        tilBirth.editText?.setOnClickListener { _ ->
            showDatePickerDialog(this, tilBirth, Date())
        }

        btnToRegistrarse.setOnClickListener {
            val nombre = tilNombre.editText?.text.toString()
            val apellidos = tilApellidos.editText?.text.toString()
            val nombreSalon = tilNombreSalon.editText?.text.toString()
            val gender = spnGender.selectedItem.toString()
            val birth = tilBirth.editText?.text.toString()
            val email = tilEmail.editText?.text.toString()
            val password = tilPassword.editText?.text.toString()


            val nombreValid = TilValidator(tilNombre)
                .required()
                .validarNombre()
                .isValid()

            val apellidosValid = TilValidator(tilApellidos)
                .required()
                .validarNombre()
                .isValid()

            val nombreSalonValid = TilValidator(tilNombreSalon)
                .required()
                .isValid()

            val birthValid = TilValidator(tilBirth)
                .required()
                .dateBefore(Date())
                .isValid()

            val emailValid = TilValidator(tilEmail)
                .required()
                .email()
                .isValid()

            val passwordValid = TilValidator(tilPassword)
                .required()
                .isValid()

            if (nombreValid && apellidosValid && nombreSalonValid && emailValid && passwordValid && birthValid) {
                val user = User(
                    id = null,
                    nombre = nombre,
                    apellidos = apellidos,
                    nombreSalon = nombreSalon,
                    gender = gender,
                    birth = SimpleDateFormat("yyy-MM-dd").parse(birth),
                    email = email,
                    password = password
                )
                AuthController(this).registro(user)
            } else {
                Toast.makeText(this, "Campos inválidos", Toast.LENGTH_SHORT).show()
            }

        }

    }


}