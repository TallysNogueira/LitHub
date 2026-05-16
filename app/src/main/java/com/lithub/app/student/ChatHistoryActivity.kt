package com.lithub.app.student

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lithub.app.R
import com.lithub.app.adapter.ChatHistoryAdapter
import com.lithub.app.dataclass.ChatHistoryItem

class ChatHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_history)
        val items = listOf(
            ChatHistoryItem("Ana Silva", "leu o livro que eu recomendei?", "10:15"),
            ChatHistoryItem("Carlos Mendes", "Sim, eu tenho esse exemplar.", "9:30"),
            ChatHistoryItem("Juliana Gomes", "Obrigada pela dica de leitura!", "Ontem"),
            ChatHistoryItem("Kaura Martin", "Obrigada pela dica de leitura!", "Ontem"),
            ChatHistoryItem("Anana Cunitas", "Obrigada pela dica de leitura!", "Ontem"),
            ChatHistoryItem("Carlos Marder", "leu o livro que eu recomendei?", "Ontem")
        )
        val recycler = findViewById<RecyclerView>(R.id.recyclerChats)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ChatHistoryAdapter(this, items) {
            startActivity(
                Intent(
                    this,
                    ChatConversationActivity::class.java
                )
            )
        }
        findViewById<FloatingActionButton>(R.id.fabChat).setOnClickListener { startActivity(Intent(this, ChatConversationActivity::class.java)) }
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_chat
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> startActivity(Intent(this, HomeActivity::class.java))
                R.id.nav_books ->startActivity(Intent(this, MyBooksActivity::class.java ))
                R.id.nav_notifications -> startActivity(Intent(this, NotificationsActivity::class.java))
                R.id.nav_profile -> startActivity(Intent(this, ProfileActivity::class.java))
            }
            true
        }
    }
}