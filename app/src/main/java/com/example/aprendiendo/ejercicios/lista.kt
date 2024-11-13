package com.example.aprendiendo.ejercicios

fun main() {
    val readOnly: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    //una lista siempre va a tener el mismo
    //tamano
    println(readOnly.size)
    println(readOnly)
    println(readOnly[0])
    println(readOnly.first())
    println(readOnly[readOnly.size - 1])
    println(readOnly.last())

    val ejemplo = readOnly.filter { it.contains("a") }
    println(ejemplo)
    readOnly.forEach { weekDay -> println(weekDay) }
    mutableList()
    var retornodelafuncion: String = mutableList()
    print(retornodelafuncion)
    readOnly.forEach { println(it) } // la manera mas sencilla de imprimir una lista
}
    fun mutableList(): String {
        var weekDays: MutableList<String> = mutableListOf("Lunes", "Martes")
        println(weekDays)
        weekDays.add("Miercoles")
        weekDays.add(0, "Dia del pico")
        println(weekDays)
        println(weekDays)
        println("El arreglo esta vacio? ${weekDays.isEmpty()}")
        return when  {
            weekDays.isEmpty() -> ("Esta vacio\n")
            else -> ("No Esta vacio\n")

        }
    }
