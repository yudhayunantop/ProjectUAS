package com.dicoding.picodiploma.ProjectUAS

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class PesanActivity : AppCompatActivity() {

    private var quantity = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)
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

    fun submitorder() {
        val nameEditText = findViewById<View>(R.id.edt_name) as EditText
        val name = nameEditText.text.toString()
        Log.v("MainActivity", "Nama:$name")
        val whippedcreamChekBox = findViewById<View>(R.id.WhippedCream_checkbox) as CheckBox
        val haswhippedcream = whippedcreamChekBox.isChecked //mengidentifikasi check
        Log.v("MainActivity", "has whippedcream:$haswhippedcream")
        val chocolateChekBox = findViewById<View>(R.id.Chocolate_checkbox) as CheckBox
        val haschocolate = chocolateChekBox.isChecked //mengidentifikasi check
        Log.v("MainActivity", "has whippedcream:$haschocolate")
        val price = calculateprice(haswhippedcream, haschocolate) //memanggil method jumlah harga
        val pricemessage = createOrderSummary(price, name, haswhippedcream, haschocolate)
        displayMessage(pricemessage)
    }

    private fun calculateprice(addwhipedcream: Boolean, addchocolate: Boolean): Int { //jumlah pesanan * harga
        var harga = 5000
        if (addwhipedcream) {
            harga = harga + 1000 //harga tambahan toping
        }
        if (addchocolate) {
            harga = harga + 2000
        }
        return quantity * harga
    }

    private fun createOrderSummary(price: Int, name: String, addChocolate: Boolean, addWhippedCream: Boolean): String { //hasil pemesanan
        var pricemessage = " Nama = $name"
        pricemessage += "\n Tambahkan Coklat =$addWhippedCream"
        pricemessage += "\n Tambahkan Krim =$addChocolate"
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