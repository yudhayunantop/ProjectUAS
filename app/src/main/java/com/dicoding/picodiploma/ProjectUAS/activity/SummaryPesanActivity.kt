package com.dicoding.picodiploma.ProjectUAS.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.dicoding.picodiploma.ProjectUAS.R
import kotlinx.android.synthetic.main.activity_summary_pesan.*

class SummaryPesanActivity : AppCompatActivity() {

    companion object{
        const val NAMA = "extra_name"
        const val PRICE = "extra_price"
        const val JUMLAH = "extra_jumlah"
        const val TOTAL = "extra_total"
        const val USERNAME = "extra_username"
    }

    private var quantity = 0
    private var price = 0
    private var total = 0
    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary_pesan)

        // set judul
        supportActionBar?.title = intent.getStringExtra(PesanActivity.NAMA)

        var username = intent.getStringExtra(PesanActivity.USERNAME)

        //menangkap data nama, harga, jumlah dari intent dan set ke textView
        val nameMakananText = findViewById<View>(R.id.nama_makanan) as TextView
        name = intent.getStringExtra(NAMA).toString()
        nameMakananText.text=name

        val hargaSatuText = findViewById<View>(R.id.harga_asli) as TextView
        price = intent.getIntExtra(PRICE,0)
        hargaSatuText.text= price.toString()

        val hargaTotalText = findViewById<View>(R.id.price_textview) as TextView
        total = intent.getIntExtra(TOTAL,0)
        hargaTotalText.text= total.toString()

        val quantityMakananText = findViewById<View>(R.id.quantity_textview) as TextView
        quantity = intent.getIntExtra(JUMLAH,0)
        quantityMakananText.text= quantity.toString()

        //button intent ke halaman MainAcitivity
        kembali.setOnClickListener {
            val back = Intent(baseContext, MainActivity::class.java)
            back.putExtra(MainActivity.USERNAME, username)
            startActivity(back)
            finish()
        }

    }
}