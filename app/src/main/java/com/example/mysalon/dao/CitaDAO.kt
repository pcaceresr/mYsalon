package com.example.mysalon.dao

import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mysalon.models.CitaEntity

@Dao
interface CitaDAO {
    @Query("SELECT * FROM citas WHERE ` user_id` = :userId")
    fun findByAll(userId: Long): List<CitaEntity>


    /*@Query("SELECT * FROM citas WHERE id = :id ")
    fun finById(id: Long)*/

    @Insert
    fun insert(cita: CitaEntity)

    @Update
    fun update(cita: CitaEntity)

    @Query("DELETE FROM citas WHERE id = :id")
    fun delete(id: Long)

}