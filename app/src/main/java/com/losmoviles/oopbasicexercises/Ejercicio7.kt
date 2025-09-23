package com.losmoviles.oopbasicexercises

/**
 * Crea una clase CarritoDeCompras que contenga una lista de Producto.
 * Implementa un método total() que sume los precios,  otro agregarProducto() y eliminarProductoPorNombre().
 *
 */
class CarritoDeCompras{

    private var listaProductos = mutableListOf<Producto>()

    fun total(): Double {
        var total = 0.0

        for (producto in listaProductos){
            total += producto.precio
        }
        return total
    }

    fun agregarProducto(producto: Producto){
        listaProductos.add(producto)
    }
    /**
     * esta funcion va a eliminar todos los productos de la 'listaProductos' que coincidan con el nombre proporcionado.
     * La comparación de nombres no distingue entre mayúsculas y minúsculas.
     *
     * @param nombre El nombre del producto que se desea eliminar. Es un String (texto).
     * @return Devuelve 'true' si al menos un producto fue eliminado de la lista,
     *         o 'false' si ningún producto coincidió con el nombre y, por lo tanto,
     *         no se eliminó nada.
     */
    fun eliminarProductoPorNombre(nombre: String): Boolean{
        return listaProductos.removeAll { it.nombre.equals(nombre, ignoreCase = true) }
    }
}

open class Producto(val id: Int, val nombre: String, val precio: Double){

    fun verProducto(): String{
        return """
            INFO DEL PRODUCTO
            id del producto: $id
            nombre: $nombre
            precio: $precio 
        """.trimIndent()
    }
}

fun main() {

    val carrito1 = CarritoDeCompras()

    val producto1 = Producto(0,"Cebolla", 2300.00)
    val producto2 = Producto(1,"Lechuga", 4200.00)

    carrito1.agregarProducto(producto1)
    carrito1.agregarProducto(producto2)

    println(carrito1.total())

    carrito1.eliminarProductoPorNombre("cebolla")
    println(carrito1.total())
}
