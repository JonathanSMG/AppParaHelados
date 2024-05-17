package com.example.appparahelados.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toppings")
data class Topping(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val precio: Double
)
