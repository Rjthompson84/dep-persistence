package dep.persistence.entities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun testFields()
    {
        val user = User(id = 1L)
        user.firstName = "test"
        user.lastName = "test"
        user.email = "email@email.email"
        assertEquals(user.id, 1L)
        assertEquals(user.firstName, "test")
        assertEquals(user.lastName, "test")
        assertEquals(user.email, "email@email.email")
    }
}