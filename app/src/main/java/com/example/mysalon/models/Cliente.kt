package com.example.mysalon.models

import java.io.Serializable

data class Cliente(
    val id: Long?,
    val nombresApellidos: String,
    val telefono: String,
    val email: String,
    val cumpleanos: String,
    val done: Boolean = false

) : Serializable