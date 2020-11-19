package model.receta

class Fruta: Ingrediente() {
    init { id = 5 }

    override fun getNombre(): String {
       return "Fruta"
    }
}