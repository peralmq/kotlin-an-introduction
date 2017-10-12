package example.three

data class User(val email: String, val fullName: String)

data class UserSuccess(val users: List<User>)

fun fetchUsers(email: String) : UserSuccess {
    val users = listOf(
            User("jane.doe@example.com", "Jane Doe"),
            User("tolvan@example.com", "Tolvan Tolvansson"),
            User("tove.jansson@example.com", "Tove Janson")
    )

    val filteredUsers = users.filter { it.email == email }

    return UserSuccess(filteredUsers)
}

fun main(args: Array<String>) : Unit {
    val result = fetchUsers("jane.doe@example.com")

    result.users.forEach {println(it.fullName)}
}