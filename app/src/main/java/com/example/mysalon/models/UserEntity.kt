package com.example.mysalon.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName= "users", indices = [Index(value = ["email"], unique = true)])
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id :Long?,
    @ColumnInfo(name= "nombre") val nombre:String,
    @ColumnInfo(name= "apellidos")val apellidos:String,
    val nombreSalon:String,
    val gender:String,
    val birth:Date,
    val email:String,
    val password:String
)
