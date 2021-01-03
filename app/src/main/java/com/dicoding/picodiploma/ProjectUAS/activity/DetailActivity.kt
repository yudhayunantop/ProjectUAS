package com.dicoding.picodiploma.ProjectUAS.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.ProjectUAS.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object{
        const val NAMA = "extra_name"
        const val DETAIL = "extra_detail"
        const val PRICE = "extra_price"
        const val PHOTO = "extra_photo"
        const val USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //set judul
        supportActionBar?.title = intent.getStringExtra(NAMA)

        //deklarasi id pada xml
        val tvDataName: TextView = findViewById(R.id.tv_item_name)
        val ivPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvDataPrice: TextView = findViewById(R.id.tv_item_harga)
        val tvDataDetail: TextView = findViewById(R.id.tv_item_detail)

        //ambil username
        val username = intent.getStringExtra(USERNAME)

        //get item + set ke xml
        val name = intent.getStringExtra(NAMA)
        val text1 = "$name"
        tvDataName.text = text1

        val price = intent.getIntExtra(PRICE, 0)
        val text2 = "$price"
        tvDataPrice.text = text2

        val detail = intent.getStringExtra(DETAIL)
        val text3 = "$detail"
        tvDataDetail.text = text3

        val photo = intent.getIntExtra(PHOTO, 0)
        ivPhoto.setImageResource(photo)

        //onClick buttonPesan
        buttonPesan.setOnClickListener {
            //intent ke halaman PesanActivity
            val dataPesanan = Intent(baseContext, PesanActivity::class.java)

            dataPesanan.putExtra(PesanActivity.USERNAME, username)
            dataPesanan.putExtra(PesanActivity.NAMA, name)
            dataPesanan.putExtra(PesanActivity.PRICE, price)
            dataPesanan.putExtra(PesanActivity.PHOTO, photo)

            startActivity(dataPesanan)
            finish()
        }
    }
}