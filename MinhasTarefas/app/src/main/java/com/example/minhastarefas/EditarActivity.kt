package com.example.minhastarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import kotlin.math.log

class EditarActivity : AppCompatActivity() {

    private lateinit var etDescricao: EditText
    private lateinit var etPrioridade: EditText
    private lateinit var spStatus: Spinner
    private lateinit var btCancelar: Button
    private lateinit var btSalvar: Button
    private lateinit var tarefa: Tarefa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        etDescricao = findViewById(R.id.etEditarDescricao)
        etPrioridade = findViewById(R.id.etEditarPrioridade)
        spStatus = findViewById(R.id.spEditarStatus)
        btCancelar = findViewById(R.id.btEditarCancelar)
        btSalvar = findViewById(R.id.btEditarSalvar)

        this.btSalvar.setOnClickListener { salvar() }
        this.btCancelar.setOnClickListener { cancelar() }

        tarefa = intent.getSerializableExtra("TAREFA") as Tarefa
        Log.i("APP_TAREFA", tarefa.toString())

        if (tarefa != null) {
            etDescricao.setText(tarefa.descricao)
            etPrioridade.setText("1")
            when (tarefa.status) {
                "aberto" -> spStatus.setSelection(0)
                "executando" -> spStatus.setSelection(1)
                "concluido" -> spStatus.setSelection(2)
            }
        }
    }

    fun salvar() {

        val descricao = etDescricao.text.toString()
        val prioridade = etPrioridade.text.toString().toInt()
        val status = spStatus.selectedItem.toString()
        if (tarefa != null) {
            val tarefa = Tarefa(this.tarefa.id, descricao, prioridade, status)
            val intent = Intent()
            intent.putExtra("TAREFA", tarefa)
            setResult(RESULT_OK, intent)
        }
        finish()
    }

    fun cancelar() {
        finish()
    }
}