package com.lithub.app
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class AdminRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_request)

        val btnLayout = findViewById<LinearLayout>(R.id.buttonsLayout)
        findViewById<CardView>(R.id.Item1).setOnClickListener { btnLayout.visibility = View.VISIBLE }
        findViewById<CardView>(R.id.Item2).setOnClickListener { startActivity(Intent(this, AdminGameDetailActivity::class.java)) }
        findViewById<Button>(R.id.btnAcceptRequest).setOnClickListener { startActivity(Intent(this, AdminRecordsActivity::class.java)) }
        findViewById<Button>(R.id.btnRejectRequest).setOnClickListener { startActivity(Intent(this, AdminRecordsActivity::class.java)) }
    }
}