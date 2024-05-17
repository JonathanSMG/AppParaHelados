package com.example.appparahelados.data

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "helado_toppings",
    primaryKeys = ["heladoPersonalizadoId", "toppingId"],
    foreignKeys = [
        ForeignKey(entity = HeladoPersonalizado::class, parentColumns = ["id"], childColumns = ["heladoPersonalizadoId"]),
        ForeignKey(entity = Topping::class, parentColumns = ["id"], childColumns = ["toppingId"])
    ]
)
data class HeladoTopping(
    val heladoPersonalizadoId: Int,
    val toppingId: Int
)
