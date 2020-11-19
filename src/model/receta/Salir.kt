package model.receta

class Salir: Ingrediente() {
    init { id = 10  }

    override fun getNombre(): String {
        return "Salir"
    }
}
