package com.example.mysalon.controllers

import android.content.Context
import androidx.room.Room
import com.example.mysalon.lib.AppDatabase
import com.example.mysalon.models.Cliente

class ClienteController constructor(ctx: Context, userId: Long = 0) {
    private val ctx = ctx
    private val userId = userId
    private val dao = Room.databaseBuilder(
        ctx,
        AppDatabase::class.java, "database-name"
    )
        .allowMainThreadQueries()
        .build()
        .clienteDao()

    fun obtenerCliente(): ArrayList<Cliente> {
        val clientesEntities = dao.findByAll(userId)

        val clientes = ArrayList<Cliente>()

        clientesEntities.forEach { cliente -> clientes.add(Cliente(
                    id = cliente.id,
                    nombresApellidos = cliente.nommbresApellidos,
                    telefono = cliente.telefono,
                    email = cliente.telefono,
                    cumpleanos = cliente.cumpleanos,
                    done = cliente.done
                )
            )
        }
        return clientes
    }
}