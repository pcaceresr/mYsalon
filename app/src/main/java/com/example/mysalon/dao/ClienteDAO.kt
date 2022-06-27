package com.example.mysalon.dao

import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mysalon.models.CitaEntity
import com.example.mysalon.models.ClienteEntity

@Dao
interface ClienteDAO {
    @Query("SELECT * FROM clientes WHERE ` user_id` = :userId")
    fun findByAll(userId: Long): ArrayList<List<ClienteEntity>>

   @Query("SELECT * FROM clientes WHERE id = :id ")
    fun finById(id: Long)

    @Insert
    fun insert(cita: ClienteEntity)

    @Update
    fun update(cita: ClienteEntity)

    @Query("DELETE FROM clientes WHERE id = :id")
    fun delete(id: Long)

}