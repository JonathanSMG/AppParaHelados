package com.uleam.appparahelados.data.HeladoPersonalizado

import androidx.room.*

@Dao
interface HeladoPersonalizadoDao {
    @Insert
    suspend fun insert(heladoPersonalizado: HeladoPersonalizado): Long

    @Query("SELECT * FROM helados_personalizados")
    suspend fun getAllHeladosPersonalizados(): List<HeladoPersonalizado>

    @Update
    suspend fun updateHeladoPersonalizado(heladoPersonalizado: HeladoPersonalizado)

    @Delete
    suspend fun deleteHeladoPersonalizado(heladoPersonalizado: HeladoPersonalizado)
}
