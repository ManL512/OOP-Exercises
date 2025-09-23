package com.losmoviles.oopbasicexercises

/**
 * ENCABEZADO EJERCICIO
 * Crea una clase Persona con propiedades nombre, edad y un método saludar().
 * 👉 Prueba instanciar varias personas y que el método imprima un saludo personalizado.
 *
 */

fun main() {

    val persona1 = Persona()
    persona1.nombre = "Javier"
    persona1.edad = 40

    println(persona1.saludar())

    val persona2 = Persona()
    persona2.nombre = "Angela"
    persona2.edad = 22

    println(persona2.saludar())
    
    
}

class Persona{
    var nombre: String = ""
    var edad: Int = 0
    
    fun saludar(): String{
        return "Hola! $nombre, tu tienes $edad años"
    }
}





