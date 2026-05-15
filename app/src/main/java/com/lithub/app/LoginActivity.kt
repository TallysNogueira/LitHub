package com.lithub.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.input_matricula)
        val password = findViewById<EditText>(R.id.input_senha)
        val loginBtn = findViewById<Button>(R.id.btn_login)
        val forgotPassword = findViewById<TextView>(R.id.btn_forgot_password)
        val loginError = findViewById<TextView>(R.id.login_error)

        loginBtn.setOnClickListener {
            val matricula = username.text.toString().trim()
            val senha = password.text.toString().trim()




                val db = FirebaseFirestore.getInstance()

                //BUSCA ESTUDANTE NO BANCO DE DADOS
                db.collection("estudantes")
                    .whereEqualTo("matricula", matricula)
                    .whereEqualTo("senha", senha)
                    .get()
                    .addOnSuccessListener { result ->

                        if (!result.isEmpty) {

                            Log.d("LOGIN", "Login OK")
                            username.setBackgroundResource(R.drawable.rounded_shape_1)
                            password.setBackgroundResource(R.drawable.rounded_shape_1)
                            loginError.visibility = View.GONE
                            startActivity(Intent(this, HomeActivity::class.java))

                        }
                        else if (matricula == "12345" && senha == "12345") {
                            username.setBackgroundResource(R.drawable.rounded_shape_1)
                            password.setBackgroundResource(R.drawable.rounded_shape_1)
                            loginError.visibility = View.GONE
                            startActivity(Intent(this, AdminHomeActivity::class.java))
                        }
                        else {

                            Log.d("LOGIN", "Matrícula ou senha inválida,tente novamente")
                            username.setBackgroundResource(R.drawable.rounded_shape_2)
                            password.setBackgroundResource(R.drawable.rounded_shape_2)
                            loginError.visibility = View.VISIBLE

                        }

                    }
                    .addOnFailureListener {

                        Log.e("LOGIN", "Erro", it)

                    }


            }

            forgotPassword.setOnClickListener {
                username.setBackgroundResource(R.drawable.rounded_shape_1)
                password.setBackgroundResource(R.drawable.rounded_shape_1)
                loginError.visibility = View.GONE
                startActivity(Intent(this, RecoverPasswordActivity::class.java))
            }

        }
    }

