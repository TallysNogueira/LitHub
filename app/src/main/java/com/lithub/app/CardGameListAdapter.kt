package com.lithub.app

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class CardGameListAdapter(val games: List<Game>): RecyclerView.Adapter<CardGameListAdapter.CardGameViewHolder>() {

   class CardGameViewHolder(view: View): RecyclerView.ViewHolder(view){

       val title = view.findViewById<TextView>(R.id.txtTituloJogo)
       val desc = view.findViewById<TextView>(R.id.txtDescJogo)
       val img = view.findViewById<ImageView>(R.id.imgJogo)

       val rule = view.findViewById<TextView>(R.id.txtRegraJogo)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardGameListAdapter.CardGameViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_cardgame,parent,false)

        return CardGameViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardGameViewHolder, position: Int) {

        val game = games[position]

        holder.title.text = game.title
        holder.desc.text = game.desc
        holder.img.setImageResource(game.image)
        holder.rule.text = game.rules

        val context = holder.itemView.context





        holder.itemView.setOnClickListener {
            rentGameDialog(context,game)
        }


    }

    override fun getItemCount(): Int {
        return games.size
    }

    fun rentGameDialog(context: Context, game: Game){

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_rental_games,null)

        val txtTitle = dialogView.findViewById<TextView>(R.id.txtTitle)
        val btnConfirm = dialogView.findViewById<Button>(R.id.buttonConfirm)
        val btnCancel = dialogView.findViewById<Button>(R.id.buttonCancel)

        txtTitle.text = "Aluguel - ${game.title}"



        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        btnConfirm.setOnClickListener { dialog.dismiss() }
        btnCancel.setOnClickListener { dialog.dismiss() }

        dialog.show()


    }


}