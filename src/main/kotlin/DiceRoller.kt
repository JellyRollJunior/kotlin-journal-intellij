
fun main() {
    val firstDice = Dice(6)
    val secondDice = Dice(20)

    println("Your ${firstDice.getSides()} sided dice rolled ${firstDice.roll()}!")
    println("Your ${secondDice.getSides()} sided dice rolled ${secondDice.roll()}!")
}

class Dice(private val numSides : Int) {

    fun getSides(): Int {
        return numSides
    }

    fun roll(): Int {
        return (1..numSides).random()
    }
}