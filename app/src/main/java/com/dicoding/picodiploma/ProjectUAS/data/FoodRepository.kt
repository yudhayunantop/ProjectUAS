package com.dicoding.picodiploma.ProjectUAS.data

import android.os.AsyncTask
import androidx.lifecycle.LiveData

class FoodRepository(private val foodDao: FoodDao){

    //deklarasi LiveData pada repository
    val allFoods: LiveData<List<food>> = foodDao.getAlphabetizedWords()

    // menambahkan insert dari wordDao ke Repository
    fun insert(food: food){
        val insertMemoAsyncTask = InsertMemoAsyncTask(foodDao).execute(food)
    }

    //menambahkan delete dari wordDao ke Repository
    fun deleteAll(){
        val deleteAllmemoAsyncTask = DeleteAllmemoAsyncTask(foodDao).execute()
    }

    //    Menerapkan Courutine pada query
    companion object {
        private class InsertMemoAsyncTask(foodDao: FoodDao) : AsyncTask<food, Unit, Unit>() {
            val foodDao = foodDao
            override fun doInBackground(vararg p0: food?) {
                foodDao.insert(p0[0]!!)
            }
        }
        private class DeleteAllmemoAsyncTask(foodDao: FoodDao) : AsyncTask<Unit, Unit, Unit>() {
            val foodDao = foodDao
            override fun doInBackground(vararg p0: Unit?) {
                foodDao.deleteAll()
            }
        }
    }
}