package com.example.kotlinlearning

fun main(args: Array<String>) {
    var a = 10
    a = 2 * a
    var website: String = "beginnersbook"
    //It is mandatory to specify the type in this case
    var website1: String
    website1 = "beginnersbook"
    val nb = 10;
    val s = "Hello"

    println("$a")
    println((s.plus(" " + nb)))

    /**
     * Kotlin datatypes - Byte, Short, Int, long, Float, Double, Boolean
     */
    val num1: Float
    num1 = 101.97F
    val num2: Double = num1.toDouble()
    println(num2)

    /**
     * Double to int type casting
     */
    println("4.554 to int: " + (4.554.toInt()))

    /**
     * int to Char type casting
     */
    println("66 to Char: " + (65.toChar()))

    /**
     * Char to int type casting
     */
    println("B to int: " + ('B'.toInt()))

    print("Write anything here in string: ")

    val enteredString = readLine()
    println("You have entered this: $enteredString")

    print("Write anything here in float: ")

    val num = readLine()
    println("You have entered this: $num")

    /**
     * This is how we declare long strings
     */
    val longString = """Welcome to
        Beginnersbook
        sdcsd
        ad
        adad
        ad
        ad
        sdfasdfewfw.com"""
    var arr = arrayOf(1, 22, "CPS")

    println("Index of 22: ${arr.indexOf(22)}")

    println(describe("Hello"))
}

fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }


/*  OUTPUT
20
Hello 10
101.97000122070312
4.554 to int: 4
66 to Char: A
B to int: 66
Write anything here in string: gaurav
You have entered this: gaurav
Write anything here in float: 955.3344
You have entered this: 955.3344
Index of 22: 1
Greeting
 */