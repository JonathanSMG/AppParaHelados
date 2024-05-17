package com.uleam.appparahelados.data.Topping

import androidx.room.*

@Dao
interface ToppingDao {
    @Insert
    suspend fun insert(topping: Topping): Long

    @Query("SELECT * FROM toppings")
    suspend fun getAllToppings(): List<Topping>

    @Update
    suspend fun updateTopping(topping: Topping)

    @Delete
    suspend fun deleteTopping(topping: Topping)
}
