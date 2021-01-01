package com.dicoding.picodiploma.ProjectUAS

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_pesan.*

class PesanActivity : AppCompatActivity() {

    companion object{
        const val NAMA = "extra_name"
        const val PRICE = "extra_price"
        const val PHOTO = "extra_photo"
        const val JUMLAH = "extra_jumlah"
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

        //menangkap data nama, harga, photo dari intent dan set ke textView
        val nameMakananText = findViewById<View>(R.id.nama_makanan) as TextView
        name = intent.getStringExtra(DetailActivity.NAMA).toString()
        nameMakananText.text=name

        val hargaSatuanText = findViewById<View>(R.id.harga_asli) as TextView
        price = intent.getIntExtra(DetailActivity.PRICE, 0)
        hargaSatuanText.text= price.toString()

        photo = intent.getIntExtra(DetailActivity.PRICE, 0)

        hitung_order.setOnClickListener{
            bayar = calculateprice() //memanggil method jumlah harga
            displayMessage(bayar)
        }

        pesan_order.setOnClickListener {
            //Insert DB
            //memasukkan data ke objek
            var food = food(name, price, quantity, photo)

            //masukkan data ke db
            FoodViewModel.insert(food)

            //Intent ke halaman summary
            val dataSummary = Intent(baseContext, SummaryPesanActivity::class.java)

            dataSummary.putExtra(SummaryPesanActivity.NAMA, name)
            dataSummary.putExtra(SummaryPesanActivity.PRICE, price)
            dataSummary.putExtra(SummaryPesanActivity.JUMLAH, quantity)

            startActivity(dataSummary)

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

    private fun calculateprice(): Int { //jumlah pesanan * harga
        var harga = price * quantity
        return harga
    }

//    private fun submitOrderSummary(price: Int, name: String): String { //hasil pemesanan
//        val priceMakananText = findViewById<View>(R.id.ringkasan) as TextView
//        priceMakananText.text = price.toString()
//
////        //NAMA, PRICE, QUANTITY berhasil ketangkep
//        var pricemessage = "\n PESANAN DITERIMA"
//        pricemessage += "\n Nama = $name"
//        pricemessage += "\n Jumlah Pemesanan =$quantity"
//        pricemessage += "\n Total = Rp $price"
//        pricemessage += "\n Terimakasih"
//        return pricemessage
//    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private fun displayMessage(message: Int) {
        val priceTextView = findViewById<View>(R.id.price_textview) as TextView
        priceTextView.text = message.toString()
    }

    private fun display(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_textview) as TextView
        quantityTextView.text = "" + number
    }
}