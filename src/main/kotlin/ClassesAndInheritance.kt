
fun main() {
    val squareCabin = SquareCabin(6)
    with (squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room? ${hasRoom()}")
    }

    val roundHut = RoundHut(3)
    with (roundHut) {
        println("\nRound Hut\n=========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
    }

    val roundTower = RoundTower(4)
    with (roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
    }
}

abstract class Dwelling(private var residents: Int) {

    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}

// Do not declare residents as val, because you are reusing a property already declared in the parent class Dwelling.
class SquareCabin(residents: Int) : Dwelling(residents) {
    /*
     * When you declare abstract functions and variables, it is like a promise that you will give them values and
     * implementations later. For a variable, it means that any subclass of that abstract class needs to give it a
     * value. For a function, it means that any subclass needs to implement the function body.
     */
    override val buildingMaterial = "wood"
    override val capacity = 6

}

open class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "straw"
    override val capacity = 4
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
class RoundTower(
    residents: Int,
    val floor: Int = 2) : RoundHut(residents) {
    override val buildingMaterial = "stone"
    override val capacity = 4 * floor
}