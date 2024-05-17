package com.uleam.appparahelados.data.Usuario

import com.uleam.appparahelados.data.Usuario.interfaces.UsuarioDao
import com.uleam.appparahelados.data.Usuario.interfaces.UsuarioRepository
import kotlinx.coroutines.flow.Flow

class OfflineUsuariosRepository(private val usuarioDao: UsuarioDao) : UsuarioRepository {
    override fun getAllUsuariosStream(): Flow<List<Usuario>> = usuarioDao.getAllUsuarios()

    override fun getUsuarioStream(id: Int): Flow<Usuario?> = usuarioDao.getUsuario(id)

    override suspend fun insertUsuario(usuario: Usuario) = usuarioDao.insert(usuario)

    override suspend fun deleteUsuario(usuario: Usuario) = usuarioDao.delete(usuario)

    override suspend fun updateUsuario(usuario: Usuario) = usuarioDao.update(usuario)
}
