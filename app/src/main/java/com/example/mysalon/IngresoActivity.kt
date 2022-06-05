package com.example.mysalon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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
            val email = tilEmail.editText?.text
            val password = tilPassword.editText?.text

            val emailValid = TilValidator(tilEmail)
                .required()
                .email()
                .isValid()

            val passwordValid = TilValidator(tilPassword)
                .required()
                .isValid()

            if (emailValid && passwordValid){
                val irVistaMain = Intent(this, MainActivity::class.java)
                irVistaMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(irVistaMain)
            }else{
                Toast.makeText(this, "Campos inválidos",Toast.LENGTH_SHORT).show()
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