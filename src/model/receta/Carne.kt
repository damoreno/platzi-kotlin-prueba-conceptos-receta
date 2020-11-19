package model.receta

class Carne: Ingrediente() {
    init { id = 2  }
    private val nombre: String = "Carne"

    override fun getNombre(): String {
        return nombre
    }
}