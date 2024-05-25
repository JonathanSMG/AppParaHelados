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

package com.uleam.appparahelados.ui

import PrincipalViewModel
import android.app.Application
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uleam.appparahelados.HeladosApplication
import com.uleam.appparahelados.ui.admin.AdminViewModel
import com.uleam.appparahelados.ui.login.LoginViewModel
import com.uleam.appparahelados.ui.registro.RegisterViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
                RegisterViewModel(heladeriaApplication().container.usuarioRepository)
        }
        initializer {
                 LoginViewModel(heladeriaApplication().container.usuarioRepository)
        }
        initializer {
            PrincipalViewModel()
        }
        initializer {
            AdminViewModel()
        }
    }
}

/**
 * Extension function to queries for [Application] object and returns an instance of
 * [InventoryApplication].
 */
fun CreationExtras.heladeriaApplication(): HeladosApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as HeladosApplication)
