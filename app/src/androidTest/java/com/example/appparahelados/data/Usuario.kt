package com.example.appparahelados.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val rol: String // 'admin' o 'cliente'
)
