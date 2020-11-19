package model.receta

class Vacio: Ingrediente() {
    init { id = -1  }

    override fun getNombre(): String {
        return "Vacio"
    }
}