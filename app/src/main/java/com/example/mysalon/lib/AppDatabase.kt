package com.example.mysalon.lib

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mysalon.dao.UserDAO
import com.example.mysalon.models.UserEntity
import com.example.mysalon.ui.Converters

@Database(entities = [UserEntity::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
    abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO

    companion object{
        const val DATABASE_NAME = "mySalon"
    }
}