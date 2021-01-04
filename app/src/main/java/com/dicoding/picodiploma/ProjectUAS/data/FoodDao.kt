package com.dicoding.picodiploma.ProjectUAS.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

// Deklarasi query untuk data access object pada interface
@Dao
interface FoodDao {
    @Query("SELECT * FROM order_table ORDER BY name ASC")
    fun getAlphabetizedWords(): LiveData<List<food>>

    @Query("SELECT * FROM order_table WHERE username=:username")
    fun loadSingle(username: String): LiveData<List<food>>

    @Insert
    fun insert(food: food)

    @Query("DELETE FROM order_table")
    fun deleteAll()
}