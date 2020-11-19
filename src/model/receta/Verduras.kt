package model.receta

class Verduras: Ingrediente() {
    init { id = 4  }
    private val nombre:String = "Verduras"

    override fun getNombre(): String {
        return nombre
    }
}