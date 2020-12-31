package com.dicoding.picodiploma.ProjectUAS

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pesan.*

class PesanActivity : AppCompatActivity() {

    companion object{
        const val NAMA = "extra_name"
        const val PRICE = "extra_price"
    }

    private var quantity = 0
    private var price = 0
    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        // set judul
        supportActionBar?.title = "Pemesanan " + intent.getStringExtra(DetailActivity.NAMA)

        //masukkan nama dan harga
        val nameMakananText = findViewById<View>(R.id.nama_makanan) as TextView
        name = intent.getStringExtra(DetailActivity.NAMA).toString()
        nameMakananText.text=name

        price = intent.getIntExtra(DetailActivity.PRICE, 0)

        submit_order.setOnClickListener{
            val bayar = calculateprice() //memanggil method jumlah harga
            val pricemessage = createOrderSummary(bayar, name)
            displayMessage(pricemessage)
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

    private fun createOrderSummary(price: Int, name: String): String { //hasil pemesanan
        val priceMakananText = findViewById<View>(R.id.price_textview) as TextView
        priceMakananText.text = price.toString()

        //NAMA, PRICE, QUANTITY berhasil ketangkep
        var pricemessage = "\n PESANAN DITERIMA"
        pricemessage += "\n Nama = $name"
        pricemessage += "\n Jumlah Pemesanan =$quantity"
        pricemessage += "\n Total = Rp $price"
        pricemessage += "\n Terimakasih"
        return pricemessage
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private fun displayMessage(message: String) {
        val priceTextView = findViewById<View>(R.id.price_textview) as TextView
        priceTextView.text = message
    }

    private fun display(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_textview) as TextView
        quantityTextView.text = "" + number
    }
}