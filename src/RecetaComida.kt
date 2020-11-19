import model.receta.*

fun main(args: Array<String>) {
    val salidaSistema =  {
        print("****** Salida de sistema ********")
    }
    var recetas: List<Receta> = listOf()

    do {
        mostrarMenu()
        val opcion:String? = readLine()
        when(opcion){
            "1" -> recetas = recetas.plus(crearReceta())
            "2" -> listarRecertas(recetas)
            "3" -> salidaSistema()
        }
    }while(!opcion.equals("3"))
}

fun imprimeIngredientes(receta: Receta): String{
    var ingredientes = ""
    if(receta.ingredientes.isNotEmpty()){
        for (ingrediente in receta.ingredientes)
            ingredientes = ingredientes.plus("Ingrediente: ${ingrediente.getNombre()}\n")
    }
    else ingredientes.plus("***** NO SE HAN INGRESADO INGREDIENTES ******")

    return ingredientes
}

fun listarRecertas(recetas : List<Receta>) {

    if(recetas.isNotEmpty()){
        for (receta in recetas){
            println("Nombre de la receta: ${receta.nombre}")
            println("\nListado de ingredientes \n${imprimeIngredientes(receta)}")
        }
    }else  println("***** NO SE HAN INGRESADO RECETAS ******")

}

fun crearReceta(): Receta {

    val receta = Receta()
    var listadoIngredientesAgregados: List<Ingrediente> = listOf();
    val listadoIngredientesDisponibles: List<Ingrediente> = listadoIngredientes()


    print("\nIngresa nombre de la receta: ")
    receta.nombre = readLine() ?: "Sin nombre"

    var menuIngred = "\nSelecciona ingrediente\n"
    for (ing in listadoIngredientesDisponibles) {
        menuIngred = menuIngred.plus("\n${ing.getIdentificador()}. ${ing.getNombre()}")
    }
    menuIngred = menuIngred.plus("\nOpcion escogida = ")
    menuIngred = menuIngred.trimMargin()

    do {
        print(menuIngred)
        val opcionReceta: Int = readLine()?.toIntOrNull() ?: -1
        val ingredienteSeleccionado =
            (listadoIngredientesDisponibles.find{ ing -> opcionReceta == ing.getIdentificador() } ?: Vacio())  as Ingrediente
        when (ingredienteSeleccionado.getIdentificador()) {
            in 1..8 ->  listadoIngredientesAgregados = listadoIngredientesAgregados.plus(ingredienteSeleccionado)
            10 -> break
            else -> println(" !!!!!La opcion ingresada no es valida, intenete nuevamente!!!!")
        }
    }while(opcionReceta!=0)

    receta.ingredientes = listadoIngredientesAgregados
    return receta
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

fun listadoIngredientes(): List<Ingrediente> {
    return listOf(Leche(),Fruta(),Cereal(),Carne(), Verduras(), Salir(), Agua())
           .sortedBy { ing -> ing.getIdentificador() }
}