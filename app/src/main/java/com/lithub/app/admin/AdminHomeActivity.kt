package com.lithub.app.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lithub.app.R

class AdminHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)
        findViewById<Button>(R.id.btnOnlineStudents).setOnClickListener { startActivity(
            Intent(
                this,
                AdminStudentsActivity::class.java
            )
        ) }
        findViewById<Button>(R.id.btnTotalStudents).setOnClickListener { startActivity(
            Intent(
                this,
                AdminStudentsActivity::class.java
            )
        ) }
    }
}