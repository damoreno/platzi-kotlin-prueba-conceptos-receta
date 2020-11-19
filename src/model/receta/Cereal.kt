package model.receta

class Cereal: Ingrediente() {

    init { id = 6  }
    private val nombre: String = "Cereal"

    override fun getNombre(): String {
        return nombre
    }
}