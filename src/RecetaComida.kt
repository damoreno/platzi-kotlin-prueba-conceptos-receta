fun main(args: Array<String>) {
    val salidaSistema =  {
        print("****** Salida de sistema ********")
    }
    var ingredientes: List<Int> = listOf()
    do {
        mostrarMenu()
        val opcion:String? = readLine()
        when(opcion){
            "1" -> ingredientes = crearReceta()
            "2" -> listarRecerta(ingredientes)
            "3" -> salidaSistema()
        }
    }while(!opcion.equals("3"))
}

fun listarRecerta(ingredientes : List<Int>) {

    if(ingredientes.isNotEmpty()){
        println("Listado de ingredientes: ")
        for (ingrediente in ingredientes){
            println("      Ingrediente: $ingrediente")
        }
    }else{
        println("***** NO SE HAN INGRESADO INGREDIENTES ******")
    }

}

fun crearReceta(): List<Int> {

    var listadoIngredientes: List<Int> = listOf();
    val menuIngredientes = """Hacer receta
            Selecciona por categoría el ingrediente que buscas
            1. Agua
            2. Leche
            3. Carne
            4. Verduras
            5. Frutas
            6. Cereal
            7. Huevos
            8. Aceites
            0. Salir
            Opcion escogida =
            """.trimMargin()
    do {
        print(menuIngredientes)
        val opcionReceta: Int = readLine()?.toIntOrNull() ?: -1
        when (opcionReceta) {
            in 1..8 ->  listadoIngredientes = listadoIngredientes.plus(opcionReceta)
            0 -> break
            else -> println(" !!!!!La opcion ingresada no es valida, intenete nuevamente!!!!")
        }
    }while(opcionReceta!=0)

    return listadoIngredientes
}

fun mostrarMenu() {
    val menu : String = """:: Bienvenido a Recipe Maker
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
        
    Opcion escogida = 
    """.trimMargin()
    print(menu)
}