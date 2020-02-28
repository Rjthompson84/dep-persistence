package dep.persistence.transfer

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UserDtoTest {

    @Test
    fun testFields()
    {
        val userDto = UserDto()
        userDto.email = "newemail@email.com"
        userDto.firstName = "test"
        userDto.lastName = "test"

        assertEquals("newemail@email.com", userDto.email)
        assertEquals("test", userDto.firstName)
        assertEquals("test", userDto.lastName)
    }
}