package com.example.minhastarefas

import android.content.ContentValues
import android.content.Context

class TarefasDAO {
    var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun inserir(tarefas: Tarefa){
        val cv = ContentValues()
        cv.put("descricao", tarefas.descricao)
        cv.put("prioridade", tarefas.prioridade)
        cv.put("status", tarefas.status)
        this.banco.writableDatabase.insert("tarefas",null, cv)
    }

    fun count(): Int{
        val colunas = arrayOf("id")
        val c = this.banco.readableDatabase.query("tarefas",colunas, null, null, null, null, null)

        return c.count
    }
    fun get(): ArrayList<Tarefa>{
        val lista = ArrayList<Tarefa>()
        val colunas = arrayOf("id", "descricao", "prioridade","status")
        val c = this.banco.readableDatabase.query("tarefas", colunas, null, null, null, null, null)
        if (c.count > 0){
            c.moveToFirst()
            do {
                val id = c.getInt(c.getColumnIndex("id"))
                val tarefas = c.getString(c.getColumnIndex("descricao"))
                val prioridade = c.getInt(c.getColumnIndex("prioridade"))
                val status = c.getString((c.getColumnIndex("status")))
                lista.add(Tarefa(id, tarefas, prioridade,status))
            }while (c.moveToNext())
        }
        c.close()
        return lista
    }
    fun get(id: Int): Tarefa?{
        return null

    }
    fun update(tarefa:Tarefa){
        val cv = ContentValues()
        val where = "id = ?"
        val wherep = arrayOf(tarefa.id.toString())
        cv.put("descricao", tarefa.descricao)
        cv.put("prioridade", tarefa.prioridade)
        cv.put("status",tarefa.status)
        this.banco.writableDatabase.update("tarefas",cv, where, wherep)
    }

    fun delete(id:Int){
        val where = "id = ?"
        val wherep = arrayOf(id.toString())
        this.banco.writableDatabase.delete("tarefas", where, wherep)
    }
}