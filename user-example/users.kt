data class User(val email: String, val fullName: String)

fun main(args: Array<String>) : Unit {
    val user = User("jane.doe@example.com", "Jane Doe")
    println(user)
}