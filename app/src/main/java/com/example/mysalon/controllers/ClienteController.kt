package com.example.mysalon.controllers

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.room.Room
import com.example.mysalon.AgendaActivity
import com.example.mysalon.lib.AppDatabase
import com.example.mysalon.models.Cliente
import com.example.mysalon.models.ClienteEntity

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

    fun agregarCliente(cliente: Cliente) {
        //buscar si ya existe
        val clientesEntities = dao.findByAll(userId)
        val clienteExistente = clientesEntities.find { c -> c.email == cliente.email }
        if (clienteExistente != null) {
            Toast.makeText(this.ctx, "El cliente ya existe", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val clienteEntity = ClienteEntity(
                id = cliente.id,
                nombresApellidos = cliente.nombresApellidos,
                telefono = cliente.telefono,
                email = cliente.email,
                cumpleanos = cliente.cumpleanos,
                done = cliente.done,
                userId = userId
            )

            dao.insert(clienteEntity)

            Toast.makeText(this.ctx, "Cliente registrado con exito", Toast.LENGTH_SHORT).show()

            val intent = Intent(this.ctx, AgendaActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            this.ctx.startActivity(intent)

        } catch (e: Exception) {
            Toast.makeText(this.ctx, "Error al registrar cliente: " + e.message, Toast.LENGTH_SHORT)
                .show()
        }
    }

    fun obtenerClientes(): List<Cliente> {
        val clientes = ArrayList<Cliente>()

        //obtener los clientes desde la bd
        val clientesEntities = dao.findByAll(userId)
        clientesEntities.forEach { c ->
            val cliente = Cliente(
                id = c.id,
                nombresApellidos = c.nombresApellidos,
                telefono = c.telefono,
                email = c.email,
                cumpleanos = c.cumpleanos,
                done = c.done
            )
            clientes.add(cliente);
        }

        return clientes
    }

    fun eliminarCliente(cliente: Cliente){
        if(cliente.id != null){
            dao.delete(cliente.id)
            Toast.makeText(this.ctx, "Cliente eliminado con exito", Toast.LENGTH_SHORT).show()
        }

    }

    fun editarCliente(cliente: Cliente) {
        if(cliente.id != null){
            val clienteEntity = ClienteEntity(
                id = cliente.id,
                nombresApellidos = cliente.nombresApellidos,
                telefono = cliente.telefono,
                email = cliente.email,
                cumpleanos = cliente.cumpleanos,
                done = cliente.done,
                userId = userId
            )
            dao.update(clienteEntity)
            Toast.makeText(this.ctx, "Cliente editado con exito", Toast.LENGTH_SHORT).show()
        }
    }
}