
class Car {

    private val speedMonitor = mutableListOf<Int>()

    fun increaseSpeed(speed: Int) {
        speedMonitor.add(speed)
    }

    fun getSpeedMonitorData() = speedMonitor
}

fun carBuilder(
    builder: Car.() -> Unit
): Car {
    return Car().apply(builder)
}

fun main() {
    val car = carBuilder {
        increaseSpeed(10)
        increaseSpeed(20)
    }
    println(car.getSpeedMonitorData())

    // same thing done above can be done as follows as well
    val car2 = Car().apply {
        increaseSpeed(10)
        increaseSpeed(20)
    }
    println(car2.getSpeedMonitorData())
}