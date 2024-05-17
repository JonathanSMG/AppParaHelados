package com.example.appparahelados.data.Helado

import androidx.room.*

@Dao
interface HeladoDao {
    @Insert
    suspend fun insert(helado: Helado): Long

    @Query("SELECT * FROM helados")
    suspend fun getAllHelados(): List<Helado>

    @Update
    suspend fun updateHelado(helado: Helado)

    @Delete
    suspend fun deleteHelado(helado: Helado)
}
