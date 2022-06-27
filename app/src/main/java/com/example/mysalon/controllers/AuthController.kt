package com.example.mysalon.controllers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.widget.Toast
import androidx.room.Room
import com.example.mysalon.AgendaActivity
import com.example.mysalon.IngresoActivity
import com.example.mysalon.ListadoClientesActivity
import com.example.mysalon.lib.AppDatabase
import com.example.mysalon.lib.BCrypt
import com.example.mysalon.models.User
import com.example.mysalon.models.UserEntity
import java.util.*

val INCORRECT_CREDENTIALS = "Credenciales incorrectas"

class AuthController constructor(ctx: Context) {
    private val ctx = ctx
    private val dao = Room.databaseBuilder(
        ctx.applicationContext,
        AppDatabase::class.java, "database-name"
    )
        .allowMainThreadQueries()
        .build()
        .userDao()

    fun login(email: String, password: String) {
        val user = dao.findByEmail(email)

        if (user == null) {
            Toast.makeText(this.ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_SHORT).show()
            return
        }
        if (BCrypt.checkpw(password, user.password)) {
            Toast.makeText(this.ctx, "Bienvenido(a) ${user.nombre}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.ctx, AgendaActivity::class.java)
            this.ctx.startActivity(intent)
            (this.ctx as Activity).finish()
        } else {
            Toast.makeText(this.ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_SHORT).show()
        }
    }

    fun registro(user: User) {
        val hashedPassword = BCrypt.hashpw(user.password, BCrypt.gensalt())
        val userEntity = UserEntity(
            id = null,
            nombre = user.nombre,
            apellidos = user.apellidos,
            nombreSalon = user.nombreSalon,
            gender = user.gender,
            birth = user.birth,
            email = user.email,
            password = hashedPassword
        )


        try {
            dao.insert(userEntity)

            Toast.makeText(this.ctx, "Cuenta registrada", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.ctx, IngresoActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            this.ctx.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this.ctx, "Cuenta existente", Toast.LENGTH_SHORT).show()
        }
    }

    fun agregarCita(
        nombresApellidos: String,
        categorias: String,
        tipoServicio: String,
        fechaHora: String,
        hora: String
    ) {
        Toast.makeText(this.ctx, "Cita agregada exitosamente", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.ctx, AgendaActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.ctx.startActivity(intent)
    }

    fun agregarCliente(
        nombresApellidos: Editable?,
        telefono: Editable?,
        email: Editable?,
        cumpleanos: Editable?,

        ) {
        Toast.makeText(this.ctx, "Cliente agregado exitosamente", Toast.LENGTH_SHORT).show()
        val intent = Intent(this.ctx, ListadoClientesActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.ctx.startActivity(intent)
    }

}