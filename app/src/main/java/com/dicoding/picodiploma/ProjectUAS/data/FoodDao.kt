package com.dicoding.picodiploma.ProjectUAS.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// Deklarasi query untuk data access object pada interface
@Dao
interface FoodDao {
    @Query("SELECT * FROM order_table ORDER BY foodId ASC")
    fun getAlphabetizedWords(): LiveData<List<food>>

    @Insert
    fun insert(food: food)
}