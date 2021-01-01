package com.dicoding.picodiploma.ProjectUAS

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class foodViewModel (application: Application) : AndroidViewModel(application){
    private val repository: FoodRepository
    val allFood : LiveData<List<food>>

    // deklarasi dao dan repository pada viewModel
    init {
        val foodsDao = FoodRoomDatabase.getDatabase(application, viewModelScope).foodDao()
        repository = FoodRepository(foodsDao)
        allFood = repository.allFood
    }

    //menambahkan insert pada viewModel
    fun insert(food:food) = viewModelScope.launch {
        repository.insert(food)
    }

    //menambahkan delete pada viewModel
    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }
}