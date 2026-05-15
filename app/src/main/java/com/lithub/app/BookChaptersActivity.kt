package com.lithub.app
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
class BookChaptersActivity : AppCompatActivity(){
 override fun onCreate(savedInstanceState: Bundle?){
  super.onCreate(savedInstanceState); setContentView(R.layout.activity_book_chapters)
  findViewById<Button>(R.id.btnChapter1).setOnClickListener { startActivity(Intent(this, BookReadingActivity::class.java)) }
 }
}