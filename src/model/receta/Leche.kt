package model.receta

class Leche: Ingrediente() {
    init { id = 3  }
    private val nombre:String = "Leche"

    override fun getNombre(): String {
        return nombre
    }
}