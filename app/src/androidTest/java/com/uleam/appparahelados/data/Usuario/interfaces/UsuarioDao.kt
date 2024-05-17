package com.uleam.appparahelados.data.Usuario.interfaces

import androidx.room.*
import com.uleam.appparahelados.data.Usuario.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(usuario: Usuario)

    @Update
    suspend fun update(usuario: Usuario)

    @Delete
    suspend fun delete(usuario: Usuario)

    @Query("SELECT * from usuarios WHERE id = :id")
    fun getUsuario(id: Int): Flow<Usuario?>

    @Query("SELECT * from usuarios ORDER BY nombre ASC")
    fun getAllUsuarios(): Flow<List<Usuario>>
}
