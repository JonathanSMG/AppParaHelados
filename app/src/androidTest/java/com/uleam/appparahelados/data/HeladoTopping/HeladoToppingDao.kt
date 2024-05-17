package com.uleam.appparahelados.data.HeladoTopping

import androidx.room.*

@Dao
interface HeladoToppingDao {
    @Insert
    suspend fun insert(heladoTopping: HeladoTopping)

    @Query("SELECT * FROM helado_toppings")
    suspend fun getAllHeladoToppings(): List<HeladoTopping>

    @Delete
    suspend fun deleteHeladoTopping(heladoTopping: HeladoTopping)
}
