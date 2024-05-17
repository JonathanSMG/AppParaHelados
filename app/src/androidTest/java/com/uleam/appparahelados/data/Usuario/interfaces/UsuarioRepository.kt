package com.uleam.appparahelados.data.Usuario.interfaces

import com.uleam.appparahelados.data.Usuario.Usuario
import kotlinx.coroutines.flow.Flow

interface UsuarioRepository {

    fun getAllUsuariosStream(): Flow<List<Usuario>>
    fun getUsuarioStream(id: Int): Flow<Usuario?>
    suspend fun insertUsuario(usuario: Usuario)
    suspend fun deleteUsuario(usuario: Usuario)
    suspend fun updateUsuario(usuario: Usuario)

}