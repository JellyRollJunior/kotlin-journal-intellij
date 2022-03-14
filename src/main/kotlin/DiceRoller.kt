
fun main() {
    val firstDice = Dice(6)
    val secondDice = Dice(20)

    //println("Your ${firstDice.getSides()} sided dice rolled ${firstDice.roll()}!")
    //println("Your ${secondDice.getSides()} sided dice rolled ${secondDice.roll()}!")

    val rollResult = firstDice.roll()
    val luckyNumber = 4
    when (rollResult) {
        luckyNumber -> println("Damn you good")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! You rolled a 6. Try again!")
    }
}

class Dice(private val numSides : Int) {

    fun getSides(): Int {
        return numSides
    }

    fun roll(): Int {
        return (1..numSides).random()
    }
}