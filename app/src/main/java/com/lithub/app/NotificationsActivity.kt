package com.lithub.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class NotificationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_notifications
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> startActivity(Intent(this, HomeActivity::class.java))
                R.id.nav_chat -> startActivity(Intent(this, ChatHistoryActivity::class.java))
            }
            true
        }
    }
}