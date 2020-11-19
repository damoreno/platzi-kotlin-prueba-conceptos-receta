package model.receta

 abstract class Ingrediente(){
    var cantidad: Int = 0
     var id:Int = 0

     fun getIdentificador(): Int {
         return id
     }

     abstract fun getNombre():String

}