

fun main(args: Array<String>) {
    if(listOf(2, 4).all { it % 2 == 0 }) {
        println("Process the even numbers")
    }
    if(listOf(1, 2, 0, 4).any { it  == 0 } ) {
        println("Throw ZeroContainingListException")
    }
    if(listOf(1, 2, 3, 4).none {  it == 0 }) {
        println("Process the positive numbers")
    }
}