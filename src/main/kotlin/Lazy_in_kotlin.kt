
class Bike {
    init {
        println("The bike is built...")
    }

    fun ride() {
        println("Riding the bike...")
    }
}


fun lazyVariableFn() {
    val bike by lazy {
        Bike()
    }

    println("The first trip ------")
    var distances = listOf(5, 10, 8)
    distances.filter {
        it > 10
    }.forEach { _ ->
        bike.ride()
    }

    println("\nThe second trip ------")
    distances = listOf(5, 12, 15)
    distances.filter {
        it > 10
    }.forEach { _ ->
        bike.ride()
    }
}

fun main() {
    lazyVariableFn()
}

/*
The lazy keyword allows us to initialize the variable only if we need it.
In the above example, the variable is not initialized in the first trip at all since
the distance is always less than 10.
Whereas it is initialized in the second trip as the distance became greater than 10 in the list.
Another thing to note that, it is initialized only once and not everytime the distance has gone
over 10.

This keyword is useful while initializing heavy database objects.
The keyword allows us to initialize those only when we need it.
For efficient memory management, this is a useful operator.
*/