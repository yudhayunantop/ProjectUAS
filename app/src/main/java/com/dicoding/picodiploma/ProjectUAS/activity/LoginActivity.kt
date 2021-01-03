package com.dicoding.picodiploma.ProjectUAS.activity

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.dicoding.picodiploma.ProjectUAS.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var username = ""
    var password = ""

    companion object{
        const val USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // deklarasi xml
        val usernameText = findViewById<View>(R.id.InputUsername) as TextView
        val passwordText = findViewById<View>(R.id.InputPassword) as TextView

        //menambahkan button login
        btnLogin.setOnClickListener {

            //ambil username dan password
            username = usernameText.text.toString()
            password = passwordText.text.toString()

            //cek username password
            when {
                username.isEmpty()|| password.isEmpty() -> Toast.makeText(this, "Masukkan Email and Password", Toast.LENGTH_SHORT).show()
                username == "pembeli" && password == "pembeli" -> login()
                username == "abc" && password == "abc" -> login()
                username == "123" && password == "123" -> login()
                else -> Toast.makeText(this, "Username / Password salah", Toast.LENGTH_SHORT).show()
            }
    }
}

    // method login
    private fun login() {
        val progressDialog = ProgressDialog(this,
            R.style.Theme_MaterialComponents_Light_Dialog)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Loading...")
        progressDialog.show()
        val intent = Intent (this, MainActivity::class.java)
        intent.putExtra(MainActivity.USERNAME, username)
        startActivity(intent)
        finish()
    }
}
