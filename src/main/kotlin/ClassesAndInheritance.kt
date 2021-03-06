import java.lang.Math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    with (squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    val roundHut = RoundHut(3, 10.0)
    with (roundHut) {
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    val roundTower = RoundTower(4, 15.5)
    with (roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    fun getRoom() {
        if (residents < capacity) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }

    abstract fun floorArea(): Double
}

// Do not declare residents as val, because you are reusing a property already declared in the parent class Dwelling.
// Declare the property as a val because the length of a building doesn't change.
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    /*
     * When you declare abstract functions and variables, it is like a promise that you will give them values and
     * implementations later. For a variable, it means that any subclass of that abstract class needs to give it a
     * value. For a function, it means that any subclass needs to implement the function body.
     */
    override val buildingMaterial = "wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = radius * 2
        return sqrt((diameter * diameter) / 2)
    }
}

/*
 *  By default, in Kotlin, classes are final and cannot be subclassed. You are only allowed to inherit from abstract
 *  classes or classes that are marked with the open keyword.
 *  Hence you need to mark the RoundHut class with the open keyword to allow it to be inherited from.
 */
/*
 * Alternatively, in the class definition of RoundTower, you can add a default value for floors as shown below.
 * Then, when no value for floors is passed into the constructor, the default value can be used to
 * create the object instance.
 */
class RoundTower(residents: Int, radius: Double,
    val floors: Int = 2) : RoundHut(residents, radius) {

    override val buildingMaterial = "stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}