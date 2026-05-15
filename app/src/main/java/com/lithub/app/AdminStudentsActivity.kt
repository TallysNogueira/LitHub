package com.lithub.app
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class AdminStudentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_students)
        findViewById<CardView>(R.id.btnViewStudent).setOnClickListener { startActivity(Intent(this, AdminStudentProfileActivity::class.java)) }
    }
}