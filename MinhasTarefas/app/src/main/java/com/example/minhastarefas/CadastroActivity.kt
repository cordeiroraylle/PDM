package com.example.minhastarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class CadastroActivity : AppCompatActivity() {

    private lateinit var etDescricao: EditText
    private lateinit var etPrioridade: EditText
    private lateinit var btCancelar: Button
    private lateinit var btSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        etDescricao = findViewById(R.id.etDescricao)
        etPrioridade = findViewById(R.id.etPrioridade)
        btCancelar = findViewById(R.id.btCancelar)
        btSalvar = findViewById(R.id.btSalvar)

        this.btSalvar.setOnClickListener{salvar (it)}
        this.btCancelar.setOnClickListener{ limpar(it)}

    }

    private fun salvar(it: View) {

        val descricao = etDescricao.text.toString()
        val prioridade = etPrioridade.text.toString().toInt()

        val tarefa = Tarefa(descricao, prioridade, "aberto")


        val intent = Intent()
        intent.putExtra("TAREFA", tarefa)
        setResult(RESULT_OK,intent)
        finish()
    }

    private fun limpar(it: View) {
        this.etDescricao.text.clear()
        this.etPrioridade.text.clear()
        this.etDescricao.requestFocus()
        finish()
    }
}