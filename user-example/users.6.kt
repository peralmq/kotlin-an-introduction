package example.six

data class User(val email: String, val fullName: String)

sealed class UserResult
data class UserSuccess(val users: List<User>) : UserResult()
data class UserFailure(val message: String) : UserResult()

fun fetchUsers(email: String) : UserResult {
    val users = listOf(
            User("jane.doe@example.com", "Jane Doe"),
            User("tolvan@example.com", "Tolvan Tolvansson"),
            User("tove.jansson@example.com", "Tove Janson")
    )

    val filteredUsers = users.filter { it.email == email }

    return if (filteredUsers.isNotEmpty()) {
        UserSuccess(filteredUsers)
    } else {
        UserFailure("No user found with email $email")
    }
}

fun main(args: Array<String>) : Unit {
    val result = fetchUsers("tolvan@example.com")

    when (result) {
        is UserSuccess -> result.users.forEach { println(it.fullName) }
        is UserFailure -> println(result.message)
    }
}