package com.example.arrocha

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var numero: TextView
    private lateinit var btchutar: Button
    private lateinit var chute: EditText
    private lateinit var Intervalo: TextView
    private lateinit var IntervaloFinal: TextView

    private var num: Int = 0
    private var IntInicial: Int = 1
    private var IntFinal: Int = 100

    val GANHOU = 1
    val PERDEU = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.numero = findViewById(R.id.TvNumero)
        this.btchutar = findViewById(R.id.BtChute)
        this.chute = findViewById(R.id.EtChute)

        this.Intervalo = findViewById(R.id.Intervalo)
        this.IntervaloFinal = findViewById(R.id.Intervalo)

        gerar()

        this.btchutar.setOnClickListener(){
            val nchute = chute.text.toString().toInt()

            val LimiteInicialAnterior = num - 1
            val LimiteFinalAnterior = num + 1

            if ((nchute == num) or (nchute == IntInicial) or (nchute == IntFinal)){
                val it = Intent(this@MainActivity, Perdeu::class.java)
                startActivityForResult(it, PERDEU)
            } else {
                if(nchute < num){
                    IntInicial = nchute
                }
                if(nchute>num) {
                    IntFinal = nchute
                }
                if ((IntInicial == LimiteInicialAnterior) and (IntFinal == LimiteFinalAnterior )){
                    val it = Intent(this@MainActivity, Ganhou::class.java)
                    startActivityForResult(it, GANHOU)
                }

                Intervalo.setText("Chute entre o invervalo de " + IntInicial.toString() + " e " + IntFinal.toString())
            }
            chute.setText("")
        }
    }

    fun gerar(){
        num = Random.nextInt(2,100)
        Log.i("APP_ARROCHA", num.toString())

        IntFinal = 100
        IntInicial = 1
        Intervalo.setText("Chute entre o invervalo de " + IntInicial.toString() + " e " + IntFinal.toString())
    }

    override fun onRestart() {
        super.onRestart()
        gerar()
    }
}