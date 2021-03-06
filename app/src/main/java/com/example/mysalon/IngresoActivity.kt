package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.mysalon.controllers.AuthController
import com.example.mysalon.utils.TilValidator
import com.google.android.material.textfield.TextInputLayout

class IngresoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        val btnToIngresar = findViewById<Button>(R.id.activity_ingreso_btn_ingresar1)
        val tilEmail = findViewById<TextInputLayout>(R.id.activity_ingreso_til_email)
        val tilPassword = findViewById<TextInputLayout>(R.id.activity_ingreso_til_password)

        btnToIngresar.setOnClickListener {
            val email = tilEmail.editText?.text.toString()
            val password = tilPassword.editText?.text.toString()

            val emailValid = TilValidator(tilEmail)
                .required()
                .email()
                .isValid()

            val passwordValid = TilValidator(tilPassword)
                .required()
                .isValid()

            if (emailValid && passwordValid) {
                val controller = AuthController(this).login(email, password)
            } else {
                Toast.makeText(this, "Campos Inválidos", Toast.LENGTH_SHORT).show()
            }

        }

        val btnToVolver = findViewById<Button>(R.id.activity_ingreso_btn_volver)
        btnToVolver.setOnClickListener {
            val irVistaBienvenido = Intent(this, BienvenidoActivity::class.java)
            irVistaBienvenido.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(irVistaBienvenido)
        }


    }
}