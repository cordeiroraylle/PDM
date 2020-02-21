package com.example.expobre

import java.util.*

object Megasena {
    fun getInstance(): List<Int>{
        val random = Random()
        val numeros = mutableSetOf<Int>()

        while(numeros.size < 6){
            numeros.add(random.nextInt(60)+1)
        }

        return numeros.toList().sorted()
    }
}