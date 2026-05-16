package com.lithub.app.admin
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.lithub.app.R

class AdminStudentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_students)
        findViewById<CardView>(R.id.btnViewStudent).setOnClickListener { startActivity(Intent(this, AdminStudentProfileActivity::class.java)) }
    }
}