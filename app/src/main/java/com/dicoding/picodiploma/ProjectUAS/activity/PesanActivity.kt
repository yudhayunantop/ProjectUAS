package com.dicoding.picodiploma.ProjectUAS.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.dicoding.picodiploma.ProjectUAS.R
import com.dicoding.picodiploma.ProjectUAS.data.food
import com.dicoding.picodiploma.ProjectUAS.foodViewModel
import kotlinx.android.synthetic.main.activity_pesan.*

class PesanActivity : AppCompatActivity() {

    companion object{
        const val NAMA = "extra_name"
        const val PRICE = "extra_price"
        const val PHOTO = "extra_photo"
        const val USERNAME = "extra_username"
    }

    private lateinit var FoodViewModel: foodViewModel
    private var photo = 0
    private var quantity = 0
    private var price = 0
    private var name = ""
    private var bayar = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        // deklarasi viewModel
        FoodViewModel = ViewModelProvider(this).get(foodViewModel::class.java)

        // set judul
        supportActionBar?.title = "Pemesanan " + intent.getStringExtra(DetailActivity.NAMA)

        var username = intent.getStringExtra(DetailActivity.USERNAME)
        var foodId = 0

        //menangkap data nama, harga, photo dari intent dan set ke textView
        val nameMakananText = findViewById<View>(R.id.nama_makanan) as TextView
        name = intent.getStringExtra(NAMA).toString()
        nameMakananText.text=name

        val hargaSatuanText = findViewById<View>(R.id.harga_asli) as TextView
        price = intent.getIntExtra(PRICE, 0)
        hargaSatuanText.text= price.toString()

        photo = intent.getIntExtra(PHOTO, 0)

        // hitung harga
        hitung_order.setOnClickListener{
            bayar = calculateprice() //memanggil method jumlah harga
            val priceTextView = findViewById<View>(R.id.price_textview) as TextView
            priceTextView.text = bayar.toString()
        }

        pesan_order.setOnClickListener {
            //cek kuantitas dan bayar
            if (quantity == 0) {
                Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (quantity == 101) {
                Toast.makeText(this, "pesanan maximal 100", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (bayar == 0){
                Toast.makeText(this, "Hitung total terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //Insert DB
            //memasukkan data ke objek
            username = username.toString()
            val food = food(foodId, username!!, name, bayar, quantity, photo)
            food.name = name
            food.price = bayar
            food.quantity = quantity
            food.photo = photo

            //masukkan data ke db
            FoodViewModel.insert(food)

            //Intent ke halaman summary
            val dataSummary = Intent(baseContext, SummaryPesanActivity::class.java)

            dataSummary.putExtra(SummaryPesanActivity.NAMA, name)
            dataSummary.putExtra(SummaryPesanActivity.PRICE, price)
            dataSummary.putExtra(SummaryPesanActivity.TOTAL, bayar)
            dataSummary.putExtra(SummaryPesanActivity.JUMLAH, quantity)

            startActivity(dataSummary)
            finish()

        }

        increment.setOnClickListener {
            increment()
        }

        decrement.setOnClickListener {
            decrement()
        }
    }

    fun increment() { //perintah tombol tambah
        if (quantity == 100) {
            Toast.makeText(this, "pesanan maximal 100", Toast.LENGTH_SHORT).show()
            return
        }
        quantity = quantity + 1
        display(quantity)
    }

    fun decrement() { //perintah tombol berkurang
        if (quantity == 1) {
            Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show()
            return
        }
        quantity = quantity - 1
        display(quantity)
    }

    //method hitung harga
    private fun calculateprice(): Int { //jumlah pesanan * harga
        var harga = price * quantity
        return harga
    }

    //method tampil quantity
    private fun display(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_textview) as TextView
        quantityTextView.text = "" + number
    }
}