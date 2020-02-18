package com.example.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvNumeros: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvNumeros = findViewById(R.id.tvNumeros)


        this.button = findViewById(R.id.button)
        this.button.setOnClickListener(){
            this.tvNumeros.text = Megasena.getInstance().joinToString("  ") //text pq vou ta atribuindo algo ao texto
        }
    }
}
