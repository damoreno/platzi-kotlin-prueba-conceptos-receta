package model.receta

class Agua: Ingrediente() {

    init { id = 1  }

    private val nombre:String="Agua"

    override fun getNombre(): String {
       return nombre
    }

}