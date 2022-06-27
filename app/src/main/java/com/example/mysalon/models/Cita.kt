package com.example.mysalon.models

import java.io.Serializable

data class Cita(
    val id: Long?,
    val nombresApellidos: String,
    val categoria: String,
    val tipoServicio: String,
    val fecha: String,
    val hora: String,
    val done: Boolean = false

) : Serializable
