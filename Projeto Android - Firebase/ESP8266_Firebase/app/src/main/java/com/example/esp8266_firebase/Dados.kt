package com.example.esp8266_firebase

class Dados {
    var leitura: Int
    var status: String

    constructor(leitura: Int, status: String){
        this.leitura = leitura
        this.status = status
    }

}