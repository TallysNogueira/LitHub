package com.lithub.app.student
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lithub.app.R
import com.lithub.app.adapter.MyBooksListAdapter


class MyBooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_books)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // 3 colunas
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val images = listOf<Int?>(
            R.drawable.livro1,
            R.drawable.livro2,
            R.drawable.livro3,
            R.drawable.livro4,
            R.drawable.livro5,
            R.drawable.livro6,
            R.drawable.livro7,
            R.drawable.livro8,
            R.drawable.livro9
        )

        val adapter: MyBooksListAdapter = MyBooksListAdapter(images)
        recyclerView.setAdapter(adapter)





        val bottom = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottom.selectedItemId = R.id.nav_books
        bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> startActivity(Intent(this, HomeActivity::class.java))
                R.id.nav_chat -> startActivity(Intent(this, ChatHistoryActivity::class.java))
                R.id.nav_notifications -> startActivity(Intent(this, NotificationsActivity::class.java))
                R.id.nav_profile -> startActivity(Intent(this, ProfileActivity::class.java))
            }
            true
        }
    }
}