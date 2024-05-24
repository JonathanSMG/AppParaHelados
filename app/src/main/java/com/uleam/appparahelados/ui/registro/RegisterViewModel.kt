package com.uleam.appparahelados.ui.registro

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.uleam.appparahelados.data.Usuario.Usuario
import com.uleam.appparahelados.data.Usuario.interfaces.UsuarioRepository
import kotlinx.coroutines.*

class RegisterViewModel(private val repository: UsuarioRepository) : ViewModel() {

    fun String.isValidEmail(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun String.isValidPhone(): Boolean {
        return android.util.Patterns.PHONE.matcher(this).matches()
    }
    val snackbarMessage = mutableStateOf("")

    private val _errorToast = MutableLiveData<String?>()
    val errorToast: LiveData<String?>
        get() = _errorToast

    private val _navigateTo = MutableLiveData<Boolean>()
    val navigateTo: LiveData<Boolean>
        get() = _navigateTo

    fun submitButton(
        nombre: String,
        correo: String,
        direccion: String,
        pass: String,
        telefono: String
    ) {
        if (validateFields(nombre, correo, direccion, pass, telefono)) {
            CoroutineScope(viewModelScope.coroutineContext).launch {
                val usuarioExistente = repository.getUsuarioByUsername(correo)
                if (usuarioExistente != null) {
                    Log.i("APP HELADOS", "El correo electrónico ya está registrado.")
                } else {
                    insert(Usuario(nombre, correo, direccion, pass, telefono, "Administrador"))
                    Log.i("APP HELADOS", "Registro exitoso")
                }
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("APP HELADOS", "ViewModel cleared")
    }

    fun validateFields(
        nombre: String,
        correo: String,
        direccion: String,
        pass: String,
        telefono: String
    ): Boolean {
        if (nombre.isEmpty() || correo.isEmpty() || direccion.isEmpty() || pass.isEmpty() || telefono.isEmpty()) {
            Log.i("APP HELADOS","Por favor, complete todos los campos.")
            return false
        } else if (!correo.isValidEmail()) {
            Log.i("APP HELADOS", "Por favor, ingrese un correo electrónico válido.")
            return false
        } else if (!telefono.isValidPhone()) {
            Log.i("APP HELADOS", "Por favor, ingrese un número de teléfono válido.")
            return false
        } else if (pass.length < MIN_PASSWORD_LENGTH) {
            Log.i("APP HELADOS", "La contraseña debe tener al menos $MIN_PASSWORD_LENGTH caracteres.")
            return false
        }
        return true
    }
    companion object {
        private const val MIN_PASSWORD_LENGTH = 6
    }
    fun onSubmitButtonClick(nombre: String, correo: String, direccion: String, pass: String, telefono: String) {
        if (validateFields(nombre, correo, direccion, pass, telefono)) {
            submitButton(nombre, correo, direccion, pass, telefono)
            snackbarMessage.value = "Registro exitoso" // O el mensaje que desees mostrar
        }
    }
    private fun insert(user: Usuario) {
        viewModelScope.launch {
            repository.insertUsuario(user)
        }
    }
}