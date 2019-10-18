/*
Kotlin Basics

This code is the compilable version of the Kotlin basics tutorial.
 */


//Main
fun main() {

    //Printing
    println("Hello World")
    print("Hello World")
    println("!") //Prints ! on previous line since the previous line does not have a new line. Following this there will be a new line

    //Variables
    var helloWorld = "Hello World"
    helloWorld = "Hello World!"

    //Constants
    val language = "Kotlin"
    // language = "Java" will not work because language is a constant

    //Functions
    sayHelloWorld()
    println(getHelloWorld())
    customGreeting("John")
    println(sum(2, 3))

    //String templates
    var a = 2
    var s1 = "$a"
    println(s1)

    //Expressions in strings
    var b = 1
    val s2 = "${b + 2}"
    println(s2)

    //Conditional Statement (if-elseif-else)
    val c = 1
    val d = 2
    if (c < d) {
        println(c)
    } else if (d < c) {
        println(d)
    } else {
        println("equal")
    }



}

//Functions
fun sayHelloWorld() {
    println("Hello World from a function")
}

//Return a value
fun getHelloWorld(): String {
    return "Hello World from a returned value"
}

//Pass arguments
fun customGreeting(name: String) {
    println("Hello ${name}")
}

//Expression body and inferred type
fun sum(a: Int, b: Int) = a + b

//Comments
//This is a single line comment
/*
This is a multiline comment.
I can write multiple lines like this.
 */
/*

I can nest comments
    /*
    Like this
    */
*/

//Conditional Expression
fun maxOf(a: Int, b: Int) = if (a > b) a else b








