package com.example.mysalon.models

import android.text.Editable
import java.io.Serializable
import java.util.*

data class Cliente(
    val id: Long?,
    val nombresApellidos: String,
    val telefono: String,
    val email: String,
    val cumpleanos: Date,
    val done: Boolean = false

) : Serializable