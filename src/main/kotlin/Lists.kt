

open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10) {

    override fun toString(): String {
        return name
    }
}

class Vegetables(vararg val toppings: String) : Item("Vegetables", 5) {

    override fun toString(): String {
        return if (toppings.isEmpty()) {
            "$name Chef's Choice"
        } else {
            name + " " + toppings.joinToString()
        }
    }
}

class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()

    fun addItem(item: Item): Order {
        itemList.add(item)
        return this
    }

    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }

    fun print() {
        println("Order #${orderNumber}")

        var total = 0
        for(item in itemList) {
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
    }
}

fun main() {
    val orderList = mutableListOf<Order>()

    val order1 = Order(1)
    order1.addItem(Noodles())
    orderList.add(order1)

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    orderList.add(order2)

    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    orderList.add(order3)

    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage, Onion"))
    orderList.add(order4)

    orderList.add(
        Order(5)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach"))
    )

    for (order in orderList) {
        order.print()
        println()
    }
}