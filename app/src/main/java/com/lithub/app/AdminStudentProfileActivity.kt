package com.lithub.app
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
class AdminStudentProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_student_profile)
        findViewById<LinearLayout>(R.id.btnAdminReadBooks).setOnClickListener { startActivity(Intent(this, AdminReadBooksActivity::class.java)) }
        findViewById<LinearLayout>(R.id.btnAdminRequests).setOnClickListener { startActivity(Intent(this, AdminRequestActivity::class.java)) }
    }
}