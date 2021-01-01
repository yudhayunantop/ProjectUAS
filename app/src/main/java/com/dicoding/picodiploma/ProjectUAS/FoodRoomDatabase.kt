package com.dicoding.picodiploma.ProjectUAS

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

// Annotates class to be a room database with a table (entity) of the Word class
@Database(entities = arrayOf(food::class), version = 1, exportSchema = false)
public abstract class FoodRoomDatabase : RoomDatabase() {

    abstract fun foodDao(): FoodDao

    //menambahkan database pada instance program
    companion object{ //singleton prevents multiple instance of database opening at the same time

        @Volatile
        private var INSTANCE: FoodRoomDatabase? = null

        fun getDatabase(context: Context, viewModelScope: CoroutineScope): FoodRoomDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodRoomDatabase::class.java,
                    "order_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}