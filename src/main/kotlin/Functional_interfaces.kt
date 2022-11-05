/*
Functional interfaces are basically an interface with only one abstract method.
An interface with more than one abstract methods has to be defined in the traditional way.

With the use of functional interface, we do not need to create classes for specific use cases which
implement the defined interface.
We can create an implementation dynamically using lambda expression.

Functional interfaces are useful when we need to create an interface which is going to have only
one abstract method.

Although we will barely come across any such use case where we want to create the implementations
dynamically.
*/

// normal interface
interface BikeRider {
    fun ride()
}

class YamahaRider : BikeRider {
     override fun ride() {
         println("Riding Yamaha with normal interface...")
     }
}

// functional interface
fun interface BikeRiderFuncI {
    fun ride()
}


fun main() {
    // normal interface
    YamahaRider().ride()

    // functional interface
    BikeRiderFuncI {
        println("Riding Yamaha with functional interface...")
    }.ride()
    BikeRiderFuncI {
        println("Riding Honda with functional interface...")
    }.ride()

}