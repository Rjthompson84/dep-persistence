package dep.persistence.repository

import dep.persistence.DepIntegrationTest
import dep.persistence.entities.User
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@DepIntegrationTest
class UserRepositoryTest {

    @Inject
    lateinit var userRepository: UserRepository

    @BeforeEach
    fun setUp() {
        userRepository.save(User("dave", "mcdave", "emaily@mcemail.com"))
    }

    @Test
    fun findByEmail() {
        val user = userRepository.findByEmail("emaily@mcemail.com")
        assertEquals(user.firstName, "dave")
        assertEquals(user.lastName, "mcdave")
    }
}