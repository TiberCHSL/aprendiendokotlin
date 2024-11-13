package com.example.aprendiendo.ejercicios

fun main() {
    var name:String = "Juan"
    var name1:String = "Yohan"
    var name2:String = "Yoh"
    var name3:String = "hans"
    var name4:String = "onana"

    val weekDays = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes")
    println(weekDays.size)
    for (day in weekDays.indices) {
        println(weekDays[day])
    }
    for (i in 1..10) {
        //println(i)

    }
    for ((position, value) in weekDays.withIndex()) {
        println("La posicion $position, contiene $value")

    }
    for (day in weekDays) {
        println("Ahora es $day")
    }
}