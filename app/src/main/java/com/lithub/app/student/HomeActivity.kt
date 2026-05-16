package com.lithub.app.student

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.lithub.app.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<Button>(R.id.btnRentGames).setOnClickListener { startActivity(Intent(this, GamesActivity::class.java)) }
        findViewById<Button>(R.id.btnRentBooks).setOnClickListener { startActivity(Intent(this, BooksActivity::class.java)) }
        findViewById<CardView>(R.id.cardBook).setOnClickListener { startActivity(Intent(this, BookDetailsActivity::class.java)) }
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_books -> startActivity(Intent(this, MyBooksActivity::class.java))
                R.id.nav_chat -> startActivity(Intent(this, ChatHistoryActivity::class.java))
                R.id.nav_notifications -> startActivity(Intent(this, NotificationsActivity::class.java))
                R.id.nav_profile -> startActivity(Intent(this, ProfileActivity::class.java))
            }
            true
        }
    }
}