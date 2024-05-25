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

    fun login(correo: String?, password: String?) {
        if (correo.isNullOrEmpty() || password.isNullOrEmpty()) {
            _showErrorToast.value = true
            return
        }

        viewModelScope.launch {
            try {
                val isValidCredentials = repository.areCredentialsValid(correo, password)

                if (isValidCredentials) {
                    _navigateToHome.value = true
                } else {
                    _showErrorToast.value = true
                }
            } catch (e: Exception) {
                _showErrorToast.value = true
            }
        }
    }
    suspend fun validateUser(email: String, password: String): Boolean {
        val user = repository.getUserByEmailAndPassword(email, password)
        return user != null
    }

    fun resetNavigation() {
        _navigateToHome.value = false
    }

    fun resetError() {
        _showErrorToast.value = false
    }
}
