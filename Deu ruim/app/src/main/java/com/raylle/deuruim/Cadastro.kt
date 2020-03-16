package com.raylle.deuruim

class Cadastro {
    private var lista: ArrayList<Evento>

    constructor(){
        this.lista = ArrayList()
    }

    fun add(evento: Evento){
        this.lista.add(evento)
    }

    fun get(): List<Evento>{
        return this.lista
    }

    fun count(): Int{
        return this.lista.size
    }
}