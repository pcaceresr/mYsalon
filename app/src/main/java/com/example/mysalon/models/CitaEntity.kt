package com.example.mysalon.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "citas")
data class CitaEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "nombresApellidos") val nommbresApellidos: String,
    val categoria: String,
    val TipoServicio: String,
    val fecha: String,
    val hora: String,
    val done: Boolean,
    @ColumnInfo(name =" user_id") val userId: Long
)