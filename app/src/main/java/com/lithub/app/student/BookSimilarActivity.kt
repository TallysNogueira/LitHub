package com.lithub.app.student
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lithub.app.R
import com.lithub.app.adapter.SimilarBookListAdapter
import com.lithub.app.dataclass.Book

class BookSimilarActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_similar)

        val books = listOf<Book>(
            Book("Aventura ", R.color.primary_soft, "O Segredo da Floresta"),
            Book("Mistério ", R.color.primary_soft, "Cartas para o futuro"),
            Book("Aventura ", R.color.primary_soft, "A Herança do deserto"),
            Book("Mistério ", R.color.primary_soft, "A Chave do templo"),
            Book("Mistério ", R.color.primary_soft, "Caminhos Cruzados"),
            Book("Aventura ", R.color.primary_soft, "O Olho do Dragão"),
            Book("Aventura ", R.color.primary_soft, "A Última Viagem"),
            Book("Aventura ", R.drawable.livro3, "O Alquimista")

        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        recyclerView.adapter = SimilarBookListAdapter(books)


    }





}