package dep.persistence.repository

import dep.persistence.entities.User
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledIfSystemProperty
import javax.inject.Inject

@QuarkusTest
@DisabledIfSystemProperty(named = "profile", matches = "test")
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