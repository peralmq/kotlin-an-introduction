package example.two

data class User(val email: String, val fullName: String)

fun fetchUsers(email: String) : List<User> {
    val users = listOf(
            User("jane.doe@example.com", "Jane Doe"),
            User("tolvan@example.com", "Tolvan Tolvansson"),
            User("tove.jansson@example.com", "Tove Janson")
    )

    return users.filter { it.email == email }
}

fun main(args: Array<String>) : Unit {
    val users = fetchUsers("jane.doe@example.com")

    users.forEach {println(it.fullName)}
}