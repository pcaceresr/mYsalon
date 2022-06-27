package com.example.mysalon.lib

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mysalon.dao.CitaDAO
import com.example.mysalon.dao.ClienteDAO
import com.example.mysalon.dao.UserDAO
import com.example.mysalon.models.CitaEntity
import com.example.mysalon.models.ClienteEntity
import com.example.mysalon.models.UserEntity
import com.example.mysalon.ui.Converters

@Database(entities = [UserEntity::class,CitaEntity::class, ClienteEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun citaDao(): CitaDAO
    abstract fun clienteDao(): ClienteDAO

    companion object {
        const val DATABASE_NAME = "mySalon"
    }
}