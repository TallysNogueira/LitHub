package com.lithub.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.firestore.FirebaseFirestore

class BookDetailsActivity : AppCompatActivity() {

    private lateinit var txtTituloDetalhes: TextView
    private lateinit var txtAutorDetalhes: TextView
    private lateinit var txtSinopseDetalhes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_book_details)

        txtTituloDetalhes = findViewById(R.id.txtTituloDetalhes)
        txtAutorDetalhes = findViewById(R.id.txtAutorDetalhes)
        txtSinopseDetalhes = findViewById(R.id.txtSinopseDetalhes)

        val tituloLivro = intent.getStringExtra("tituloLivro")

        val db = FirebaseFirestore.getInstance()

        db.collection("livros")
            .whereEqualTo("titulo", tituloLivro)
            .get()
            .addOnSuccessListener { documentos ->

                for (documento in documentos) {

                    val titulo = documento.getString("titulo")
                    val autor = documento.getString("autor")
                    val sinopse = documento.getString("sinopse")

                    txtTituloDetalhes.text = titulo
                    txtAutorDetalhes.text = autor
                    txtSinopseDetalhes.text = sinopse
                }
            }

            .addOnFailureListener {

            }

        findViewById<Button>(R.id.btnReviews).setOnClickListener {
            startActivity(Intent(this, BookReviewsActivity::class.java))
        }

        findViewById<Button>(R.id.btnRead).setOnClickListener {
            startActivity(Intent(this, BookChaptersActivity::class.java))
        }

        findViewById<Button>(R.id.btnSimilar).setOnClickListener {
            startActivity(Intent(this, BookSimilarActivity::class.java))
        }
    }
}