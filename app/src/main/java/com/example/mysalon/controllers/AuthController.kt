package com.example.mysalon.controllers

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.mysalon.AgendaActivity
import com.example.mysalon.IngresoActivity
import com.example.mysalon.ListadoClientesActivity
import com.example.mysalon.lib.AppDatabase
import com.example.mysalon.lib.BCrypt
import com.example.mysalon.lib.RetrofitClient
import com.example.mysalon.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import services.AuthService
import java.util.*
import java.util.logging.Handler as Handler1


class AuthController constructor(ctx: Context) {
    private val sharedPref = ctx.getSharedPreferences("MySalon", Context.MODE_PRIVATE)
    private val INCORRECT_CREDENTIALS = "Credenciales incorrectas"
    private val ctx = ctx
    //Retrofit
    private val retrofit = RetrofitClient.getRetrofitInstance()
    private val authService = retrofit.create(AuthService::class.java)


    private val dao = Room.databaseBuilder(
        ctx.applicationContext,
        AppDatabase::class.java, "database-name"
    )
        .allowMainThreadQueries()
        .build()
        .userDao()

    fun login(email: String, password: String) {
        val loginPayload = LoginPayloadDTO(email, password)
        val call = authService.login(loginPayload)

        call.enqueue(object : Callback<LoginResponseDTO> {
            override fun onFailure(call: Call<LoginResponseDTO>, t: Throwable) {
                Toast.makeText(ctx, "Error de conexión", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<LoginResponseDTO>,
                response: Response<LoginResponseDTO>
            ) {
                if (response.code() != 200) {
                    Toast.makeText(ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_SHORT).show()
                } else {
                    val bodyResponse = response.body()
                    Toast.makeText(ctx, "Bienvenido ${bodyResponse?.user?.id}", Toast.LENGTH_SHORT).show()
                    val sharedEdit = sharedPref.edit()
                    sharedEdit.putLong("user_id", bodyResponse?.user?.id!!)
                    sharedEdit.putString("user_jwt", bodyResponse?.jwt!!)
                    sharedEdit.commit()

                    val intent = Intent(ctx, AgendaActivity::class.java)
                    ctx.startActivity(intent)
                    (ctx as Activity).finish()
                }
            }
        })
    }

    fun registro(user: User) {
        val registerPayload = RegisterPayloadDTO(
            user.email,
            user.email,
            user.password
        )

        val call = authService.register(registerPayload)

        call.enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(ctx, "Error de conexión", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<Void>,
                response: Response<Void>
            ) {
                if (response.code() != 200) {
                    Toast.makeText(ctx, "Cuenta existente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(ctx, "Cuenta registrada", Toast.LENGTH_SHORT).show()
                    val intent = Intent(ctx, IngresoActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    ctx.startActivity(intent)
                }
            }
        })
    }

   /* fun login(email: String, password: String) {

        val user = dao.findByEmail(email)

        if (user == null) {
            Toast.makeText(this.ctx, INCORRECT_CREDENTIALS, Toast.LENGTH_SHORT).show()
            return
        }
        if (BCrypt.checkpw(password, user.password)) {
            Toast.makeText(this.ctx, "Bienvenido(a) ${user.nombre}", Toast.LENGTH_SHORT).show()
            val sharedEdit = sharedPref.edit()
            sharedEdit.putLong("user_id", user.id!!)
            sharedEdit.commit()
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
    }*/

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

    fun checkUserSession() {
        val id = sharedPref.getLong("user_id", -1)

        //Log.e("Check user session", id.toString())

        Handler().postDelayed({
            if (id == (-1).toLong()) {
                val intent = Intent(this.ctx, IngresoActivity::class.java)
                this.ctx.startActivity(intent)

            } else {
                val intent = Intent(this.ctx, AgendaActivity::class.java)
                this.ctx.startActivity(intent)
            }
            (this.ctx as Activity).finish()
        }, 2000)

    }

    fun clearSession() {
        val editor = sharedPref.edit()
        editor.remove("user_id")
        editor.remove("user_jwt")
        editor.commit()
        val intent = Intent(this.ctx, IngresoActivity::class.java)
        this.ctx.startActivity(intent)
        (this.ctx as Activity).finish()
    }

}