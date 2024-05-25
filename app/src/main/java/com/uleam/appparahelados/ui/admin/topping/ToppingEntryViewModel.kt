/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uleam.appparahelados.ui.admin.topping

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.uleam.appparahelados.data.Topping.Topping
import com.uleam.appparahelados.data.Topping.interfaces.ToppingRepository
import java.text.NumberFormat

/**
 * ViewModel to validate and insert items in the Room database.
 */
class ToppingEntryViewModel (private val toppingRepository: ToppingRepository) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var toppingUiState by mutableStateOf(ToppingUiState())
        private set

    /**
     * Updates the [itemUiState] with the value provided in the argument. This method also triggers
     * a validation for input values.
     */
    fun updateUiState(toppingDetails: ToppingDetails) {
        toppingUiState =
            ToppingUiState(toppingDetails = toppingDetails, isEntryValid = validateInput(toppingDetails))
    }

    private fun validateInput(uiState: ToppingDetails = toppingUiState.toppingDetails): Boolean {
        return with(uiState) {
            nombre.isNotBlank() &&  precio.isNotBlank()
        }
    }
    suspend fun saveItem() {
        if (validateInput()) {
            toppingRepository.insertTopping(toppingUiState.toppingDetails.totopping())
        }
    }
}

/**
 * Represents Ui State for an Item.
 */
data class ToppingUiState(
    val toppingDetails: ToppingDetails = ToppingDetails(),
    val isEntryValid: Boolean = false
)

data class ToppingDetails(
    val id: Int = 0,
    val nombre: String = "",
    val precio: String = "",
)


fun ToppingDetails.totopping(): Topping = Topping(
    id = id,
    nombre = nombre,
    precio = precio.toDoubleOrNull() ?: 0.0
)

fun Topping.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(precio)
}

/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Topping.toToppingUiState(isEntryValid: Boolean = false): ToppingUiState = ToppingUiState(
    toppingDetails = this.toToppingDetails(),
    isEntryValid = isEntryValid
)

/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Topping.toToppingDetails(): ToppingDetails = ToppingDetails(
    id = id,
    nombre = nombre,
    precio = precio.toString(),
)
