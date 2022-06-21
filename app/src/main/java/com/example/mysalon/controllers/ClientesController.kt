package com.example.mysalon.controllers

import android.content.Context
import com.example.mysalon.models.Clientes


class ClientesController constructor(ctx: Context){
    private val ctx = ctx

    fun obtenerCliente(): List<Clientes> {
        val misClientes = ArrayList<Clientes>()
        for(i in 1..10){
            misClientes.add(
                Clientes(
                id = i.toLong(),
                title = "Cliente $i",
                description = "Nombre $i"
            )
            )
        }
        return misClientes
    }
}