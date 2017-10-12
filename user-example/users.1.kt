package example.one

data class User(val email: String, val fullName: String)

fun fetchUsers() : List<User> {
    val users = listOf(
            User("jane.doe@example.com", "Jane Doe"),
            User("tolvan@example.com", "Tolvan Tolvansson"),
            User("tove.jansson@example.com", "Tove Janson")
    )

    return users
}

fun main(args: Array<String>) : Unit {
    val users = fetchUsers()

    users.forEach {println(it.fullName)}
}