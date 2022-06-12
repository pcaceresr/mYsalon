package com.example.mysalon.controllers

import android.content.Context
import com.example.mysalon.models.Agenda

class AgendaController constructor(ctx: Context){
    private val ctx = ctx

    fun getAll(): List<Agenda> {
    val miAgenda = ArrayList<Agenda>()
        for(i in 1..10){
            miAgenda.add(Agenda(
                id = i.toLong(),
                title = "Hora $i",
                description = "Nombre $i"
            ))
        }
        return miAgenda
    }

}