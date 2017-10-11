// Optionals
val nullableEmail: String? = null
var email: String = "alice@example.com"
email = null // error: null can not be a value of a non-null type String

// If not null shorthand `?`
val emailLength = nullableEmail?.length

// Elvis operator `?:`
nullableEmail ?: println("I'm null :(")

// Conditional execute `?.let`
nullableEmail?.let {
  println("I'm not null!")
}

// If, else
val success = true
if (success) {
  println("success")
} else {
  println("failure")
}

// Everything is an object
val result = if (success) {
  "success"
} else {
  "failure"
}
println(result) // success

// When
val number = 2
val numberString = when(number) {
    1 -> "one"
    2,3 -> "two or three"
    in 4..10 -> "between 4 and 10"
    else -> "something else"
}
println(numberString) // two or three

// Collections
val list = listOf(1, 2, 3) // or setOf
list.first() // 1
list.last() // 3
list.filter { it % 2 == 0 } // [2]
val map = mapOf(1 to "one", 2 to "two")
map[1] // "one"

// Ranges
for (i in 1..100) { ... }  // closed range: includes 100
if (x in 1..10) { ... }

// Automatic cast
fun autoCastStringLength(obj: Any): Int? {
  if (obj !is String) return null
  return obj.length // knows that obj is a String here
}

// Extension functions
fun String.spaceToCamelCase() { ... }
"Convert this to camelcase".spaceToCamelCase()

// Execute with special context - Standard.kt
class MyClass {
    fun test() {
        val str: String = "..."
        // with(str) { // run, with
        val result = str.xxx { // xxx can be let, run, apply, also
            print(this) // Receiver
            print(it) // Argument
            42 // Block return value
        }
    }
}
