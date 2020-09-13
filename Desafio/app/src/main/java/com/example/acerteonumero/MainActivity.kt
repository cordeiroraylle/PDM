package com.example.acerteonumero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var numeros: TextView
    private lateinit var dica1: TextView
    private lateinit var dica2: TextView
    private lateinit var dica3: TextView
    private lateinit var btchutar: Button
    private lateinit var chute: EditText

    private var num: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.numeros = findViewById(R.id.numeros)
        this.dica1 = findViewById(R.id.Dica1)
        this.dica2 = findViewById(R.id.Dica2)
        this.dica3 = findViewById(R.id.Dica3)
        this.btchutar = findViewById(R.id.btchutar)
        this.chute = findViewById(R.id.chute)


        gerar()

        this.btchutar.setOnClickListener(){
            val nchute = chute.text.toString().toInt()

                if (num == nchute){
                    Log.i("APP_ACERTE", "Voce acertou")

                    val janela = AlertDialog.Builder(this)
                    janela.setTitle("Acerte o Número")
                    janela.setMessage("Parabéns, você acertou!")
                    janela.create().show()


                } else{
                    Log.i("APP_ACERTE", "voce errou")
                    val janela = AlertDialog.Builder(this)
                    janela.setTitle("Acerte o Número")
                    janela.setMessage("Não foi dessa vez, o numero era "+ num.toString())
                    janela.create().show()
                }

            gerar()

            chute.setText("")
        }


    }

    fun gerar() {
        num = Random.nextInt(1, 100)
        Log.i("APP_ACERTE", num.toString())

        dicas()
    }

    fun dicas(){
        val divisores = arrayListOf<Int>()
        var contador = 0

        // verificar se é par ou impar
        if(num % 2 == 0){
           dica2.setText("O numero é par")
        } else {
            dica2.setText("O numero é impar")
        }

        //verificar divisores de 1 a 10
        for (i in 1..10){
            if (num % i == 0){
               divisores.add(i)
            }
        }
        dica1.setText("Os divisores, entre 1 e 10, desse numero sao:" + divisores.toString())

        // verificar divisores de 1 a n
        for (i in 1..num){
            if (num % i == 0){
                contador++
            }
        }
        dica3.setText("Esse numero tem "+ contador.toString()+" divisores")
    }

    override fun onRestart() {
        super.onRestart()
        gerar()
    }

}
