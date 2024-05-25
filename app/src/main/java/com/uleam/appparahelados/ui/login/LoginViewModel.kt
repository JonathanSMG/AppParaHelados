package com.uleam.appparahelados.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uleam.appparahelados.data.Usuario.interfaces.UsuarioRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UsuarioRepository) : ViewModel() {

    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean>
        get() = _navigateToHome

    private val _showErrorToast = MutableLiveData<Boolean>()
    val showErrorToast: LiveData<Boolean>
        get() = _showErrorToast

    fun login(correo: String, password: String) {
        viewModelScope.launch {
            val isValidCredentials = repository.areCredentialsValid(correo, password)

            if (isValidCredentials) {
                // Autenticación exitosa, establecer el valor de navegación a true
                _navigateToHome.value = true
            } else {
                // Credenciales incorrectas, establecer el valor de showErrorToast a true
                _showErrorToast.value = true
            }
        }
    }

    // Método para indicar que la navegación a la pantalla principal ha finalizado
    fun doneNavigatingToHome() {
        _navigateToHome.value = false
    }

    // Método para indicar que la visualización del mensaje de error ha finalizado
    fun doneShowingError() {
        _showErrorToast.value = false
    }
}
