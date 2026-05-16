package com.lithub.app.student

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.lithub.app.R
import com.lithub.app.adapter.CardGameListAdapter
import com.lithub.app.dataclass.Game

class GamesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val cardGames = mutableListOf<Game>(
            Game("Expedição á Atlântida", "", R.color.primary_soft, ""),
            Game(
                "O Código do Alquimista",
                "Neste jogo, os participantes assumem o papel de aprendizes em busca de conhecimentos antigos e fórmulas secretas. É preciso decifrar pistas e combinar elementos de forma inteligente para avançar. A lógica e a dedução são essenciais para superar desafios. Ganha quem desvendar os enigmas mais complexos. ",
                R.color.primary_soft,
                ""
            ),
            Game(
                "Tesouro das Arcas Perdidas",
                "Uma disputa emocionante por riquezas escondidas em locais cheios de mistério. Os jogadores precisam explorar, coletar recursos e superar obstáculos ao longo do caminho. O planejamento estratégico faz toda a diferença na corrida pelo prêmio final. Vence quem acumular o maior valor em tesouros.",
                R.color.primary_soft,
                ""
            ),
            Game(
                "Cavernas e Dragões",
                "Um jogo de fantasia em que os participantes enfrentam criaturas lendárias e exploram masmorras perigosas. Cada jogador desenvolve habilidades e coleta itens para se fortalecer durante a jornada. O trabalho tático é essencial para sobreviver aos desafios. Ganha quem conquistar mais poder ou completar sua missão primeiro.",
                R.color.primary_soft,
                ""
            ),
        )

        val adapter = CardGameListAdapter(cardGames)
        recyclerView.adapter = adapter


        val input_search_games = findViewById<EditText>(R.id.input_search_games)

        input_search_games.setOnEditorActionListener { _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                val text = input_search_games.text.toString().trim()

                if (!text.isEmpty()) {

                    val db = FirebaseFirestore.getInstance()

                    db.collection("jogos")
                        .whereEqualTo("titulo", text)
                        .get()
                        .addOnSuccessListener { documentos ->

                            cardGames.clear()

                            for (documento in documentos) {
                                val title = documento.getString("titulo").toString()
                                val desc = documento.getString("descricao").toString()
                                val regras = documento.getString("regras").toString()


                                cardGames.add(
                                    Game(
                                        title,
                                        desc,
                                        R.color.primary_soft,
                                        regras
                                    )
                                )

                            }

                            adapter.notifyDataSetChanged()


                        }
                        .addOnFailureListener {

                            Toast.makeText(
                                this,
                                "Falha ao conectar com banco de dados",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }


                } else {

                    cardGames.clear()
                    cardGames.add(
                        Game("Expedição á Atlântida", "", R.color.primary_soft, "")
                    )

                    cardGames.add(
                        Game(
                            "O Código do Alquimista",
                            "Neste jogo, os participantes assumem o papel de aprendizes em busca de conhecimentos antigos e fórmulas secretas. É preciso decifrar pistas e combinar elementos de forma inteligente para avançar. A lógica e a dedução são essenciais para superar desafios. Ganha quem desvendar os enigmas mais complexos. ",
                            R.color.primary_soft,
                            ""
                        ),
                    )

                    cardGames.add(
                        Game(
                            "Tesouro das Arcas Perdidas",
                            "Uma disputa emocionante por riquezas escondidas em locais cheios de mistério. Os jogadores precisam explorar, coletar recursos e superar obstáculos ao longo do caminho. O planejamento estratégico faz toda a diferença na corrida pelo prêmio final. Vence quem acumular o maior valor em tesouros.",
                            R.color.primary_soft,
                            ""
                        ),
                    )

                    cardGames.add(
                        Game(
                            "Cavernas e Dragões",
                            "Um jogo de fantasia em que os participantes enfrentam criaturas lendárias e exploram masmorras perigosas. Cada jogador desenvolve habilidades e coleta itens para se fortalecer durante a jornada. O trabalho tático é essencial para sobreviver aos desafios. Ganha quem conquistar mais poder ou completar sua missão primeiro.",
                            R.color.primary_soft,
                            ""
                        ),
                    )


                }




                true
            } else {
                false
            }


        }


    }
}