package com.dicoding.picodiploma.ProjectUAS

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SummaryPesanActivity : AppCompatActivity() {

    companion object{
        const val NAMA = "extra_name"
        const val PRICE = "extra_price"
        const val JUMLAH = "extra_jumlah"
    }

    private var quantity = 0
    private var price = 0
    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_pesan)

        // set judul
        supportActionBar?.title = intent.getStringExtra(PesanActivity.NAMA)

        //menangkap data nama, harga, photo dari intent dan set ke textView
        val nameMakananText = findViewById<View>(R.id.nama_makanan) as TextView
        name = intent.getStringExtra(PesanActivity.NAMA).toString()
        nameMakananText.text=name

        val hargaSatuanText = findViewById<View>(R.id.harga_asli) as TextView
        price = intent.getIntExtra(PesanActivity.PRICE, 0)
        hargaSatuanText.text= price.toString()

        val quantityMakananText = findViewById<View>(R.id.quantity_textview) as TextView
        quantity = intent.getIntExtra(PesanActivity.JUMLAH, 0)
        quantityMakananText.text= quantity.toString()
    }
}