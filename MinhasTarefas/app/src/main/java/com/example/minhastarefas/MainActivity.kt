package com.example.minhastarefas

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.atan

class MainActivity : AppCompatActivity() {
    private lateinit var lvTarefas: ListView
    private lateinit var btCadastrar: FloatingActionButton
    private lateinit var dao: TarefasDAO
    private lateinit var lista: ArrayList<Tarefa>

    private var CADASTRO = 1
    private var EDITAR = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvTarefas = findViewById(R.id.lvTarefas)
        btCadastrar = findViewById(R.id.btCadastrar)

        dao = TarefasDAO(this)
        this.lista = dao.get()

        this.lvTarefas.adapter = TarefaAdapter(this,lista)

        btCadastrar.setOnClickListener {
            add()
        }

        lvTarefas.onItemLongClickListener = clickLongo()
        lvTarefas.onItemClickListener = clickCurto()

    }

    fun add() {
        val intent = Intent(this@MainActivity, CadastroActivity::class.java)
        startActivityForResult(intent, CADASTRO)
    }

    fun atualiza() {
        lista.clear()
        lista.addAll(dao.get())
        (lvTarefas.adapter as BaseAdapter).notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CADASTRO) {
            if (resultCode == Activity.RESULT_OK) {
                val tarefa = data?.getSerializableExtra("TAREFA") as Tarefa
                this.dao.inserir(tarefa)
                lista.add(tarefa)
                atualiza()
                Log.i("APP_TAREFAS", this.dao.get().toString())
            }
        }
        if (requestCode == EDITAR){
            if (resultCode == Activity.RESULT_OK){
                val tarefa = data?.getSerializableExtra("TAREFA") as Tarefa
                dao.update(tarefa)
                atualiza()
                Log.i("APP_TAREFAS",dao.get().toString())
                Toast.makeText(this@MainActivity, "Tarefa Atualizada", Toast.LENGTH_SHORT).show()
            }
        }
    }
    inner class clickCurto(): AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val tarefa = lista.get(position)
            val intent = Intent(this@MainActivity, EditarActivity::class.java)
            intent.putExtra("TAREFA",tarefa)
            startActivityForResult(intent,EDITAR)
        }

    }

    inner class clickLongo() : AdapterView.OnItemLongClickListener {
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ): Boolean {
            val id = lista.get(position).id
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("Você está excluindo a tarefa ${position}")
            dialog.setPositiveButton("Confirmar") { dialogInterface, which ->
                dao.delete(id)
                lista.removeAt(position)
                atualiza()
                Toast.makeText(this@MainActivity, "Tarefa Deletada", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("Cancelar", null)
            dialog.create().show()
            return true
        }

    }

}