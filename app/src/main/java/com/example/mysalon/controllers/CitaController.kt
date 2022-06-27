package com.example.mysalon.controllers

import android.content.Context
import androidx.room.Room
import com.example.mysalon.lib.AppDatabase
import com.example.mysalon.models.Cita
import com.example.mysalon.models.Clientes

class CitaController constructor(ctx: Context, userId: Long = 0) {
    private val ctx = ctx
    private val userId = userId
    private val dao = Room.databaseBuilder(
        ctx,
        AppDatabase::class.java, "database-name"
    )
        .allowMainThreadQueries()
        .build()
        .citaDao()

    fun obtenerCita(): ArrayList<Cita> {
        val citasEntities = dao.findByAll(userId)

        val citas = ArrayList<Cita>()

        citasEntities.forEach{ cita -> citas.add(Cita(
            id = cita.id,
            nombresApellidos = cita.nommbresApellidos,
            categoria = cita.categoria,
            tipoServicio = cita.TipoServicio,
            fecha = cita.fecha,
            hora = cita.hora,
            done = cita.done
        ))}
        return citas
    }
}