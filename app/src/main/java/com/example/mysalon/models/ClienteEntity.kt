package com.example.mysalon.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "clientes")
data class ClienteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "nombresApellidos") val nombresApellidos: String,
    val telefono: String,
    val email: String,
    val cumpleanos: Date,
    val done: Boolean,
    @ColumnInfo(name = " user_id") val userId: Long
)