package com.lithub.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecoverPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)
        val back = findViewById<TextView>(R.id.tvBackLogin)
        val email = findViewById<EditText>(R.id.etEmail)
        val btn = findViewById<Button>(R.id.btnRecover)
        val title = findViewById<TextView>(R.id.tvRecoverErrorTitle)
        val body = findViewById<TextView>(R.id.tvRecoverErrorBody)
        back.setOnClickListener { finish() }
        btn.setOnClickListener {
            if (email.text.toString().trim().equals("usuario@lithub.com", true)) {
                finish()
            } else {
                email.setText("usuario.invalido@exemplo.com")
                email.setBackgroundResource(R.drawable.rounded_shape_2)
                title.visibility = View.VISIBLE
                body.visibility = View.VISIBLE
                btn.setOnClickListener { finish() }
            }
        }
    }
}