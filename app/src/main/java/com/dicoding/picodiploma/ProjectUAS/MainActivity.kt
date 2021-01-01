package com.dicoding.picodiploma.ProjectUAS

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        rvFood = findViewById(R.id.rv_food   )
        rvFood.setHasFixedSize(true)

        list.addAll(FoodData.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvFood.layoutManager = LinearLayoutManager(this)
        val listFoodAdapter = ListFoodAdapter(list)
        rvFood.adapter = listFoodAdapter

        listFoodAdapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: food) {
                showSelected(data)
            }
        })
    }

    private fun showSelected(food: food) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.NAMA, food.name)
        intent.putExtra(DetailActivity.DETAIL, food.detail)
        intent.putExtra(DetailActivity.PHOTO, food.photo)
        //startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.pesanan -> {
                val i = Intent(this, PesananActivity::class.java)
                startActivity(i)
                return true
            }
            R.id.about -> {
                val i = Intent(this, aboutActivity::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }

}