package com.uleam.appparahelados.data.Usuario

import androidx.room.*

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insert(usuario: Usuario): Long

    @Query("SELECT * FROM usuarios")
    suspend fun getAllUsuarios(): List<Usuario>

    @Update
    suspend fun updateUsuario(usuario: Usuario)

    @Delete
    suspend fun deleteUsuario(usuario: Usuario)
}
