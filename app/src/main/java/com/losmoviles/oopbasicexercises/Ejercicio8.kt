package com.losmoviles.oopbasicexercises

/**
 * Requisitos:
 * - Clase Biblioteca con una lista de Libro.
 * - Métodos prestarLibro(titulo) y devolverLibro(titulo) que cambien el estado.
 * - Validaciones: no prestar si ya está prestado; no devolver si no está prestado.
 */

class Biblioteca {

    private val librosBiblioteca = mutableListOf<Libro>()

    fun agregarLibro(libro: Libro): Boolean {
        // Evitar duplicados por título (simple)
        val yaExiste = librosBiblioteca.any { it.titulo == libro.titulo }
        if (yaExiste) return false
        librosBiblioteca.add(libro)
        return true
    }

    /**
     * Intenta prestar un libro por título.
     * @return true si se prestó; false si no existe o ya estaba prestado.
     */
    fun prestarLibro(titulo: String): Boolean {
        // Busca en la lista de libros un libro cuyo título coincida con el parámetro recibido.
        // Si no lo encuentra, devuelve "false" inmediatamente (operador Elvis ?: ).
        val libro = librosBiblioteca.find { it.titulo == titulo } ?: return false

        // Si el libro ya está prestado, no se puede volver a prestar. Retorna "false".
        if (libro.prestado) return false

        // Si el libro existe y no está prestado, se cambia el estado a "true" (prestado).
        libro.prestado = true

        // Devuelve "true" para indicar que la operación fue exitosa.
        return true
    }

    /**
     * Intenta devolver un libro por título.
     * @return true si se devolvió; false si no existe o no estaba prestado.
     */
    fun devolverLibro(titulo: String): Boolean {
        // Busca en la lista un libro cuyo título coincida con el parámetro recibido.
        // Si no encuentra el libro, devuelve inmediatamente "false".
        val libro = librosBiblioteca.find { it.titulo == titulo } ?: return false

        // Si el libro NO está prestado (prestado == false), entonces no tiene sentido devolverlo.
        // En ese caso, retorna "false".
        if (!libro.prestado) return false

        // Si el libro existe y está prestado, cambia su estado a "false" (ya no está prestado).
        libro.prestado = false

        // Devuelve "true" para indicar que la devolución fue exitosa.
        return true
    }

    fun listarLibros(): List<Libro> = librosBiblioteca.toList()
}

class Libro(
    val titulo: String,
    val autor: String,
    var prestado: Boolean
) {
    fun verDetalles(): String = """
        Detalles de este libro:
        Título: $titulo
        Autor: $autor
        ¿Prestado?: $prestado
    """.trimIndent()
}

fun main() {
    val libro1 = Libro("Harry Potter", "J. K. Rowling", false)
    val libro2 = Libro("El retrato de Dorian Gray", "Oscar Wilde", false)
    val libro3 = Libro("Lucifer", "Autor X", false)

    val biblioteca = Biblioteca()

    // Agregar libros a la biblioteca
    println("Agregar libro1: ${biblioteca.agregarLibro(libro1)}")
    println("Agregar libro2: ${biblioteca.agregarLibro(libro2)}")
    println("Agregar libro3: ${biblioteca.agregarLibro(libro3)}")
    println("Intentar agregar duplicado (libro1): ${biblioteca.agregarLibro(libro1)}") // false

    // Prestar
    println("Prestar 'Harry Potter': ${biblioteca.prestarLibro("Harry Potter")}") // true
    println("Prestar 'Harry Potter' otra vez: ${biblioteca.prestarLibro("Harry Potter")}") // false
    println("Prestar libro inexistente: ${biblioteca.prestarLibro("No existe")} ") // false

    // Devolver
    println("Devolver 'Harry Potter': ${biblioteca.devolverLibro("Harry Potter")}") // true
    println("Devolver 'Harry Potter' otra vez: ${biblioteca.devolverLibro("Harry Potter")}") // false

    // Ver detalles de un libro
    println(libro1.verDetalles())

    // Listar libros
    println("\nListado de libros:")
    biblioteca.listarLibros().forEach { println("- ${it.titulo} | prestado=${it.prestado}") }
}
