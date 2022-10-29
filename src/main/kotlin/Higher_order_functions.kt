
/*
  A higher order function is a function that either takes a function as a parameter
  or returns a function as value or does both
*/

fun higherOrderNormalFunction(
    s: String,
    fn: (String) -> String
): String {
    return fn(s)
}

// higher order function on Collection (can be anything else also)
fun<T> List<T>.applyForEach(
    fn: (T) -> T
): List<T> {
    return mapTo(ArrayList(this.size), fn)
}

// we can give typealias to function types
typealias StringFunc = (String) -> String

fun typeAliasBasedHigherOrderFn(fn: StringFunc): String {
    return fn("Type alias based func")
}

// String.(Int) -> String  <=> (String, Int) -> String
// Such function type are interoperable with each other
val dotBasedFn : String.(Int) -> String = { integer -> "$integer and $this" }

fun invokeDotBasedHigherOrderFn(
    fn: (String, Int) -> String
) {
    println(fn("string", 2))
}


// trailing lambdas -- if the last argument of a function is a lambda then
// it can be invoked outside the parenthesis as well
fun trailingLambdaFn(
    s: String,
    fn: (String) -> String
): String {
    return fn(s)
}

fun main() {
    listOf("s").map { it + "s" }
    // normal invocation
    val result1 = higherOrderNormalFunction(
        s = "string",
        fn = { s ->
            println("Hi from the lambda function passed")
            "lambda processed $s"
        }
    )
    println("The result for higherOrderNormalFunction --> $result1")

    // invocation with lambda passed as variable
    val lambdaFn : (String) -> String = { s ->
        println("Hi from the lambda function passed")
        "lambda variable processed $s"
    }
    val result2 = higherOrderNormalFunction(
        s = "string",
        fn = lambdaFn
    )
    println("The result for higherOrderNormalFunction with lambda passed as variable --> $result2")

    // invocation of collection based function
    val list = listOf(1, 2, 3, 4)
    val updatedList = list.applyForEach { it * 10 }
    println("The updatedList --> $updatedList")

    // invocation of typealias based function
    val result3 = typeAliasBasedHigherOrderFn { s -> s }
    println("The result for typealias based higher order function --> $result3")

    // invocation of interchangeable function types
    println("The results for interchangeable function types based higher order functions --> ")
    println("string".dotBasedFn(2)) // String.(Int) -> String //OK
    invokeDotBasedHigherOrderFn(dotBasedFn) // (String, Int) -> String // OK

    // invocation of trailing lambda
    val result4 = trailingLambdaFn("string") { "trailing $it" }
    println("The result of the trailing lambda function --> $result4")
}