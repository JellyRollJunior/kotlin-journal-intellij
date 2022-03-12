fun main() {
    val name = "Terry"
    val age = 5
    val times = 30
    val layers = 5

//    // cake
//    println("   ,,,,,   ")
//    println("   |||||   ")
//    println(" =========")
//    println("@@@@@@@@@@@")
//    println("{~@~@~@~@~}")
//    println("@@@@@@@@@@@")

    // cake 2
    printCakeCandles(age)
    printCakeTop(age)
    printCakeBot(age, layers)

    // line break
    println("")

    printBorder(times);
    println("congrats $name on turning ${age}!")
    println("stay old idiot!")
    printBorder(times);
}

fun printCakeCandles(age : Int) {
    print(" ")
    repeat(age) {
        print(",")
    }
    println()

    print(" ")
    repeat(age) {
        print("|")
    }
    println()
}

fun printCakeTop(age : Int) {
    repeat(age + 2) {
        print("=")
    }
    println()
}

fun printCakeBot(age : Int, layers : Int) {
    repeat(layers) {
        repeat(age + 2) {
            print("@")
        }
        println()
    }
}


fun printBorder(times : Int) {
    repeat(times) {
        print("=")
    }
    println("")
}