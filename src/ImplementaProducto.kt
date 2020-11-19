import model.Shoe

fun main() {
    var shoe = Shoe("Shoe","Blue Shoes", 12345, "Praga")
    println("Shoe: ${shoe}")
    shoe.size = 40
    shoe.create()
}