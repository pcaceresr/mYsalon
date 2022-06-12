package com.example.mysalon.controllers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.mysalon.AgendaActivity

class AuthController constructor(ctx: Context) {
    private val ctx = ctx

    fun login(email: String, password: String) {
        if (email == "lis@gmail.com" && password == "123") {
            Toast.makeText(this.ctx, "Bienvenido(a)", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.ctx, AgendaActivity::class.java)
            this.ctx.startActivity(intent)
        } else {
            Toast.makeText(this.ctx, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }

}