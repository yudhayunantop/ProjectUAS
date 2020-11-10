package com.dicoding.picodiploma.TugasPraktikumIntent

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvFood: RecyclerView
    private var list: ArrayList<food> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvFood = findViewById(R.id.rv_food   )
        rvFood.setHasFixedSize(true)

        list.addAll(FoodData.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private var title: String = "List food"

    private fun showSelectedFood(food: food) {
        Toast.makeText(this, "Kamu memilih " + food.name, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerList() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: food) {
                showSelectedFood(data)
                showSelected(data)
            }
        })
    }

    private fun showSelected(food: food) {
        val intent = Intent(this@MainActivity, DetailAdapter::class.java)
        intent.putExtra(DetailAdapter.NAMA, food.name)
        intent.putExtra(DetailAdapter.DETAIL, food.detail)
        intent.putExtra(DetailAdapter.PHOTO, food.photo)
        //startActivity(intent)
    }

}