package com.dicoding.picodiploma.ProjectUAS.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.ProjectUAS.data.FoodData
import com.dicoding.picodiploma.ProjectUAS.adapter.ListFoodAdapter
import com.dicoding.picodiploma.ProjectUAS.R
import com.dicoding.picodiploma.ProjectUAS.activity.MainActivity.Companion.USERNAME
import com.dicoding.picodiploma.ProjectUAS.data.food
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        const val USERNAME = "extra_username"
    }

    private lateinit var adapter: ListFoodAdapter
    private var list: ArrayList<food> = arrayListOf()
    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_food.setHasFixedSize(true)

        adapter = ListFoodAdapter()
        adapter.notifyDataSetChanged()

        //deklarasi RecyclerView
        rv_food.layoutManager = LinearLayoutManager(this)
        rv_food.adapter = adapter

        //ambil username
        username = intent.getStringExtra(LoginActivity.USERNAME).toString()

        adapter.setData(FoodData.listData)
        adapter.setOnItemClickCallback(object : ListFoodAdapter.OnItemClickCallback {
            override fun onItemClicked(data: food) {
                val moveIntent = Intent(baseContext, DetailActivity::class.java)
                moveIntent.putExtra(DetailActivity.USERNAME, username)
                moveIntent.putExtra(DetailActivity.NAMA, data.name)
                moveIntent.putExtra(DetailActivity.DETAIL, data.detail)
                moveIntent.putExtra(DetailActivity.PRICE, data.price)
                moveIntent.putExtra(DetailActivity.PHOTO, data.photo)
                startActivity(moveIntent)
            }
        })
    }
//
//    //method show RecyclerList
//    private fun showRecyclerList() {
//        rvFood.layoutManager = LinearLayoutManager(this)
//        val listFoodAdapter = ListFoodAdapter(list)
//        rvFood.adapter = listFoodAdapter
//    }

    //add menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    //method option menu selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.pesanan -> {
                val i = Intent(this, PesananActivity::class.java)
                startActivity(i)
                finish()
                return true
            }
            R.id.about -> {
                val i = Intent(this, aboutActivity::class.java)
                startActivity(i)
                finish()
                return true
            }
            else -> return true
        }
    }

}