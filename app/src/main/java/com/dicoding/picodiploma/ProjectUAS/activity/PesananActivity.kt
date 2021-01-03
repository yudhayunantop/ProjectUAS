package com.dicoding.picodiploma.ProjectUAS.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.ProjectUAS.R
import com.dicoding.picodiploma.ProjectUAS.adapter.ListPesananAdapter
import com.dicoding.picodiploma.ProjectUAS.foodViewModel

class PesananActivity : AppCompatActivity() {

    private lateinit var FoodViewModel: foodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan)

        //set judul
        supportActionBar?.title = "Riwayat Pesanan"

        //deklarasi adapter dan recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rv_pesanan)
        val adapter = ListPesananAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // deklarasi viewModel
        FoodViewModel = ViewModelProvider(this).get(foodViewModel::class.java)

        // panggil data dari db
        FoodViewModel.allFood.observe(this, Observer { food ->
            food?.let {
                adapter.setFoods(it)
            }
        })
    }
}