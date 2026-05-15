package com.lithub.app
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val cardBooks = listOf<CardBook>(
            CardBook(
                "1984",
                "George Orwell",
                "Distopia clássica sobre vigilância, controle estatal e manipulação da verdade em uma sociedade totalitária.",
                R.drawable.livro2),
            CardBook(
                "Dom Casmurro",
                "Machado De Assis",
                "Romance brasileiro sobre memória, ciúme e dúvida, narrado por Bentinho ao revisitar sua história com Capitu.",
                R.drawable.livro4),
            CardBook(
                "O Pequeno Príncipe",
                "Antoine de Saint-Exupéry",
                "Fábula poética em que um menino viaja por planetas e revela lições sobre afeto, amizade e sentido da vida.",
                R.drawable.livro5),
            CardBook("Sapiens",
                "Yuval Noah Harari",
                "Panorama acessível da história da humanidade, das origens do Homo sapiens às estruturas sociais modernas.",
                R.drawable.livro1)

        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = CardBookListAdapter(cardBooks)





    }







}