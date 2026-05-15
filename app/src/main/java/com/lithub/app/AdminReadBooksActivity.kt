package com.lithub.app
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class AdminReadBooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_read_books)
        findViewById<CardView>(R.id.Book1).setOnClickListener { startActivity(Intent(this, AdminBookDetailActivity::class.java)) }
    }
}