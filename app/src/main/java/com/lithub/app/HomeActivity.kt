package com.lithub.app

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_chat -> startActivity(Intent(this, ChatHistoryActivity::class.java))
                R.id.nav_notifications -> startActivity(Intent(this, NotificationsActivity::class.java))
            }
            true
        }
    }
}