package com.dicoding.picodiploma.ProjectUAS.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao) {

    //deklarasi LiveData pada repository
    val allFoods: LiveData<List<food>> = foodDao.getAlphabetizedWords()

    // menambahkan insert dari wordDao ke Repository
    fun insert(food: food) {
        val insertMemoAsyncTask = InsertFoodAsyncTask(foodDao).execute(food)
    }
}
    //Menerapkan Courutine pada query
        private class InsertFoodAsyncTask(foodDao: FoodDao) : AsyncTask<food, Unit, Unit>() {
            val foodDao = foodDao
            override fun doInBackground(vararg p0: food?) {
                foodDao.insert(p0[0]!!)
            }
        }