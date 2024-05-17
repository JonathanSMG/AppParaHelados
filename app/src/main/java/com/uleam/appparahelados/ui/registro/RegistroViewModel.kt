package com.uleam.appparahelados.ui.registro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uleam.appparahelados.data.Usuario.Usuario
import com.uleam.appparahelados.data.Usuario.interfaces.UsuarioRepository
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class RegistroViewModel(private val usuarioRepository: UsuarioRepository) : ViewModel() {

    private val _nombreError = MutableLiveData<String>()
    val nombreError: LiveData<String> = _nombreError

    private val _correoError = MutableLiveData<String>()
    val correoError: LiveData<String> = _correoError

    private val _contraseñaError = MutableLiveData<String>()
    val contraseñaError: LiveData<String> = _contraseñaError

    private val _telefonoError = MutableLiveData<String>()
    val telefonoError: LiveData<String> = _telefonoError

    private val _direccionError = MutableLiveData<String>()
    val direccionError: LiveData<String> = _direccionError

    fun registrarUsuario(
        nombre: String,
        correo: String,
        contraseña: String,
        telefono: String,
        direccion: String
    ) {
        // Realizar validaciones
        var hayErrores = false

        if (nombre.isBlank()) {
            _nombreError.value = "El nombre no puede estar vacío"
            hayErrores = true
        }

        if (!isValidEmail(correo)) {
            _correoError.value = "Correo electrónico inválido"
            hayErrores = true
        }

        if (contraseña.length < 6) {
            _contraseñaError.value = "La contraseña debe tener al menos 6 caracteres"
            hayErrores = true
        }

        if (!isValidPhone(telefono)) {
            _telefonoError.value = "Número de teléfono inválido"
            hayErrores = true
        }

        if (direccion.isBlank()) {
            _direccionError.value = "La dirección no puede estar vacía"
            hayErrores = true
        }

        if (hayErrores) return

        viewModelScope.launch {
            val nuevoUsuario = Usuario( nombre, correo, contraseña, telefono, direccion, "cliente");
            usuarioRepository.insertUsuario(nuevoUsuario)
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )
        return emailPattern.matcher(email).matches()
    }

    private fun isValidPhone(phone: String): Boolean {
        val phonePattern = Pattern.compile("^\\d{10}$")
        return phonePattern.matcher(phone).matches()
    }
}
