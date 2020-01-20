package dep.persistence.utils

import dep.persistence.entities.User
import dep.persistence.transfer.UserDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class UserUtilsTest {

    var userDto: UserDto = UserDto()

    @BeforeEach
    fun setUp() {
        userDto = UserDto()
        userDto.email = "email@email.email"
        userDto.firstName = "firstName"
        userDto.lastName = "lastName"
    }

    @Test
    fun testUpdate() {
        val userToUpdate = User("dave", "mcfly", "dave.mcfly@email.email", false)
        val updatedUser = UserUtils.update(userDto, userToUpdate)
        Assertions.assertNotEquals(userToUpdate.firstName, updatedUser.firstName)
        Assertions.assertNotEquals(userToUpdate.lastName, updatedUser.lastName)
        Assertions.assertNotEquals(userToUpdate.email, updatedUser.email)
    }
}