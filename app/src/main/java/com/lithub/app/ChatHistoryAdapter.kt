package com.lithub.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatHistoryAdapter(private val context: Context, private val items: List<ChatHistoryItem>, private val onClick: (ChatHistoryItem) -> Unit) : RecyclerView.Adapter<ChatHistoryAdapter.ChatViewHolder>() {
    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_chat_history, parent, false)
        return ChatViewHolder(view)
    }
    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.findViewById<TextView>(R.id.tvName).text = item.name
        holder.itemView.findViewById<TextView>(R.id.tvPreview).text = item.preview
        holder.itemView.findViewById<TextView>(R.id.tvTime).text = item.time
        holder.itemView.setOnClickListener { onClick(item) }
    }
    override fun getItemCount() = items.size
}