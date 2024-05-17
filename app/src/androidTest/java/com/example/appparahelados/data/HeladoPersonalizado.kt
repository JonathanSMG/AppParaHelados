package com.example.appparahelados.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import com.example.appparahelados.data.Helado.Helado

@Entity(
    tableName = "helados_personalizados",
    foreignKeys = [
        ForeignKey(entity = Helado::class, parentColumns = ["id"], childColumns = ["heladoId"]),
        ForeignKey(entity = Usuario::class, parentColumns = ["id"], childColumns = ["usuarioId"])
    ]
)
data class HeladoPersonalizado(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val heladoId: Int,
    val usuarioId: Int,
    val precioTotal: Double
)
