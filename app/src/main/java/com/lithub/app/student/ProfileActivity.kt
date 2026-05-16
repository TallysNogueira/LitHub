package com.lithub.app.student
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lithub.app.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        findViewById<Button>(R.id.btnOpenPhoto).setOnClickListener { startActivity(Intent(this, ProfilePhotoActivity::class.java)) }
        val bottom = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottom.selectedItemId = R.id.nav_profile
        bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> startActivity(Intent(this, HomeActivity::class.java))
                R.id.nav_books -> startActivity(Intent(this, MyBooksActivity::class.java))
                R.id.nav_chat -> startActivity(Intent(this, ChatHistoryActivity::class.java))
                R.id.nav_notifications -> startActivity(Intent(this, NotificationsActivity::class.java))
            }
            true
        }
    }
}