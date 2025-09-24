package com.losmoviles.oopbasicexercises
// Definimos el "paquete" donde vive nuestro código.
// Esto sirve para organizar el proyecto en módulos y carpetas, como si fueran cajones.

/**
 *
 * EJERCICIO:
 * Diseñar un sistema de gestión de estudiantes:
 *
 * Clase Estudiante(nombre, id, calificaciones: MutableList<Double>)
 * Método promedio()
 *
 * Clase Curso(nombre, listaEstudiantes: MutableList<Estudiante>)
 * Métodos en Curso: agregarEstudiante(), eliminarEstudiante(), mejorEstudiante()
 *
 * Usa todo lo aprendido: clases, data classes, colecciones, y métodos.
 *
 */

// Punto de entrada del programa
fun main() {
    // Por ahora está vacío, aquí podríamos crear cursos y estudiantes para probar.
}

// ---------------------- CLASE ESTUDIANTE ----------------------
class Estudiante {
    // Nombre del estudiante. Como es un "val", no se puede cambiar después de asignado.
    val nombre: String = ""

    // Identificación única del estudiante. También es un "val", por lo tanto no cambia.
    val id: Int = 0

    // Lista de calificaciones (ej: 3.5, 4.0, 5.0). Es mutable, porque las notas pueden variar.
    var calificaciones: MutableList<Double> = mutableListOf()

    // Método que calcula el promedio de las calificaciones del estudiante.
    fun promedioEstudiante(): Double {
        // Variable para acumular la suma de las notas.
        var totalNotas: Double = 0.0

        // Recorremos todas las calificaciones del estudiante.
        for (calificacion in calificaciones) {
            totalNotas += calificacion // vamos sumando cada nota.
        }

        // Dividimos la suma total entre la cantidad de notas para obtener el promedio.
        return totalNotas / calificaciones.size
    }
}

// ---------------------- CLASE CURSO ----------------------
class Curso {
    // Nombre del curso (ej: "Matemáticas", "Programación").
    val nombreCurso: String = ""

    // Lista de estudiantes inscritos en el curso.
    var listadoEstudiantes: MutableList<Estudiante> = mutableListOf()

    // Método para agregar un estudiante nuevo al curso.
    fun agregarEstudiante(newStudent: Estudiante) {
        listadoEstudiantes.add(newStudent) // Lo añadimos a la lista.
    }

    // Método para eliminar un estudiante existente del curso.
    fun eliminarEstudiante(student: Estudiante) {
        listadoEstudiantes.remove(student) // Lo quitamos de la lista.
    }

    // Método que devuelve el/los mejores estudiantes del curso (el de mayor promedio).
    fun mejorEstudiante(): List<Estudiante> {
        // Si la lista está vacía, devolvemos una lista vacía (no hay estudiantes).
        if (listadoEstudiantes.isEmpty()) return listOf()

        // Creamos una lista donde vamos a guardar a los mejores.
        var mejores: MutableList<Estudiante> = mutableListOf()

        // Por defecto, arrancamos con el primer estudiante como el mejor inicial.
        mejores.add(listadoEstudiantes.first())

        // Guardamos su promedio para compararlo con los demás.
        var mejorProm: Double = mejores.first().promedioEstudiante()

        // Recorremos toda la lista de estudiantes.
        for (estudiante in listadoEstudiantes) {
            // Si es el primero (ya lo tenemos como referencia), lo saltamos.
            if (estudiante.id == listadoEstudiantes[0].id) continue

            // Si encontramos un estudiante con promedio mayor, reemplazamos al mejor.
            if (estudiante.promedioEstudiante() > mejorProm) {
                mejores[0] = estudiante
                mejorProm = estudiante.promedioEstudiante()
            }
            // Si encontramos un estudiante con el mismo promedio, lo agregamos también.
            else if (estudiante.promedioEstudiante() == mejorProm) {
                mejores.add(estudiante)
            }
        }

        // Devolvemos la lista de mejores estudiantes (puede ser 1 o más).
        return mejores
    }
}
