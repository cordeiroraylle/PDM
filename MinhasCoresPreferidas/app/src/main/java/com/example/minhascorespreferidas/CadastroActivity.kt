package com.example.minhascorespreferidas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CadastroActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etCodigo: EditText
    private lateinit var btCancelar: Button
    private lateinit var btSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        etNome = findViewById(R.id.etCadastroNome)
        etCodigo = findViewById(R.id.etCadastroCodigo)
        btCancelar = findViewById(R.id.btCadastroCancelar)
        btSalvar= findViewById(R.id.btCadastroSalvar)

        btSalvar.setOnClickListener{salvar()}
        btCancelar.setOnClickListener{cancelar()}

    }

    fun salvar(){
        val nome = etNome.text.toString()
        val codigo = etCodigo.text.toString()
        val cor = Cor(nome,codigo)

        val intent = Intent()
        intent.putExtra("COR",cor)
        setResult(RESULT_OK,intent)
        finish()
    }

    fun cancelar(){
        finish()
    }
}