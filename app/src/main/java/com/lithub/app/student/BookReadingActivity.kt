package com.lithub.app.student
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lithub.app.R

class BookReadingActivity : AppCompatActivity(){
 override fun onCreate(savedInstanceState: Bundle?){
  super.onCreate(savedInstanceState); setContentView(R.layout.activity_book_reading)
  findViewById<Button>(R.id.btnNextReading).setOnClickListener { startActivity(Intent(this, BookEndChapterActivity::class.java)) }
 }
}