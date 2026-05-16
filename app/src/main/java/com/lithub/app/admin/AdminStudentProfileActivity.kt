package com.lithub.app.admin
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.lithub.app.R

class AdminStudentProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_student_profile)
        findViewById<LinearLayout>(R.id.btnAdminReadBooks).setOnClickListener { startActivity(Intent(this, AdminReadBooksActivity::class.java)) }
        findViewById<LinearLayout>(R.id.btnAdminRequests).setOnClickListener { startActivity(Intent(this, AdminRequestActivity::class.java)) }
    }
}