package com.example.acerteonumero
import java.util.*

object Gerar {
    fun getInstance(): List<Int> {
        val random = Random()
        val numeros = mutableSetOf<Int>()

        numeros.add(random.nextInt(100) + 1)


        return numeros.toList().sorted()
    }
}