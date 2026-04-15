package com.lithub.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginBtn: Button
    lateinit var btn_forgot_password: TextView
    lateinit var login_error: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.input_matricula)
        password = findViewById(R.id.input_senha)
        loginBtn = findViewById(R.id.btn_login)
        btn_forgot_password = findViewById(R.id.btn_forgot_password)
        login_error = findViewById(R.id.login_error)

    }

    override fun onStart() {
        super.onStart()
        loginBtn.setOnClickListener {
            evalLogin();
        }
        btn_forgot_password.setOnClickListener {
            recuperarSenha();
        }



    }

    //Função para validar login do usuário
    fun evalLogin(){
        if (username.text.toString() == "123" && password.text.toString() == "123"){

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                username.setBackgroundResource(R.drawable.rounded_shape_1)
                password.setBackgroundResource(R.drawable.rounded_shape_1)
                login_error.visibility = View.GONE

        }
        else{
            username.setBackgroundResource(R.drawable.rounded_shape_2)
            password.setBackgroundResource(R.drawable.rounded_shape_2)
            login_error.visibility = View.VISIBLE
        }

    }

    //Redireciona o usuário para a tela de recuperar senha
    fun recuperarSenha(){

        val intent = Intent(this, RecoverPasswordActivity::class.java)
        startActivity(intent)
        username.setBackgroundResource(R.drawable.rounded_shape_1)
        password.setBackgroundResource(R.drawable.rounded_shape_1)
        login_error.visibility = View.GONE
    }

}