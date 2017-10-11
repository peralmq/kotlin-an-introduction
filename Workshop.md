# Workshop
```
brew cask install java
brew install kotlin gradle
brew cask install intellij-idea-ce
```
## Example1.kt - Language feature basics
### Code:
```kotlin
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

```
### Run the Kotlin REPL:
```
kotlinc
```
## Example2.kt - Application entry point
### Code:
```kotlin
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
  val persons = listOf(Person("Alice"), Person("Bob", age=39))
  val oldest = persons.maxBy { it.age ?: 0 }
  println("$oldest is the oldest.") // Person(name=Bob, age=39) is the oldest.
}
```
### Run it:
```
kotlinc Example2.kt -include-runtime -d Example2.jar
java -jar Example2.jar
```
## Example3.kt - Web API
### Code:
```
git clone git@github.com:peralmq/tech-stacks.git
cd tech-stacks/stack_kotlin_spark
open -a /Applications/IntelliJ\ IDEA\ CE.app .

```
### Run it:
Run gradle from within IDEA:
![]()
or from the terminal:
```
gradle wrapper
./gradlew test
```
or via docker-compose:
```
cd ..
docker-compose up stack_kotlin_spark
```
## Example4.kt - Extended language features
### Code:
```kotlin
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
```
### Run the Kotlin REPL:
```
kotlinc
```

## Restricted keywords
https://kotlinlang.org/docs/reference/keyword-reference.html
