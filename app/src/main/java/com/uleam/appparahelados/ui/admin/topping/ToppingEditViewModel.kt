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
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * ViewModel to retrieve and update an item from the [ItemsRepository]'s data source.
 */



class ToppingEditViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    /**
     * Holds current item ui state
     */
    var toppingUiState by mutableStateOf(ToppingUiState())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[ToppingEditDestination.toppingIdArg])

    private fun validateInput(uiState: ToppingDetails = toppingUiState.toppingDetails): Boolean {
        return with(uiState) {
            nombre.isNotBlank() && precio.isNotBlank()
        }
    }
}
