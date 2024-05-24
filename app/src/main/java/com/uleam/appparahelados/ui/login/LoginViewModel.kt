package com.uleam.appparahelados.ui.login

import androidx.lifecycle.*
import com.uleam.appparahelados.data.Usuario.interfaces.UsuarioRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UsuarioRepository) : ViewModel() {

    private val _loginSuccessful = MutableLiveData<Boolean>()
    val loginSuccessful: LiveData<Boolean> get() = _loginSuccessful

    private val _loginError = MutableLiveData<String?>()
    val loginError: LiveData<String?> get() = _loginError

    fun onLoginButtonClick(correo: String, pass: String) {
        viewModelScope.launch {
            val usuario = repository.getUsuarioByUsername(correo)
            if (usuario != null && usuario.pass == pass) {
                _loginSuccessful.value = true
            } else {
                _loginError.value = "Correo o contraseñaaaaaaaaa incorrectos"
            }
        }
    }
}
