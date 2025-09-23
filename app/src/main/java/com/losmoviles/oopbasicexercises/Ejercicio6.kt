package com.losmoviles.oopbasicexercises

/**
 * Crea una clase abstracta Empleado con propiedad nombre y método abstracto calcularSalario().
 * Luego haz una data class para EmpleadoPorHoras y otra para EmpleadoFijo
 * Implementando la lógica de cálculo.
 */

abstract class Empleado(val id: Int = 0, val salarioPorHora: Double, val salarioDiario: Double){
    abstract var nombre: String

    var salario: Double = 0.0

    abstract fun calcularSalario(): Double // metodo abstracto

}

data class EmpleadoPorHoras(override var nombre: String): Empleado(id = 0, salarioPorHora = 25000.00, salarioDiario = 0.0){
    //suponiendo que empleado por horas trabaja 9 horas a la semana

    override fun calcularSalario(): Double {
        salario = salarioPorHora * 9
        return salario
    }
}

data class EmpleadoFijo(override var nombre: String): Empleado(id = 0, salarioPorHora = 0.0, salarioDiario = 100000.00){

    override fun calcularSalario(): Double {
        salario = salarioDiario * 22
        return salario
    }
}

fun main() {
    val empleadoPorHoras1 = EmpleadoPorHoras("Wilson")

    println("El empleado por horas ${empleadoPorHoras1.nombre} devenga un salario semanal de: $" + empleadoPorHoras1.calcularSalario() + "COP")

    val empleadoFijo1 = EmpleadoFijo("Hector")
    println("El empleado fijo ${empleadoFijo1.nombre} devenga un salario mensual de: $" + empleadoFijo1.calcularSalario() + "COP")

}