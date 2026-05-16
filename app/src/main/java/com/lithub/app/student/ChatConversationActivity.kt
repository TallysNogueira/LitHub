package com.lithub.app.student

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lithub.app.R
import com.lithub.app.adapter.ChatMessageAdapter
import com.lithub.app.dataclass.Message

class ChatConversationActivity : AppCompatActivity() {
    private val messages = mutableListOf(
        Message("Olá, tudo bem?", true),
        Message("Tudo ótimo, e com você? Estou com uma dúvida sobre aquele exemplar.", false),
        Message("Sim, claro. Ele é a primeira edição?", true)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_conversation)
        val recycler = findViewById<RecyclerView>(R.id.recyclerMessages)
        val input = findViewById<EditText>(R.id.etMessage)
        val send = findViewById<ImageButton>(R.id.btnSend)
        val adapter = ChatMessageAdapter(this, messages)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
        findViewById<ImageView>(R.id.btnBack).setOnClickListener { finish() }
        send.setOnClickListener {
            val text = input.text.toString().trim()
            if (text.isNotEmpty()) {
                messages.add(Message(text, true))
                adapter.notifyItemInserted(messages.size - 1)
                recycler.scrollToPosition(messages.size - 1)
                input.text.clear()
            }
        }
    }
}