package com.example.minhastarefas

import java.io.Serializable

class Tarefa:Serializable {
    var id: Int
    var descricao: String
    var prioridade: Int
    var status: String

    constructor(descricao: String, prioridade: Int, status: String){
        this.id = -1
        this.descricao = descricao
        this.prioridade = prioridade
        this.status = status
    }

    constructor(id: Int, descricao: String, prioridade: Int, status: String){
        this.id = id
        this.descricao = descricao
        this.prioridade = prioridade
        this.status = status
    }

    override fun toString(): String {
        return "${this.descricao} - " +
                " ${this.prioridade} - Status: ${this.status}"
    }
}