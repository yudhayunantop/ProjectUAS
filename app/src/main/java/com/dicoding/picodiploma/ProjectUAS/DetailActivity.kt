package com.dicoding.picodiploma.ProjectUAS

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    companion object{
        const val NAMA = "extra_name"
        const val DETAIL = "extra_detail"
        const val PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = intent.getStringExtra(NAMA)

        val tvDataName: TextView = findViewById(R.id.tv_item_name)
        val ivPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvDataDetail: TextView = findViewById(R.id.tv_item_detail)

        val name = intent.getStringExtra(NAMA)
        val text1 = "$name"
        tvDataName.text = text1


        val detail = intent.getStringExtra(DETAIL)
        val text2 = "$detail"
        tvDataDetail.text = text2

        val photo = intent.getIntExtra(PHOTO, 0)
        ivPhoto.setImageResource(photo)
    }
}