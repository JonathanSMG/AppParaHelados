package com.uleam.appparahelados.ui.Clasico

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.uleam.appparahelados.data.Helado.Helado

class ClasicoViewModel : ViewModel() {
    private val _helados = MutableStateFlow<List<Helado>>(emptyList())
    val helados: StateFlow<List<Helado>> = _helados

    private val _cantidadHelados = MutableStateFlow<Map<Int, Int>>(emptyMap())
    val cantidadHelados: StateFlow<Map<Int, Int>> = _cantidadHelados

    init {
        // Simulación de datos, en una app real obtendría los datos de un repositorio o base de datos
        viewModelScope.launch {
            _helados.value = listOf(
                Helado(1, "Chocolate", "Delicioso helado de chocolate", "Delicioso helado de chocolate", 2.5),
                Helado(2, "Fresa", "Refrescante helado de fresa", "Delicioso helado de fresa", 2.2),
                Helado(3, "Vainilla", "Clásico helado de vainilla", "Delicioso helado de vainilla",2.0),
                Helado(4, "Menta", "Fresco helado de menta", "Delicioso helado de mente",2.0),
                Helado(5, "Coco", "cocoloco", "Delicioso sabor a coco", 2.5),
                Helado(6, "Oreo", "cocoloco", "De las galletas al helado", 3.0)
            )
        }
    }

    fun incrementarCantidad(id: Int) {
        val current = _cantidadHelados.value.toMutableMap()
        current[id] = (current[id] ?: 0) + 1
        _cantidadHelados.value = current
    }

    fun decrementarCantidad(id: Int) {
        val current = _cantidadHelados.value.toMutableMap()
        val cantidadActual = current[id] ?: 0
        if (cantidadActual > 0) {
            current[id] = cantidadActual - 1
            _cantidadHelados.value = current
        }
    }
}
