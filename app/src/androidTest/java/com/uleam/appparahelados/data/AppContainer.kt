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

package com.example.inventory.data

import android.content.Context
import com.uleam.appparahelados.data.Helado.interfaces.HeladoDao
import com.uleam.appparahelados.data.HeladoDatabase
import com.uleam.appparahelados.data.HeladoPersonalizado.interfaces.HeladoPersonalizadoDao
import com.uleam.appparahelados.data.HeladoTopping.interfaces.HeladoToppingDao
import com.uleam.appparahelados.data.Topping.interfaces.ToppingDao
import com.uleam.appparahelados.data.Usuario.interfaces.UsuarioDao

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val usuarioDao: UsuarioDao
    val heladoDao: HeladoDao
    val toppingDao: ToppingDao
    val heladoPersonalizadoDao: HeladoPersonalizadoDao
    val heladoToppingDao: HeladoToppingDao
}

/**
 * [AppContainer] implementation that provides instances of DAOs.
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [UsuarioDao]
     */
    override val usuarioDao: UsuarioDao by lazy {
        HeladoDatabase.getDatabase(context).usuarioDao()
    }

    /**
     * Implementation for [HeladoDao]
     */
    override val heladoDao: HeladoDao by lazy {
        HeladoDatabase.getDatabase(context).heladoDao()
    }

    /**
     * Implementation for [ToppingDao]
     */
    override val toppingDao: ToppingDao by lazy {
        HeladoDatabase.getDatabase(context).toppingDao()
    }

    /**
     * Implementation for [HeladoPersonalizadoDao]
     */
    override val heladoPersonalizadoDao: HeladoPersonalizadoDao by lazy {
        HeladoDatabase.getDatabase(context).heladoPersonalizadoDao()
    }

    /**
     * Implementation for [HeladoToppingDao]
     */
    override val heladoToppingDao: HeladoToppingDao by lazy {
        HeladoDatabase.getDatabase(context).heladoToppingDao()
    }
}
