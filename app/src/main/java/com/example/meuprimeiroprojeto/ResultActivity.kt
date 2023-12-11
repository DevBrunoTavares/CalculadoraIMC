package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        var classificacao = ""
        if(result < 18.5f){
            classificacao = "Ixee, você esta abaixo do peso"
        }else if(result >= 18.5f && result <= 24.9f){
            classificacao = "Olha, muito bem você esta no peso ideal"
        }else if(result >= 25f && result <= 29.9f){
            classificacao = "Opa voce esta um pouco acima do peso"
        }else if(result >= 30 && result <= 39.9f){
            classificacao = "Eita, você esta acima do peso ideal, chega de comer besteira ein "
        }else {
            classificacao = "Você está com obesidade grave"

        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}