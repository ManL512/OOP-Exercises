package com.losmoviles.oopbasicexercises

fun main() {

}
class Estudiante {
    val nombre: String = ""
    val id: Int = 0
    var calificaciones: MutableList<Double> = mutableListOf()

    fun promedioEstudiante(): Double {
        var totalNotas: Double = 0.0
        for (calificacion in calificaciones) {
            totalNotas += calificacion
        }
        return totalNotas / calificaciones.size
    }
}

class Curso {
    val nombreCurso: String = ""
    var listadoEstudiantes: MutableList<Estudiante> = mutableListOf()

    fun agregarEstudiante(newStudent: Estudiante) {
        listadoEstudiantes.add(newStudent)
    }

    fun eliminarEstudiante(student: Estudiante) {
        listadoEstudiantes.remove(student)
    }

    fun mejorEstudiante(): List<Estudiante> {
        if (listadoEstudiantes.isEmpty()) return listOf()
        var mejores: MutableList<Estudiante> = mutableListOf()
        mejores.add(listadoEstudiantes.first())
        var mejorProm: Double = mejores.first().promedioEstudiante()

        for (estudiante in listadoEstudiantes) {
            if (estudiante.id == listadoEstudiantes[0].id) continue
            if (estudiante.promedioEstudiante() > mejorProm) {
                mejores[0] = estudiante;
                mejorProm = estudiante.promedioEstudiante()
            } else if (estudiante.promedioEstudiante() == mejorProm) {
                mejores.add(estudiante)
            }
        }
        return mejores
    }
}

