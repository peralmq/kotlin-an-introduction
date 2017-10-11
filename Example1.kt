// Variables
val a: Int = 1
val b = 2
val c: Int
c = 3 // assign once == read-only

// Mutable
var x = 4
x += 1

// Functions
fun add(a: Int, b: Int): Int {
  return a + b
}
fun add(a: Int, b: Int) = a + b
fun add2(a: Int) = add(a, b=2)
add2(1) // 3

// Classes
class Person(val name: String) {
    fun speak(): String {
      return "Hello, my name is $name."
    }
}
val pelle = Person("Pelle")
pelle.speak() // Hello, my name is Pelle
