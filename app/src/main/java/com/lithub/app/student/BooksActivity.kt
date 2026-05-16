package com.lithub.app.student
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.lithub.app.R
import com.lithub.app.adapter.CardBookListAdapter
import com.lithub.app.dataclass.CardBook

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        val input_search_books = findViewById<EditText>(R.id.input_search_books)

        //Lista inicial de livros (Dataclass)
        val cardBooks = mutableListOf<CardBook>(
            CardBook(
                "1984",
                "George Orwell",
                "Distopia clássica sobre vigilância, controle estatal e manipulação da verdade em uma sociedade totalitária.",
                R.drawable.livro2
            ),
            CardBook(
                "Dom Casmurro",
                "Machado De Assis",
                "Romance brasileiro sobre memória, ciúme e dúvida, narrado por Bentinho ao revisitar sua história com Capitu.",
                R.drawable.livro4
            ),
            CardBook(
                "O Pequeno Príncipe",
                "Antoine de Saint-Exupéry",
                "Fábula poética em que um menino viaja por planetas e revela lições sobre afeto, amizade e sentido da vida.",
                R.drawable.livro5
            ),
            CardBook(
                "Sapiens",
                "Yuval Noah Harari",
                "Panorama acessível da história da humanidade, das origens do Homo sapiens às estruturas sociais modernas.",
                R.drawable.livro1
            )

        )

        //Pega a referência do RecyclerView no layout
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        //o LayoutManager define como as informações serão mostradas dentro da lista
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Definição do Adapter, componente que será responsável por colocar os itens da lista no RecyclerView
        var adapter = CardBookListAdapter(cardBooks)

        //RecyclerView vai usar o adapter como display das informações
        recyclerView.adapter = adapter

       input_search_books.setOnEditorActionListener { v, actionId, event ->

           //Usuário clica no botão de pesquisar e busca o resultado no banco de dados
           if (actionId == EditorInfo.IME_ACTION_SEARCH){

               //Converte o texto dentro do EditText para String
               val text = input_search_books.text.toString().trim()

               //Pesquisa no banco de dados se o campo não estiver vazio
               if (!text.isEmpty()){

                   //Cria instância do Firestore
                   val db = FirebaseFirestore.getInstance()

                   //Checa na coleção se o texto digitado pelo usuário está no banco de dados
                   db.collection("livros")
                       .whereEqualTo("titulo",text)
                       .get()
                       .addOnSuccessListener { documentos ->

                           //Quando a consulta é bem sucedida a lista de livros é atualizada
                           cardBooks.clear()

                           //Extrai cada informação no documento do Firebase
                           for (documento in documentos){
                               val title = documento.getString("titulo").toString()
                               val autor = documento.getString("autor").toString()
                               val sinopse = documento.getString("sinopse").toString()

                               //A lista é atualizada e um livro é adicionado
                               //o livro é preenchido com as infos do banco de dados
                               cardBooks.add(
                                   CardBook(
                                       title,
                                       autor,
                                       sinopse,
                                       R.color.primary_soft
                                   )
                               )

                           }

                           //Sinaliza para o RecyclerView que a lista foi atualizada
                           adapter.notifyDataSetChanged()


                       }
                       .addOnFailureListener {

                           Toast.makeText(
                               this,
                               "Falha ao conectar com banco de dados",
                               Toast.LENGTH_SHORT)
                               .show()
                       }


               }else{
                    //Caso o campo digitado seja vazio a lista não "muda"

                   cardBooks.clear()
                    cardBooks.add(
                        CardBook(
                            "1984",
                            "George Orwell",
                            "Distopia clássica sobre vigilância, controle estatal e manipulação da verdade em uma sociedade totalitária.",
                            R.drawable.livro2
                        )
                    )

                   cardBooks.add(
                       CardBook(
                           "Dom Casmurro",
                           "Machado De Assis",
                           "Romance brasileiro sobre memória, ciúme e dúvida, narrado por Bentinho ao revisitar sua história com Capitu.",
                           R.drawable.livro4
                       )
                   )

                   cardBooks.add(
                       CardBook(
                           "O Pequeno Príncipe",
                           "Antoine de Saint-Exupéry",
                           "Fábula poética em que um menino viaja por planetas e revela lições sobre afeto, amizade e sentido da vida.",
                           R.drawable.livro5
                       )
                   )

                   cardBooks.add(
                       CardBook(
                           "Sapiens",
                           "Yuval Noah Harari",
                           "Panorama acessível da história da humanidade, das origens do Homo sapiens às estruturas sociais modernas.",
                           R.drawable.livro1
                       )
                    )


               }




               true
           }
           else{
               false
           }
       }



    }









}