package com.lithub.app

import android.app.AlertDialog
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class GamesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val cardGames = listOf<Game>(
            Game("Expedição á Atlântida","",R.color.primary_soft,""),
            Game("O Código do Alquimista","Neste jogo, os participantes assumem o papel de aprendizes em busca de conhecimentos antigos e fórmulas secretas. É preciso decifrar pistas e combinar elementos de forma inteligente para avançar. A lógica e a dedução são essenciais para superar desafios. Ganha quem desvendar os enigmas mais complexos. ",R.color.primary_soft,""),
            Game("Tesouro das Arcas Perdidas","Uma disputa emocionante por riquezas escondidas em locais cheios de mistério. Os jogadores precisam explorar, coletar recursos e superar obstáculos ao longo do caminho. O planejamento estratégico faz toda a diferença na corrida pelo prêmio final. Vence quem acumular o maior valor em tesouros.",R.color.primary_soft,""),
            Game("Cavernas e Dragões","Um jogo de fantasia em que os participantes enfrentam criaturas lendárias e exploram masmorras perigosas. Cada jogador desenvolve habilidades e coleta itens para se fortalecer durante a jornada. O trabalho tático é essencial para sobreviver aos desafios. Ganha quem conquistar mais poder ou completar sua missão primeiro.",R.color.primary_soft,""),
        )

        recyclerView.adapter = CardGameListAdapter(cardGames)







    }


}