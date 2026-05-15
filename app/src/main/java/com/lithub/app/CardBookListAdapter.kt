package com.lithub.app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView

class CardBookListAdapter(private val cardBooks: List<CardBook>): RecyclerView.Adapter<CardBookListAdapter.CardBookViewHolder>(){

    class CardBookViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val img = view.findViewById<ImageView>(R.id.imgBook)
        val title = view.findViewById<TextView>(R.id.txtTitle)
        val author = view.findViewById<TextView>(R.id.txtAuthor)
        val synopsis = view.findViewById<TextView>(R.id.txtSynopsis)

        val btnLayout = view.findViewById<LinearLayout>(R.id.buttonsLayout)

        val btnDetails = view.findViewById<Button>(R.id.btnDetails)

        val btnRent = view.findViewById<Button>(R.id.btnRent)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardBookViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_cardbook,parent,false)

        return CardBookViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardBookViewHolder, position: Int) {

        val book = cardBooks[position]

        holder.img.setImageResource(book.image)
        holder.title.text = book.title
        holder.author.text = book.author
        holder.synopsis.text = book.synopsis

        holder.itemView.setOnClickListener {
            if(holder.btnLayout.isGone){
                holder.btnLayout.visibility = View.VISIBLE
            } else {
                holder.btnLayout.visibility = View.GONE
            }
        }

        holder.btnDetails.setOnClickListener {

            val context = holder.itemView.context
            val intent = Intent(context, BookDetailsActivity::class.java)

            intent.putExtra("tituloLivro",book.title)
            context.startActivity(intent)
        }

        holder.btnRent.setOnClickListener {
            val context = holder.itemView.context
            rentBookDialog(context, book)

        }


    }

    override fun getItemCount(): Int {
        return cardBooks.size
    }

    //Função para criar a tela de aluguel de livros
    fun rentBookDialog(context: Context,book:CardBook ){

        //Configuração do Dialog
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_rental_books, null)
        val spinner = dialogView.findViewById<Spinner>(R.id.spinnerDays)
        val confirmBtn = dialogView.findViewById<Button>(R.id.confirmBtn)
        val cancelBtn = dialogView.findViewById<Button>(R.id.cancelBtn)

        //Display das informações no Dialog
        val bookTitle = dialogView.findViewById<TextView>(R.id.book_title)
        val bookAuthor = dialogView.findViewById<TextView>(R.id.book_author)
        val imgRentBook = dialogView.findViewById<ImageView>(R.id.imgRentBook)

        //Altera as informações de acordo com o livro escolhido
        bookTitle.text = book.title
        bookAuthor.text = book.author
        imgRentBook.setImageResource(book.image)




        val options = listOf(
            "3 Dias",
            "5 Dias",
            "7 Dias",
            "14 Dias"
        )

        val adapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_dropdown_item,
            options
        )

        spinner.adapter = adapter

        val dialog = AlertDialog.Builder(context)
            .setView(dialogView)
            .create()

        confirmBtn.setOnClickListener { dialog.dismiss() }
        cancelBtn.setOnClickListener { dialog.dismiss() }



        dialog.show()



    }



}



