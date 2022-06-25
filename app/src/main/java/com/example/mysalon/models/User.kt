package com.example.mysalon.models

import java.util.*

data class User(
    val id : Long?,
    val nombre: String,
    val apellidos: String,
    val nombreSalon: String,
    val gender: String,
    val birth: Date,
    val email: String,
    val password: String
)
