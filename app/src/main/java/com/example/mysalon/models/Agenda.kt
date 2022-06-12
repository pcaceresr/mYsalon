package com.example.mysalon.models

import java.io.Serializable

data class Agenda(
    val id: Long?,
    val title: String,
    val description: String?,
    val done: Boolean = false
) : Serializable
