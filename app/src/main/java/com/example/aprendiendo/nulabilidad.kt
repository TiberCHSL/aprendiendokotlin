package com.example.aprendiendo

fun main() {
    var nombre: String? = null
    nombre = null

    //println(!!nombre[4]) // La variable no sera nula por ningun motivo
    println(nombre?.get(3) ?: "Es nulo") // si nombre no es nulo haz algo
}