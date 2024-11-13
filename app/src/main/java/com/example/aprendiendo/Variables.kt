package com.example.aprendiendo
//Variables
fun main() {
    print("Hola\n")
    val age:Int = 123423
    val numeroLargo:Long = 34
    val numeroFloat:Float = 234f
    val doubleExample:Double = 234.0

    val caracter:Char = 'a' //comillas simples, CONSTANTE
    var variableString:String = "Hola" //comillas dobles VARIABLE
    val booleanas:Boolean = true
    fun getMonth(mes:Int) {
        when(mes) {
            1 -> println("Enero")
            2 -> println("Febrero")
            3 -> println("Marzo")
            4 -> println("Abril")
            5 -> println("Mayo")
            6 -> println("Junio")
            7 -> println("Julio")
            8 -> println("Agosto")
            9 -> println("Septiembre")
            10 -> println("Octubre")
            11 -> println("Noviembre")
            12 -> {
                println("Diciembre")
            }
            in 1..6 -> println("Primer semestre")
            !in 1..12 -> println("No es un mes")
        }
    }
getMonth(12)
    fun result(valor:Any):String{
        return when(valor){ // o val = when(valor), return val    o fun result(valor:Any) = when(valor)
            is Int-> {
                ("Esta wea es un int")
            }
            is String -> {
                ("Esta wea es un string")
            }
            is Boolean -> {
                ("Esta wea es un booleano")
            }
            is Double -> {
                ("Esta wea es un double")
            }
            is Float -> {
                ("Esta wea es un float")
            }
            else -> {
                return("No es nada")
            }
        }
    }

    println(result(123))
    println(result("Hola"))
}
